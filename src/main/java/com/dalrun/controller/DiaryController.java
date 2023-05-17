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
import com.dalrun.util.FileNameListUtil;

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
							  DiaryDto diary,
							  MultipartFile imageFile,
							  HttpServletRequest req) {
		System.out.println("DiaryController uploadDiaryImg: " + new Date());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/dalrun-jw/diaryImg");
		
		// 파일 확장자 명
		String ogFilename = imageFile.getOriginalFilename(); // 기존 파일 명
		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명
		
		// new 파일 명 : ID + 고유 식별 + 숫자(초 단위까지)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = now + "_" + diary.getPostId() + "_" + diary.getMemId() + fileExtension ;
		
		System.out.println("ori = " + ogFilename);
		System.out.println("new = " + fileName);
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
	    String imageUrl = "http://localhost:3000/dalrun-jw/diaryImg/" + fileName;

	    // CKEditor에서 요구하는 형식에 맞춰서 JSON 응답 생성
	    Map<String, String> response = new HashMap<>();
	    response.put("uploaded", "true");
	    response.put("url", imageUrl);
	    
		return response;
		
	}
	
	// 다이어리 수정 시, 삭제된 기존의 사진은 서버에서 삭제
	@PostMapping("deleteImg")
	public void deleteImg(@RequestParam(value = "fileList", required=false) List<String> filelist,
						  @RequestParam("memId") String memId,
						  HttpServletRequest req) {
		
		System.out.println("DiaryController deleteImg: " + new Date());					
		
		String path = req.getServletContext().getRealPath("/diaryImg");
		String[] imgList = FileNameListUtil.getFileNameList(path);
		
		for(String img : imgList) {
			if(img.contains(memId)) {	// 해당 아이디가 포함된 이미지 추출
				System.out.println("memId " + img);
				
				if(filelist.size() == 0) {	// 01. 기존의 파일을 모두 지울 경우, 모두 삭제	
					String filepath = path + "/" + img;
					File file = new File(filepath);
					file.delete();
				} 
				else if(!filelist.contains(img)) {	// 02. 기존의 파일에서 일부만 지울 경우, 수정된 파일리스트에 포함되지 않은 이미지 추출
					System.out.println("img = " + img);
					
					String filepath = path + "/" + img;
					File file = new File(filepath);
					if(file.exists()) file.delete();
				}
			}
			}
		
	}
	
	
	// TODO : 투데이 기록 1등
	@GetMapping("getTodayTopScore")
	public List<DiaryDto> getTodayTopScore(){
		System.out.println("DiaryController getTodayTopScore : " + new Date());
		
		return dService.getTodayTopScore();
	}
	

} // <Diary Controller/>
