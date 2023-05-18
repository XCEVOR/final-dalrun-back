package com.dalrun.controller;

import com.dalrun.dto.CrewPointDto;
//import com.board.board.config.LoginUser;
//import com.board.board.config.auth.SessionUser;
import com.dalrun.dto.DotMapDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.service.CrewService;
import com.dalrun.service.DotMapService;
import com.dalrun.service.MemberService;
import com.dalrun.util.EditorUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class earthController {
	@Autowired
	DotMapService service;
	
	@Autowired
	CrewService crewService;

	
	@Autowired
	MemberService Mservice;

    //@Operation(summary = "페이지를 반환", description = "도트맵 페이지를 반환 합니다.")
    @GetMapping("earthPage")
    public List<DotMapDto> earthPage() {
    	System.out.println("earthController earthPage  abdc"+new Date());
        List<DotMapDto> dotList = service.getDotMapInfo();
       
        return dotList;
    }
    

    @PostMapping(value = "crew_buydotMap")
    public String crew_buydotMap (DotMapDto dto,  // 폼 필드의 정보들.
                                @RequestParam(value = "image", required = false)
                                MultipartFile FileLoad,  // 업로드시 파일 바이트로 넘어옴.
                                HttpServletRequest req) {  // 파일 업로드 경로를 얻어오기 위함.
        
        System.out.println("  @ earthController crew_buydotMap ()");
        System.out.println(dto.toString());
        
        
        // upload의 경로 설정.
        // server
        String fileupload_path = req.getServletContext().getRealPath("/dalrun-jy/uploadtemp");
      
        
        // 파일 저장 경로 확인.
        System.out.println("  @@ fileupload_path: " + fileupload_path);
        
        
        // filename 취득. (이 라인에서 파일 이름이 null 인지 판단하여 파일이 들어온지 확인. 그렇지 않으면 아래 코드 실행 X)
        String origFilename = FileLoad.getOriginalFilename();  // 불러온 원본 파일명.
        dto.setDotOrigFile(origFilename);
        // pdto origFilename에 저장.
        
        	
        String newFilename = EditorUtil.getNewFileName(origFilename);
        dto.setDotNewFile(newFilename);
        // pdto newFilename에 저장.
      
        // 파일 업로드 경로.
        String fileupload_file_path = fileupload_path + "/" + newFilename;
        System.out.println("  @@ fileupload_file_path: " + fileupload_file_path);
        
        // 감소 memberdto 생성
    		MemberDto mdto = new MemberDto();
    		mdto.setPoint(dto.getPrice());
    		mdto.setMemId(dto.getMemId());
    		
        
        File myFile = new File(fileupload_file_path);
        try {
            BufferedOutputStream bufoutStream = new BufferedOutputStream(new FileOutputStream(myFile));
            bufoutStream.write(FileLoad.getBytes());
           
            service.crew_buydotMap(dto);
            

            Mservice.MemberMinusPoint(mdto);
//          crewService.sendDonation(crewpointdto);
            bufoutStream.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "file upload FAIL~~~";
        } catch (IOException e) {
            e.printStackTrace();
            return "file upload FAIL~~~";
        }
        
        return "file upload SUCCESS!";
    }
    
    
    @PostMapping(value = "my_buydotMap")
    public String my_buydotMap (DotMapDto dto,  // 폼 필드의 정보들.
                                @RequestParam(value = "image", required = false)
                                MultipartFile FileLoad,  // 업로드시 파일 바이트로 넘어옴.
                                HttpServletRequest req) {  // 파일 업로드 경로를 얻어오기 위함.
        
        System.out.println("  @ earthController my_buydotMap ()");
        System.out.println(dto.toString());
        
        
        // upload의 경로 설정.
        // server
        String fileupload_path = req.getServletContext().getRealPath("/dalrun-jy/uploadtemp");
      
        
        // 파일 저장 경로 확인.
        System.out.println("  @@ fileupload_path: " + fileupload_path);
        
        
        // filename 취득. (이 라인에서 파일 이름이 null 인지 판단하여 파일이 들어온지 확인. 그렇지 않으면 아래 코드 실행 X)
        String origFilename = FileLoad.getOriginalFilename();  // 불러온 원본 파일명.
        dto.setDotOrigFile(origFilename);
        // pdto origFilename에 저장.
        
        	
        String newFilename = EditorUtil.getNewFileName(origFilename);
        dto.setDotNewFile(newFilename);
        // pdto newFilename에 저장.
      
        // 파일 업로드 경로.
        String fileupload_file_path = fileupload_path + "/" + newFilename;
        System.out.println("  @@ fileupload_file_path: " + fileupload_file_path);
        
        
        // 감소 memberdto 생성
		MemberDto mdto = new MemberDto();
		mdto.setPoint(dto.getPrice());
		mdto.setMemId(dto.getMemId());
        
        
        File myFile = new File(fileupload_file_path);
        try {
            BufferedOutputStream bufoutStream = new BufferedOutputStream(new FileOutputStream(myFile));
            bufoutStream.write(FileLoad.getBytes());
           
            service.my_buydotMap(dto);

    		Mservice.MemberMinusPoint(mdto);
    		
            bufoutStream.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "file upload FAIL~~~";
        } catch (IOException e) {
            e.printStackTrace();
            return "file upload FAIL~~~";
        }
        
        return "file upload SUCCESS!";
    }
    
    @GetMapping("crewOutChangeDotmap")
    public boolean crewOutChangeDotmap(DotMapDto dto) {
    	
        return service.crewOutChangeDotmap(dto);
    }
    @GetMapping("crewInChangeDotmap")
    public boolean crewInChangeDotmap(DotMapDto dto) {
    	
    	return service.crewInChangeDotmap(dto);
    }
    
    
   
}
