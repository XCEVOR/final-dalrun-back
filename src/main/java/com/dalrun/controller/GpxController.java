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

import com.dalrun.dto.CourseDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxDataDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.dto.GpxParam;
import com.dalrun.dto.UserCourseDto;
import com.dalrun.service.CourseService;
import com.dalrun.service.DiaryService;
import com.dalrun.service.GpxDataService;
import com.dalrun.service.GpxFilesService;
import com.dalrun.service.MemberService;
import com.dalrun.service.UserCourseService;
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
	
	@Autowired
	CourseService cService;
	
	@Autowired
	UserCourseService uService;
	
	@Autowired
	MemberService mService;
	
	/* diary */
	// TODO :diary gpx 파일 업로드
	@PostMapping(value="/gpxUpload")
	public String gpxUpload (@ModelAttribute DiaryDto diary,
							 @RequestParam(value = "gpxFile")MultipartFile gpxFile,
							 HttpServletRequest req) {
		
		System.out.println("GpxController gpxUpload " + new Date());
		System.out.println(diary.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/dalrun-jw/gpx");
		
		// new 파일 명 : diary_시간_작성자ID.gpx
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = "diary" + "_" + now + diary.getMemId() + ".gpx"; 
		
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println(" gpxFile path:" + filePath); // 경로 확인
		
		// diary 작성일 Dto에 저장
		diary.setWdate(LocalDateTime.now().withNano(0)); // 초 단위까지 저장
		System.out.println("크루 시퀀스" + diary.getCrewSeq());
		// diary Service => insert 성공 여부
		boolean diaryResult = dService.insertDiary(diary);
		
		if (diaryResult) {
			
			// gpxFiles DTO 객체에 값 저장
			GpxFilesDto gpx = new GpxFilesDto();
			gpx.setMemId(diary.getMemId());
			gpx.setDiarySeq(diary.getDiarySeq());
			gpx.setFilePath(filePath);
			gpx.setFileName(fileName);
			gpx.setUploadDate(new Date());
			
			// gpxFiles Service => insert 성공 여부
			boolean fileResult = gfService.insertDiaryGpxFile(gpx);
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
					if((totalD/1000) <= 5) { // 거리 km로 환산
					    score += 1;
					} else if ((totalD/1000) <= 20) {	// km로 환산
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
					
					
					boolean plusPostPointResult = mService.plusPostPoint(diary.getMemId());
					System.out.println("다이어리 업로드 포인트 추가 : " + plusPostPointResult);
//					// 저장한 데이터들 내보내기
//					List<GpxDataDto> data = gdService.getGPXData(gpx.getFileSeq());
//					// List를 JSON 형식으로 변환
//					ObjectMapper objectMapper = new ObjectMapper();
//					String json;
//					try {
//				        json = objectMapper.writeValueAsString(data);
//				    } catch (Exception e) {
//				        e.printStackTrace();
//				        return "데이터 JSON 변환 실패!";
//				    }
					
					
					System.out.println("모든 업로드 성공!");
	                return "Upload Success";

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
	
	
	// TODO : 네이버맵에 gpxData 보내주기
	@GetMapping(value="/gpxDataList")
	public List<GpxDataDto> gpxDataList(@RequestParam String diarySeqList) {
	    System.out.println("GpxController gpxDataList : " + new Date());

	    
	    // 배열로 보내면 오류나서 String으로 받아서 다시 리스트로 삽입
	    List<Integer> diarySeqListInt = Arrays.stream(diarySeqList.split(","))
	  	      .map(Integer::valueOf)
	  	      .collect(Collectors.toList());
	    
	    return gdService.gpxDataList(diarySeqListInt);
	}
	
	/* admin 코스 */
	// TODO : 추천 코스 업로드
	@PostMapping(value="/adminCourseUpload")
	public String courseUpload (@ModelAttribute CourseDto course,
								@RequestParam(value= "gpxFile")MultipartFile gpxFile,
								@RequestParam(value= "imgFile")MultipartFile imgFile,
								HttpServletRequest req) {
		
		System.out.println("GpxController adminCourseUpload " + new Date() );
		System.out.println(course.toString());
		
		// gpx 파일 저장 경로 설정 server 단
		String gpxPath = req.getServletContext().getRealPath("/dalrun-jw/gpx");
		// 이미지 파일 저장 경로 설정
		String imgPath = req.getServletContext().getRealPath("/dalrun-jw/courseThumb");
		
		// 파일 확장자 명
		String ogFilename = imgFile.getOriginalFilename(); // 기존 파일 명
		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명
				
		// new 파일 명 : course_지역번호_코스명.gpx
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String gpxFileName = "course" + "_" + course.getAreaName() + "_" + course.getCourseTitle() + ".gpx";
		String thubnailName = course.getAreaName() + "_" + course.getCourseTitle() + fileExtension;
		
		// 파일 업로드 경로
		String gpxFilePath = gpxPath + "/" + gpxFileName;
		String thumbPath = imgPath + "/" + thubnailName;
		System.out.println(" adminCourse gpxFile path:" + gpxFilePath); // 경로 확인
		System.out.println(" adminCourse gpxFile path:" + thumbPath); // 경로 확인
		
		// course Service => insert 성공 여부
		course.setThumbnail(thubnailName);
		course.setWdate(LocalDateTime.now().withNano(0));
		boolean courseResult = cService.insertCourse(course);
		System.out.println("AdminCourse insert result: " + courseResult);
		
		if (courseResult) {
			
			// gpxFiles DTO 객체에 값 저장
			GpxFilesDto gpx = new GpxFilesDto();
			gpx.setMemId("admin");
			gpx.setCourseSeq(course.getCourseSeq());
			gpx.setFilePath(gpxFilePath);
			gpx.setFileName(gpxFileName);
			gpx.setUploadDate(new Date());
			
			// gpxFiles Service => insert 성공 여부
			boolean fileResult = gfService.insertCourseGpxFile(gpx);
			System.out.println("gpxfile insert result: " + fileResult);
			
			if (fileResult) {
				// 파일 저장
				File file = new File(gpxFilePath);
				try {
					
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(gpxFile.getBytes());
					bos.close();
					
					// Gpx Data 파싱하여 DB에 저장
					List<GpxDataDto> points = GpxParserUtil.parseGPXFile(file);
					double totalD = 0;	// 총 거리 초기화
					double totalT = 0;
					double maxSlope = 0;	// 총 경사도 초기화
					
					for (GpxDataDto point : points) {
					    GpxDataDto gpxData = new GpxDataDto();
					    gpxData.setFileSeq(gpx.getFileSeq());
					    gpxData.setCourseSeq(course.getCourseSeq());
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
					    boolean result = gdService.insertCourseGpxData(gpxData);

					    if (!result) { // insert 실패 시
					    	System.out.println("gpxData insert 실패!");
					        return "gpxData insert Fail";
					    }
					}
					
					// 칼로리 계산
					double kcal = ((3.5/60)*7*60*totalT/1000)*5;
					// ((산소3.5ml/60s) * met(s) * 몸무게(kg) * 운동시간(s)) * 산소 1L 당 5kcal, 조깅 met(s)= 7
					
					// 총 이동 거리,최고 경사도 Dto에 저장
					course.setaCourseTotalDist(totalD);
					course.setaCourseMaxSlope(maxSlope);
					course.setKcal(kcal);
					
					// 난이도 - ~5 => '초급', 5 ~ 10 => '중급', 10 ~ 15 => '고급', 15 ~ => '최고급'
					String level = "";
					if( (totalD/1000) <= 5) {
						level = "초급";
					} else if ((totalD/1000) <= 10) {
						level = "중급 ";
					} else if ((totalD/1000) <= 15) {
						level = "고급";
					} else {
						level = "최고급";
					}
					System.out.println(level);
					course.setLevel(level);
					
					// DB에 저장
					boolean infoResult = cService.insertInfo(course);
					System.out.println("코스에 추가 정보 : " + infoResult);
					
					// 코스 insert 성공 시 파일 저장
					File thumbFile = new File(thumbPath);
					try {
						BufferedOutputStream bbos = new BufferedOutputStream(new FileOutputStream(thumbFile));
						bbos.write(imgFile.getBytes());
						bbos.close();
					} catch (Exception e) {
						System.out.println("코스 썸네일 저장 실패");
						return "Upload Fail";
					}
					
					System.out.println("추천 코스 업로드 성공!");
					return "추천 코스 업로드 성공!";
					
				  } catch (Exception e) {	// 파일 저장 실패 시
					  	e.printStackTrace();
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
	}	// <courseUpload />

	// TODO : 추천 코스 번호에 따른 gpxData 전송
	@GetMapping(value="/courseGpxList")
	public List<GpxDataDto> courseGpxList() {
		System.out.println("GpxController courseGpxList : " + new Date());
		
//		List<Integer> courseSeqListInt = Arrays.stream(courseSeqList.split(","))
//				.map(Integer::valueOf)
//				.collect(Collectors.toList());
		
		return gdService.courseGpxList();
	}
	
	/* User 코스 */
	// TODO : User gpx 파일 업로드
	@PostMapping(value="/userCourseUpload")
	public String userCourseUpload (UserCourseDto course,
									 @RequestParam(value = "gpxFile")MultipartFile gpxFile,
									 HttpServletRequest req) {
		
		System.out.println("GpxController userCourseUpload " + new Date());
		System.out.println(course.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/gpx");
		
		// new 파일 명 : 업로드 시간(초 단위까지) + 멤버ID 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = "userCourse_" + course.getMemId() + ".gpx"; 
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println(" gpxFile path:" + filePath); // 경로 확인
		
		// 유저 course 작성일 Dto에 저장
		course.setuCourseWdate(LocalDateTime.now().withNano(0)); // 초 단위까지 저장
		
		// user Service => insert 성공 여부
		boolean userResult = uService.insertUserCourse(course);
		System.out.println("diary insert result: " + userResult);
		
		if (userResult) {
			
			// gpxFiles DTO 객체에 값 저장
			GpxFilesDto gpx = new GpxFilesDto();
			gpx.setMemId(course.getMemId());
			gpx.setUserCSeq(course.getUserCSeq());
			gpx.setFilePath(filePath);
			gpx.setFileName(fileName);
			gpx.setUploadDate(new Date());	
			
			// gpxFiles Service => insert 성공 여부
			boolean fileResult = gfService.insertUserGpxFile(gpx);
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
					
					for (GpxDataDto point : points) {
					    GpxDataDto gpxData = new GpxDataDto();
					    gpxData.setFileSeq(gpx.getFileSeq());
					    gpxData.setUserCSeq(course.getUserCSeq());
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
					
					// 총 이동거리,시간,칼로리 Dto에 저장
					course.setuCourseTotalDist(totalD);
					course.setuCouresTotalTime(totalT);
					course.setuCourseMeanPace(meanPace);
					course.setuCourseMaxSlope(maxSlope);
					course.setuCourseKcal(kcal);
					// DB에 저장
					boolean infoResult = uService.insertUserInfo(course);
					System.out.println("다이어리 추가 정보 : " + infoResult);
					
					System.out.println("유저 코스 기록 업로드 성공!");
					return "기록 업로드 성공!";
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
	}

	
}	// <Gpx Controller />
