package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.DiaryReplyDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.DiaryReplyService;
import com.dalrun.service.DiaryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DiaryController {

	@Autowired
	DiaryService dService;
	
	@Autowired
	DiaryReplyService drService;

	// 다이어리 리스트
	@GetMapping("diaryList")
	public Map<String, Object> DiaryList(SearchParam param){// List -> Map, ajax는 한번에 데이터를 옮기면 안되고 각각 데이터를 따로따로 보내줘야 한다.
													   // 여러 개의 데이터를 한꺼번에 json 형태로 보내는 법 -> HashMap
		System.out.println("DiaryController diaryList" + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11 21
		int end = (pn + 1) * 10;	// 10 20 30
		
		param.setStart(start);
		param.setEnd(end);
		
		List<DiaryDto> list = dService.diaryList(param);
		int cnt = dService.getAllDiary(param);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);	// wrapper 형태로 들어 감
		
		return map;
	}

	// 다이어리 댓글 리스트
	@GetMapping("diaryReplyList")
	public List<DiaryReplyDto> diaryReplyList(){
		System.out.println("DiaryController diaryReplyList" + new Date());
		return drService.diaryReplyList();
	}
	
	
	// 다이어리 이미지 업로드
	@PostMapping("uploadDiaryImg")
	public Map<String, String> uploadDiaryImg(
							  MultipartFile imageFile,
							  HttpServletRequest req) {
		System.out.println("DiaryController uploadDiaryImg: " + new Date());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/diaryImg");
		
		// 파일 확장자 명
		String ogFilename = imageFile.getOriginalFilename(); // 기존 파일 명
		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명
		
		
		// 멤버ID + new 파일 명 : 업로드 시간(초 단위까지)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = now + "_" + fileExtension ;
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println("uploadDiaryImg path:" + filePath); // 경로 확인
		
		File file  = new File(filePath);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(imageFile.getBytes());
			bos.close();
			
		} catch (Exception e) {
			return null;
		} 
		
		// 이미지 URL 생성
	    String imageUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/diaryImg/" + fileName;

	    // CKEditor에서 요구하는 형식에 맞춰서 JSON 응답 생성
	    Map<String, String> response = new HashMap<>();
	    response.put("uploaded", "true");
	    response.put("url", imageUrl);
	    
		return response;
		
	}

} // <Diary Controller/>
