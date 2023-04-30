package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.GpxFilesDto;
import com.dalrun.service.GpxDataService;
import com.dalrun.service.GpxFilesService;

import jakarta.servlet.http.HttpServletRequest;

public class GpxController {

	@Autowired
	GpxFilesService gfService;
	
	@Autowired
	GpxDataService gdService;
	
	// gpx 파일 업로드
	@PostMapping("/gpxUpload")
	public String gpxUpload (GpxFilesDto gpx,
							 @RequestParam(value = "gpxFile")MultipartFile gpxFile,
							 HttpServletRequest req) {
		
		System.out.println("GpxController gpxUpload" + new Date());
		System.out.println(gpx.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/gpx");
		
		// 파일 확장자 명
		String ogFilename = gpxFile.getOriginalFilename(); // 기존 파일 명
		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명 .gpx
		
		if(!fileExtension.equals(".gpx")) {
			return "gpx 파일만 업로드 가능합니다.";
		}
		
		// new 파일 명 : 멤버ID + 업로드 시간(초 단위까지)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = now + fileExtension;
		//String filename = memId + "_" + now + fileExtension;
		
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println(" gpxFile path:" + filePath); // 경로 확인
		
		// gpxFiles DTO 객체에 값 저장
		gpx.setMemId(gpx.getMemId());
		gpx.setFilePath(filePath);
		gpx.setFileName(fileName);
		gpx.setUploadDate(new Date());
		
		// gpxFiles Service
		boolean result = gfService.insertGpxFile(gpx);
		
		if (result) {
			// 파일 저장
			File file = new File(filePath);
			try {
				
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				bos.write(gpxFile.getBytes());
				bos.close();
				
			}catch (Exception e) {
		        return "Upload Fail";
		    }
			
			return "Upload Success";
		} else {
			return "Insert Fail";
		}
	}
	
}	// <Gpx Controller />
