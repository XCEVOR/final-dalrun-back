package com.dalrun.controller;

import java.awt.print.Pageable;
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
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.CrewBbsCommentDto;
import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.DotMapDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.CrewBbsService;
import com.dalrun.service.DotMapService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CrewBbsController {
	
	@Autowired
	CrewBbsService service;
	
	@Autowired
	DotMapService dservice;
	//게시글 상세보기
	@GetMapping(value="crewBbsBlogDetail")
	public CrewDto getCrewBbs(int crewSeq) {
		System.out.println("CrewBbsController CrewBbsDto " + new Date());
		
		service.increaseReadCount(crewSeq);
		return service.getCrewBbs(crewSeq);
	}
	
	@PostMapping(value="increaseReadCount")
	public CrewDto increaseReadCount(int crewSeq) {
		System.out.println("CrewBbsController increaseReadCount " + new Date());
		
		service.increaseReadCount(crewSeq);
		return service.getCrewBbs(crewSeq);
	}
	
	@PostMapping(value="crewBbsWrite")
	   public String crewBbsWrite(@RequestPart(value="dto") String dtostr, @RequestPart(value="crewImg", required = false) 
	   							List<MultipartFile> files,
	   							HttpServletRequest req) {
	      System.out.println("CrewBbsController crewBbsWrite" + new Date());
	      
	      ObjectMapper mapper = new ObjectMapper();
	      CrewDto dto;
	      try {
	         dto = mapper.readValue(dtostr, CrewDto.class);
	      }catch (Exception e) {
	         e.printStackTrace();
	         return "NO";
	      }

	      List<String> filestr = new ArrayList<String>();
	      //C:\Users\ParkYerin\git\final-dalrun-front\public\assets\img\dalrun-pyr
	         String path = req.getServletContext().getRealPath("/dalrun-yr/crewImg"); //폴더 경로
	         File Folder = new File(path);

//	         if(!Folder.exists()) {
//	            try {
//	               Folder.mkdir();
//	            } catch(Exception e) {
//	               e.getStackTrace();
//	            }
//	         }

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
	         dto.setCrewImg(finalstr);
	         
	      System.out.println(dto);
	      DotMapDto ddto =new DotMapDto();
	      ddto.setCrewSeq(dto.getCrewSeq());
	      ddto.setMemId(dto.getMemId());
	      ddto.setGroundColor(dto.getCrewcolor());
	      dservice.crewInChangeDotmap(ddto);
	      
	      boolean b = service.writeCrewBbs(dto);
	      if(!b) {
	         return "NO";
	      }
	      return "YES";
	   }
		
	//이미지 반환	
	 @GetMapping(value="/getimg", produces= MediaType.IMAGE_PNG_VALUE)
	 public @ResponseBody byte[] getimg(@RequestParam(value="imgid") String imgid, HttpServletRequest req) throws IOException{
		 System.out.println("CrewBbsController getimg() " + new Date());
		 
	      InputStream in = new FileInputStream(req.getServletContext().getRealPath("/dalrun-yr/crewImg") + "/"+imgid);
	      return in.readAllBytes();
	   }

	//img를 String으로 반환해주는 엔드포인트
	 @GetMapping(value = "/getimgstr")
	public String getImgStr(@RequestParam(value="crewSeq") int crewSeq){
		 System.out.println("CrewBbsController getImgStr " + new Date());
	      return service.getImgByCbbsseq(crewSeq);
	   }
	
	private void crewBbsPageNumber(SearchParam param) {
		//글의 시작과 끝
		int pn = param.getPageNumber();
		int start = 1 + (pn * 50);
		int end = (pn + 1) * 50;
		
		param.setStart(start);
		param.setEnd(end);
	}
	
	public Map<String, Object> getList(List<?> list, int cnt){
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
//	크루모집 전체 게시글, 글의 총 수 불러오기
	@GetMapping(value="crewBbsMain")
	public Map<String, Object> crewBbsList(SearchParam param){
		System.out.println("CrewBbsController crewBbsList " + new Date());
		
		crewBbsPageNumber(param);
		List<CrewDto> list = service.crewBbsList(param);
		int len = service.getAllCrewBbs(param);
		System.out.println(list.size() +"개 게시글이 넘어간다아아아~~");
		
		for(int i=0; i< list.size(); i++) {
	         String imgDump = list.get(i).getCrewImg().split("/")[0];
	         list.get(i).setCrewImg(imgDump); //파일명만 넘김
	         System.out.println("imgDump " + imgDump);
	      }
		return getList(list,len);
	}
	 
	
	//글, 이미지 수정 
	@PostMapping(value="crewBbsUpdate")
	public String crewBbsUpdate(CrewDto crewBbs) {
		System.out.println("CrewBbsController crewBbsUpdate " + new Date());
		
		boolean b = service.updateCrewBbs(crewBbs);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
//	@PostMapping(value="crewBbsUpdate")
//	public String crewBbsUpdate(@RequestPart(value="dto") String dtostr, 
//	                            @RequestPart(value="crewImg", required = false) List<MultipartFile> files,
//	                            HttpServletRequest req) {
//	    System.out.println("CrewBbsController crewBbsUpdate" + new Date());
//
//	    ObjectMapper mapper = new ObjectMapper();
//	    CrewDto dto;
//	    try {
//	        dto = mapper.readValue(dtostr, CrewDto.class);
//	    }catch (Exception e) {
//	        e.printStackTrace();
//	        return "NO";
//	    }
//
//	    List<String> filestr = new ArrayList<String>();
//	    String path = req.getServletContext().getRealPath("/dalrun-yr/crewImg"); //폴더 경로
//	    File Folder = new File(path);
//
//	    // 기존 이미지 파일 삭제
//	    String[] oldFileNames = dto.getCrewImg().split("/");
//	    for (String fileName : oldFileNames) {
//	        File oldFile = new File(path, fileName);
//	        if (oldFile.exists()) {
//	            oldFile.delete();
//	        }
//	    }
//
//	    // 새로운 이미지 파일 업로드
//	    for (MultipartFile file: files) {
//	        String fn = UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[1];
//	        File newFile = new File(path, fn);
//	        filestr.add(fn);
//	        try {
//	            file.transferTo(newFile);
//	        } catch(Exception e) {
//	            e.printStackTrace();
//	            return "NO";
//	        }
//	    }
//
//	    String finalstr = filestr.stream().map(String::valueOf).collect(Collectors.joining("/"));
//	    dto.setCrewImg(finalstr);
//
//	    System.out.println(dto);
//	    boolean b = service.updateCrewBbs(dto);
//	    if(!b) {
//	        return "NO";
//	    }
//	    return "YES";
//	}
	
	
	@PostMapping(value="crewBbsDelete")
	public String crewBbsDelete(int crewSeq) {
		System.out.println("CrewBbsController crewBbsDelete " + new Date());
		
		System.out.println("delete Bbs Number :" + crewSeq );
		
		boolean b = service.deleteCrewBbs(crewSeq);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	//전체, 모집중, 모집완료로 보이기
	@GetMapping(value="/crewBbsMain/{type}")
	public List<CrewDto> selectBbs(@PathVariable("type") String type) {
		System.out.println("CrewBbsController selectBbs " + new Date());
		List<CrewDto> bbsList = null;
		
		try {
			System.out.println("aa");
		    if (type.equals("all")) {
		        bbsList = service.selectBbsAll();
		    } else {
		        bbsList = service.selectBbsType(type);
		    }
		} catch (Exception e) {
			System.out.println("bb");
		    e.printStackTrace();
		}
		return bbsList;
	}

	
	@GetMapping(value="writeCrewBbsComment")
	public String writeCrewBbsComment(CrewBbsCommentDto dto) {
		System.out.println("CrewBbsController writeCrewBbsComment " + new Date());
		
		boolean b = service.writeCrewBbsComment(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	@GetMapping(value="getCrewBbsCommentList")
	public List<CrewBbsCommentDto> getCrewBbsCommentList(int crewSeq){
		System.out.println("CrewBbsController getCrewBbsCommentList " + new Date());
		
		return service.getCrewBbsCommentList(crewSeq);
	}
	
	
	@GetMapping(value="/readcount")
	public Map<String, Object> getBbsListByReadCount(SearchParam param){
		System.out.println("CrewBbsController getBbsListByReadCount : " + new Date());
		
		crewBbsPageNumber(param);
		List<CrewDto> list = service.getBbsListByReadCount(param);
		int len = service.getAllCrewBbs(param);
		System.out.println(list.size() +"개 게시글이 넘어간다아아아~~");
		
		for(int i=0; i< list.size(); i++) {
	         String imgDump = list.get(i).getCrewImg().split("/")[0];
	         list.get(i).setCrewImg(imgDump); //파일명만 넘김
	         System.out.println("imgDump " + imgDump);
	      }
		
		return getList(list,len);
	}
	
	
	@GetMapping(value="likecount")
	public Map<String, Object> getBbsListByLikeCount(SearchParam param){
		System.out.println("CrewBbsController getBbsListByLikeCount : " + new Date());
		
		crewBbsPageNumber(param);
		List<CrewDto> list = service.getBbsListByLikeCount(param);
		int len = service.getAllCrewBbs(param);
		System.out.println(list.size() +"개 게시글이 넘어간다아아아~~");
		
		for(int i=0; i< list.size(); i++) {
	         String imgDump = list.get(i).getCrewImg().split("/")[0];
	         list.get(i).setCrewImg(imgDump); //파일명만 넘김
	         System.out.println("imgDump " + imgDump);
	      }
		
		return getList(list,len);
	}
	
}
