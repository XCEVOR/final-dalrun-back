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

import com.dalrun.dto.CourseDto;
import com.dalrun.dto.CourseReplyDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.CourseReplyService;
import com.dalrun.service.CourseService;
import com.dalrun.service.GpxDataService;
import com.dalrun.service.GpxFilesService;
import com.dalrun.service.UserCourseService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CourseController {

	@Autowired
	CourseService cService;

	@Autowired
	CourseReplyService crService;
	
	@Autowired
	UserCourseService uService;
	
	@Autowired
	GpxDataService gdService;
	
	@Autowired
	GpxFilesService gfService;

	/* 추천 코스 */
	// TODO : 추천 코스 리스트
	@GetMapping("courseList")
	public List<CourseDto> courseList(@RequestParam(value="search")String search){
		System.out.println("CourseController courseList" + new Date());
		return cService.courseList(search);
	}

	// 추천 코스 댓글 리스트
	@GetMapping("courseReplyList")
	public List<CourseReplyDto> courseReplyList(){
		System.out.println("CourseController courseReplyList" + new Date());
		return crService.courseReplyList();
	}
	
	@PostMapping("updateCourse")
	public String updateCourse(CourseDto course) {
		System.out.println("CourseController updateCourse" + new Date());
		
		boolean result = cService.updateCourse(course);
		if(!result) {
			return "추천코스 수정 실패"; 
		}
		return "추천코스 수정 성공";
	}
	
	@PostMapping("deleteCourse")
	public String deleteCourse(@RequestParam(value ="courseSeq") int courseSeq) {
		System.out.println("CourseController deleteCourse" + new Date());
		
		// 해당 course gpx 파일들 모두 삭제
		List<GpxFilesDto> gpxFiles = gfService.selectCourseFiles(courseSeq);
	       for (GpxFilesDto file : gpxFiles) {
	           File gpxFile = new File(file.getFilePath() + "/" + file.getFileName());
	           if (gpxFile.exists()) {
	              gpxFile.delete();
	           }
	       }
	     
	    boolean gpxFilesResult = gfService.deleteCourseFiles(courseSeq);
	    boolean gpxDataResult = gdService.deleteCourseData(courseSeq);
	    boolean userCourseResult = uService.deleteUserCoure(courseSeq);
	    boolean courseResult = cService.deleteCourse(courseSeq);
	    
	    if(!gpxFilesResult) {
	    	return "gpxFile DB 데이터 삭제 실패";
	    } else if(!gpxDataResult) {
	    	return "gpxData DB 데이터 삭제 실패";
	    } else if(!userCourseResult) {
	    	return "userCourse DB 데이터 삭제 실패";
	    } else if(!courseResult) {
	    	return "course DB 데이터 삭제 실패";
	    } else {
	    	return " 해당 코스가 삭제되었습니다";
	    }
	
	}
	
	// TODO : 추천 코스 이미지 업로드
	@PostMapping("uploadCourseImg")
	public Map<String, String> uploadCourseImg(
							  CourseDto course,
							  MultipartFile imageFile,
							  HttpServletRequest req) {
		System.out.println("CourseController uploadCourseImg: " + new Date());
		
		// 파일 저장 경로 설정 server 단
		String path = req.getServletContext().getRealPath("/dalrun-jw/courseImg");
		
		// 파일 확장자 명
		String ogFilename = imageFile.getOriginalFilename(); // 기존 파일 명
		String fileExtension = ogFilename.substring(ogFilename.indexOf('.'));	// 확장자 명
		
		
		// new 파일 명 : ID + 고유 식별 + 숫자(초 단위까지)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String now = dtf.format(LocalDateTime.now());
		String fileName = now + "_" + course.getPostId() + fileExtension ;
		
		// 파일 업로드 경로
		String filePath = path + "/" + fileName;
		System.out.println("uploadCourseImg path:" + filePath); // 경로 확인
		
		File file  = new File(filePath);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(imageFile.getBytes());
			bos.close();
			
		} catch (Exception e) {
			return null;
		} 
		
		// 이미지 URL 생성
	    String imageUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/dalrun-jw/courseImg/" + fileName;

	    // CKEditor에서 요구하는 형식에 맞춰서 JSON 응답 생성
	    Map<String, String> response = new HashMap<>();
	    response.put("uploaded", "true");
	    response.put("url", imageUrl);
	    
		return response;
		
	}
	
	/* 유저 코스 기록 */
//	@PostMapping("deleteUserCourse")
//	public String deleteUserCourse(@RequestParam(value="userCSeq") int userCSeq){
//		System.out.println("CourseController dleteUserCourse: " + new Date());
//		
//		
//	}
	

}	// <Course Controller/>
