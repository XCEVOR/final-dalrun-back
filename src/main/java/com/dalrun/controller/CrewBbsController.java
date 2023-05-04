package com.dalrun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;
import com.dalrun.service.CrewBbsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CrewBbsController {
	
	@Autowired
	CrewBbsService service;
	
	//게시글 상세보기
	@GetMapping(value="crewBbsBlogDetail")
	public CrewBbsDto getCrewBbs(int cBbsSeq) {
		System.out.println("CrewBbsController CrewBbsDto " + new Date());
		
		service.increaseReadCount(cBbsSeq);
		return service.getCrewBbs(cBbsSeq);
	}
	
	@PostMapping(value="increaseReadCount")
	public CrewBbsDto increaseReadCount(int cBbsSeq) {
		System.out.println("CrewBbsController increaseReadCount " + new Date());
		
		service.increaseReadCount(cBbsSeq);
		return service.getCrewBbs(cBbsSeq);
	}
	
		@PostMapping(value="crewBbsWrite")
	   public String crewBbsWrite(@RequestPart(value="dto") String dtostr, @RequestPart(value="img", required = false) List<MultipartFile> files) {
	      System.out.println("CrewBbsController crewBbsWrite" + new Date());
	      
	      ObjectMapper mapper = new ObjectMapper();
	      CrewBbsDto dto;
	      try {
	         dto = mapper.readValue(dtostr, CrewBbsDto.class);
	      }catch (Exception e) {
	         e.printStackTrace();
	         return "NO";
	      }

	      List<String> filestr = new ArrayList<String>();
	         String path = "C:/crewBbsImage/";
	         File Folder = new File(path);

	         if(!Folder.exists()) {
	            try {
	               Folder.mkdir();
	            } catch(Exception e) {
	               e.getStackTrace();
	            }
	         }

	         for (MultipartFile file: files) {
	            String fn = UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[1];
	            File newFile = new File(path, fn);
	            filestr.add(fn);
	            try {
	               file.transferTo(newFile);
	            } catch(Exception e) {
	               e.printStackTrace();
	               return "NO";
	            }
	         }

	         String finalstr = filestr.stream().map(String::valueOf).collect(Collectors.joining("/"));
	         dto.setImg(finalstr);
	      
	      System.out.println(dto);
	      boolean b = service.writeCrewBbs(dto);
	      if(!b) {
	         return "NO";
	      }
	      return "YES";
	   }
		
	//이미지 반환	
	 @GetMapping(value="/getimg", produces= MediaType.IMAGE_PNG_VALUE)
	 public @ResponseBody byte[] getimg(@RequestParam(value="imgid") String imgid) throws IOException{
	      InputStream in = new FileInputStream("C:/crewBbsImage/"+imgid);
	      return in.readAllBytes();
	   }

	//img를 String으로 반환해주는 엔드포인트
//	@GetMapping(value = "/getimgstr")
//	public String getImgStr(@RequestParam(value="cBbsSeq") String cBbsSeq){
//	      return service.getImgByCbbsseq(cBbsSeq);
//	   }
	 @GetMapping(value = "/getimgstr")
		public String getImgStr(@RequestParam(value="cBbsSeq") int cBbsSeq){
		      return service.getImgByCbbsseq(cBbsSeq);
		   }
	
	private void crewBbsPageNumber(CrewBbsParam param) {
		//글의 시작과 끝
		int pn = param.getPageNumber();
		int start = 1 + (pn * 10);
		int end = (pn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
	}
	
	//크루모집 전체 게시글, 글의 총 수 불러오기
	@GetMapping(value="crewBbsMain")
	public Map<String, Object> crewBbsList(CrewBbsParam param){
		System.out.println("CrewBbsController crewBbsList " + new Date());
		
		crewBbsPageNumber(param);
		List<CrewBbsDto> list = service.crewBbsList(param);
		int len = service.getAllCrewBbs(param);
		
		//paging
		int pageCrewBbs = len / 10;
		if((len%10)>0 ) {
			pageCrewBbs = pageCrewBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("pageCrewBbs", pageCrewBbs);
		
		return map;
	}
	
	@PostMapping(value="crewBbsUpdate")
	public String crewBbsUpdate(CrewBbsDto crewBbs) {
		System.out.println("CrewBbsController crewBbsUpdate " + new Date());
		
		boolean b = service.updateCrewBbs(crewBbs);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	@PostMapping(value="crewBbsDelete")
	public String crewBbsDelete(CrewBbsDto crewBbs) {
		System.out.println("CrewBbsController crewBbsDelete " + new Date());
		
		boolean b = service.deleteCrewBbs(crewBbs);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
//	@GetMapping(value="crewBbsMain/{type}")
//	public String selectBbsType(@PathVariable String type) {
//		List<CrewBbsDto> list = service.selectBbsType(type);
//		
//		return "list";
//	}
	
}
