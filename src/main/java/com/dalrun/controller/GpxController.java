package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxDataDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.service.DiaryService;
import com.dalrun.service.GpxDataService;
import com.dalrun.service.GpxFilesService;
import com.dalrun.util.GpxParserUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GpxController {

	@Autowired
	GpxFilesService gfService;
	
	@Autowired
	GpxDataService gdService;
	
	@Autowired
	DiaryService dService;
	
	// gpx 파일 업로드
	@PostMapping(value="/gpxUpload")
	public String gpxUpload (@ModelAttribute DiaryDto diary,
							 @RequestParam(value = "gpxFile")MultipartFile gpxFile,
							 HttpServletRequest req) {
		
		System.out.println("GpxController gpxUpload" + new Date());
		System.out.println(diary.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/gpx");
		
		// 파일 확장자 명
//		String ogFilename = gpxFile.getOriginalFilename(); // 기존 파일 명
//		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명 .gpx
//		
//		if(!fileExtension.equals(".gpx")) { // 프론트엔드에서 막지만 보안 상 한번 더 막음
//			return "gpx 파일만 업로드 가능합니다.";
//		}
		
		// new 파일 명 : 멤버ID + 업로드 시간(초 단위까지)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = diary.getMemId() + "_" + now + ".gpx";
		
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println(" gpxFile path:" + filePath); // 경로 확인
		
		// diary DTO 객체에 값 저장
		diary.setWdate(new Date());
		
		// diary Service => fileSeq 반환
		int diarySeq = dService.insertDiary(diary);
		
		if (diarySeq > 0) {
			
			// gpxFiles DTO 객체에 값 저장
			GpxFilesDto gpx = new GpxFilesDto();
			gpx.setMemId(diary.getMemId());
			gpx.setDiarySeq(diarySeq+1);
			gpx.setFilePath(filePath);
			gpx.setFileName(fileName);
			gpx.setUploadDate(new Date());
			
			// gpxFiles Service => fileSeq 반환
			int fileSeq = gfService.insertGpxFile(gpx);
		
			if (fileSeq > 0) {	// 0이 아니면 값 들어갔을거라 판단
				// 파일 저장
				File file = new File(filePath);
				try {
					
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(gpxFile.getBytes());
					bos.close();
					
					// Gpx Data 파싱하여 DB에 저장
					List<GpxDataDto> points = GpxParserUtil.parseGPXFile(file);
                    GpxDataDto gpxData = new GpxDataDto();
					 for (GpxDataDto point : points) {
		                    gpxData.setFileSeq(fileSeq);
		                    gpxData.setDiarySeq(diarySeq);
		                    gpxData.setCourseSeq(0);
		                    gpxData.setMemId(gpx.getMemId());
		                    gpxData.setLatitude(point.getLatitude());
		                    gpxData.setLongitude(point.getLongitude());
		                    gpxData.setAltitude(point.getAltitude());
		                    gpxData.setmTime(point.getmTime());
		                    boolean result = gdService.insertGpxData(gpxData);
		                    
		                    if(!result) {
		                    	return "Upload Fail";
		                    }
		                }
	                return "Upload Success";

	            } catch (Exception e) {
	                return "Upload Fail";
	            }
	        } else {
	            return "Insert Fail";
	        }
	    } else {
	        return "Insert Fail";
		}
	}	// <GPX Upload/>
	
}	// <Gpx Controller />
