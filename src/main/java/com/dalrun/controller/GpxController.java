package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxDataDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.dto.GpxParam;
import com.dalrun.service.DiaryService;
import com.dalrun.service.GpxDataService;
import com.dalrun.service.GpxFilesService;
import com.dalrun.util.GpxParserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GpxController {

	@Autowired
	GpxFilesService gfService;
	
	@Autowired
	GpxDataService gdService;
	
	@Autowired
	DiaryService dService;
	
	// 공통 pageNumber
	private void pageNumber(GpxParam param) {
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11 21
		int end = (pn + 1) * 10;	// 10 20 30
		
		param.setStart(start);
		param.setEnd(end);
	}
	
	// 공통 리스트
	private Map<String, Object> getList(List<?> list, int cnt) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt); // wrapper 형태로 들어 감
		
		return map;
	}
	
//	// gpx 데이터 로드
//	@GetMapping(value="gpxList")
//	public Map<String, Object> gpxList(GpxParam param){
//		
//		System.out.println("GpxController gpxList " + new Date());
//		
//		List<GpxDataDto> list = gdService.gpxDataList(param);
//		int len = dService.getAllDiary(param);
//		
//		return getList(list, len);
//	}
	
	
	
	// gpx 파일 업로드
	@PostMapping(value="/gpxUpload")
	public String gpxUpload (@ModelAttribute DiaryDto diary,
							 @RequestParam(value = "gpxFile")MultipartFile gpxFile,
							 HttpServletRequest req) {
		
		System.out.println("GpxController gpxUpload " + new Date());
		System.out.println(diary.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/gpx");
		
		// new 파일 명 : 업로드 시간(초 단위까지) + 멤버ID 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = diary.getPostId() + "_" + diary.getMemId() + "_" + now + ".gpx";
		
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println(" gpxFile path:" + filePath); // 경로 확인
		
		// diary 작성일 Dto에 저장
		diary.setWdate(LocalDateTime.now().withNano(0)); // 초 단위까지 저장
		
		// diary Service => insert 성공 여부
		boolean diaryResult = dService.insertDiary(diary);
		System.out.println("diary insert result: " + diaryResult);
		
		if (diaryResult) {
			
			// gpxFiles DTO 객체에 값 저장
			GpxFilesDto gpx = new GpxFilesDto();
			gpx.setMemId(diary.getMemId());
			gpx.setDiarySeq(diary.getDiarySeq());
			gpx.setFilePath(filePath);
			gpx.setFileName(fileName);
			gpx.setUploadDate(new Date());
			
			// gpxFiles Service => insert 성공 여부
			boolean fileResult = gfService.insertGpxFile(gpx);
			System.out.println("gpxfile insert result: " + fileResult);
		
			if (fileResult) {
				// 파일 저장
				File file = new File(filePath);
				try {
					
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(gpxFile.getBytes());
					bos.close();
					
					// Gpx Data 파싱하여 DB에 저장
					List<GpxDataDto> points = GpxParserUtil.parseGPXFile(file);
					double totalD = 0;	// 총 거리 초기화
					double totalT = 0;	// 총 시간 초기화
					double maxSlope = 0;	// 총 경사도 초기화
					int length = 0;
					
					
					for (GpxDataDto point : points) {
					    GpxDataDto gpxData = new GpxDataDto();
					    gpxData.setFileSeq(gpx.getFileSeq());
					    gpxData.setDiarySeq(diary.getDiarySeq());
					    gpxData.setMemId(gpx.getMemId());
					    gpxData.setLatitude(point.getLatitude());
					    gpxData.setLongitude(point.getLongitude());
					    gpxData.setAltitude(point.getAltitude());
					    gpxData.setDistance(point.getDistance());
					    gpxData.setmTime(point.getmTime());
					    gpxData.setTimeDiff(point.getTimeDiff());
					    gpxData.setSlope(point.getSlope());
					    
					    totalD += point.getDistance();
					    totalT += point.getTimeDiff();
					    if(maxSlope < point.getSlope()) {
					    	maxSlope = point.getSlope();
					    }
					    boolean result = gdService.insertGpxData(gpxData);

					    if (!result) { // insert 실패 시
					    	System.out.println("gpxData insert 실패!");
					        return "gpxData insert Fail";
					    }
					}
					
					// 칼로리 계산
					double kcal = ((3.5/60)*7*60*totalT/1000)*5;
					// ((산소3.5ml/60s) * met(s) * 몸무게(kg) * 운동시간(s)) * 산소 1L 당 5kcal, 조깅 met(s)= 7
					
					// 평균 페이스, 경사도 구하기
					double meanPace = (totalT/60) / (totalD/1000); // 분/km
					
					// score 계산
					int score = 0;
					if((totalD/1000) <= 5) {
					    score += 1;
					} else if ((totalD/1000) <= 20000) {
					    score += (int)(totalD/1000) - 4;
					} else {
					    score += 16;
					};

					if(meanPace >= 7) {
					    score += 1;
					} else if(meanPace >= 6) {
					    score += 2;
					} else if(meanPace >= 5) {
					    score += 3;
					} else {
					    score += 5;
					};

					
					// 총 이동거리,시간,칼로리 Dto에 저장
					diary.setTotalDist(totalD);
					diary.setTotalTime(totalT);
					diary.setMeanPace(meanPace);
					diary.setMaxSlope(maxSlope);
					diary.setScore(score);
					diary.setKcal(kcal);
					// DB에 저장
					boolean recordResult = dService.updateRecord(diary);
					System.out.println("다이어리 추가 정보 : " + recordResult);
					
					
					// 저장한 데이터들 내보내기
					List<GpxDataDto> data = gdService.getGPXData(gpx.getFileSeq());
					// List를 JSON 형식으로 변환
					ObjectMapper objectMapper = new ObjectMapper();
					String json;
					try {
				        json = objectMapper.writeValueAsString(data);
				    } catch (Exception e) {
				        e.printStackTrace();
				        return "데이터 JSON 변환 실패!";
				    }
					
					
					System.out.println("모든 업로드 성공!");
	                return json;

	            } catch (Exception e) {	// 파일 저장 실패 시
	            	System.out.println("gpxFile 저장 실패!");
	                return "Upload Fail";
	            }
	        } else {
	        	System.out.println("gpxFile insert 실패!");
	            return "gpxFile Insert Fail";
	        }
	    } else {
	    	System.out.println("diary insert 실패!");
	        return "diary Insert Fail";
		}
	}	// <GPX Upload/>
	
	
	// 네이버맵에 gpxData 보내주기
	@GetMapping(value="/gpxDataList")
	public List<GpxDataDto> gpxDataList(@RequestParam String diarySeqList) {
	    List<Integer> diarySeqListInt = Arrays.stream(diarySeqList.split(","))
	      .map(Integer::valueOf)
	      .collect(Collectors.toList());
	    System.out.println("GpxController gpxDataList : " + new Date());
	    return gdService.gpxDataList(diarySeqListInt);
	}

	
}	// <Gpx Controller />
