package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
							 @RequestParam(value = "gpxFile", required = false)
							 MultipartFile gpxFile,
							 @RequestParam(value = "memId")String memId,
							 HttpServletRequest req) {
		
		System.out.println("GpxController gpxUpload" + new Date());
		System.out.println(gpx.toString());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/gpx");
		
		// 파일 명
		String filename = memId + gpxFile.getOriginalFilename();
		
		
		// 파일 업로드 경로
		String filepath = path + "/" + filename;
		
		System.out.println(filepath);
		
		File file = new File(filepath);
		
		try {
			
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(gpxFile.getBytes());
			bos.close();
			
		} catch (Exception e) {
			return "file upload fail";
		}
		
		return "file upload success";
	}
	
}	// <Gpx Controller />
