package com.dalrun.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.dalrun.dto.CrewDto;
import com.dalrun.dto.DotMapDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.service.DotMapService;
import com.dalrun.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	DotMapService dservice;
	
	//아이디 중복체크
	@PostMapping(value="/idcheck")
	public String idcheck(String memId) {
		System.out.println("MemberController idcheck " + new Date());
		
		boolean b = service.idcheck(memId);
		if(b == true) {
			return "NO";
		}		
		return "YES";
	}
	
	//회원가입
	@PostMapping(value = "/addmember")
    public String addmember(@RequestPart(value = "dto") String dtostr, @RequestPart(value = "profileImg", required = false) 
    						List<MultipartFile> files, HttpServletRequest req) {
       System.out.println("MemberController addmember " + new Date());
       ObjectMapper mapper = new ObjectMapper();
      MemberDto dto;
      try{
          dto = mapper.readValue(dtostr, MemberDto.class);
       }catch (Exception e){
          e.printStackTrace();
          return "NO";
       }
       //파라미터에 업로드한 파일이 존재하면
       if (files.get(0) != null){
          //첫 번째 파일만 가져와서
          MultipartFile file = files.get(0);
          //UUID와 파일 확장자를 조합하여 새로운 파일명을 만들고, 해당 파일 생성
          String fn = UUID.randomUUID() + "."+file.getOriginalFilename().split("\\.")[1];

         String path = req.getServletContext().getRealPath("/dalrun-yr/profiles"); //폴더 경로
         File Folder = new File(path);

         // 해당 디렉토리가 없다면 디렉토리를 생성.
//         if (!Folder.exists()) {
//            try {
//               Folder.mkdir(); //폴더 생성
//            } catch (Exception e) {
//               e.getStackTrace();
//            }
//         }

          //파일 객체 생성
          File newFile = new File(path, fn);
          
          try{
             //위 파일 객체를 이용하여 업로드한 파일을 생성한 파일로 이동
             file.transferTo(newFile);
             //dto객체의 profile 필드에 새로 생성한 파일명 저장
             dto.setProfile(fn);
          }catch(Exception e){
           e.printStackTrace();
             return "NO";
          }
       }
       
       System.out.println(dto);
       //디비 저장
       boolean b = service.addmember(dto);
       if(!b) {
          return "NO";
       }
       return "YES";
    }
	
	@GetMapping(value="/getimage", produces = MediaType.IMAGE_PNG_VALUE)
	   public @ResponseBody byte[] getimage(@RequestParam(value="id") String id, HttpServletRequest req) throws IOException{
		//이미지 로드 파일 경로 : C:/image , 이미지 파일 이름 : id 
	      System.out.println("/dalrun-yr/profiles"+id);
	      
	      String profileImg = service.getMemId(id);
	      //절대경로
	      InputStream in = new FileInputStream(req.getServletContext().getRealPath("/dalrun-yr/profiles") + "/" + profileImg);
	      return in.readAllBytes();
	      //	url 확인 -       http://localhost:3000/getimage?id=(memId) 넣기
	   }
	
	//로그인
	@PostMapping(value = "/login")
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberController login " + new Date());
		
		MemberDto mem = service.login(dto);		
		return mem;
	}
	
	//home페이지로 이동
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// 1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
	// 2번 받은 code를 iKakaoS.getAccessToken로 보냄 ###access_Token###로 찍어서 잘 나오면은 다음단계진행
	// 3번 받은 access_Token를 iKakaoS.getUserInfo로 보냄 userInfo받아옴, userInfo에 nickname, email정보가 담겨있음
	@GetMapping(value="/oauth/kakao/callback")
	public MemberDto kakaoLogin(@RequestParam(value="code", required = false) String code)
		throws Throwable{
		System.out.println("MemberController kakaoLogin() " + new Date());
		// 1번
		System.out.println("1번 - code:" + code);
		
		// 2번
		String access_Token = service.getKakaoAccessToken(code);
		System.out.println("2번 - ###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
		System.out.println("3번 - ###nickname#### : " + userInfo.get("nickname"));
		System.out.println("3번 - ###email#### : " + userInfo.get("email"));
		
		if (service.kakaoLoginValidCheck(userInfo.get("email").toString())){
	         return service.getmemberbyemail(userInfo.get("email").toString());
	         //로그인 성공
	      }else {
	         return null;
	         //로그인 실패
	      }
	}
	
	// 회원 조회
	@PostMapping(value = "getmember")
	public MemberDto getMember(String target) {
		System.out.println("AdminController getMember " + new Date());
		
		MemberDto mem = service.getmember(target);
		
		return mem;
	}
	
	@GetMapping(value = "mycrewMemberList")
	public List<MemberDto> mycrewMemberList(int crewSeq){
		
		return service.mycrewMemberList(crewSeq);
	}

//	@GetMapping(value = "crewLeave")
//	public boolean crewLeave(String memId,int crewSeq){
//		
//		DotMapDto ddto=new DotMapDto();
//		ddto.setMemId(memId);
//		ddto.setCrewSeq(crewSeq);
//		
//		dservice.crewOutChangeDotmap(ddto);
//		return service.crewLeave(memId);
//	}
	
//	@PostMapping(value="findRegi")
//	public String findMemId(@RequestBody MemberDto dto) {
//		System.out.println("MemberController findMemId " + new Date());
//		
//		String memId = service.findMemId(dto);
//		return memId;
//	}
	
	@PostMapping("/findId")
	   public String findId(@RequestBody MemberDto dto){
	      String id = service.findId(dto);
	      if (id==null){
	         return "Not Found";
	      }else{
	         return id;
	      }
	   }

	   @PostMapping("/findpw")
	   public String findPw(@RequestBody MemberDto dto){
	      boolean res = service.findPw(dto);
	      if(res){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }
	
		/*@GetMapping("/findId")
		public String findId(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
		    String id = service.findId(name, email);
		    if (id == null) {
		        return "Not Found";
		    } else {
		        return id;
		    }
		}*/
	
//		@PostMapping("/findId")
//		public String findId(@RequestBody MemberDto dto) {
//			System.out.println("MemberController findId " + new Date());
//		    String name = dto.getMemberName();
//		    String email = dto.getEmail();
//		    
//		    String id=service.findId(name, email);
//		    if (id == null) {
//		        return "Not Found";
//		    } else {
//		        return id;
//		    }
//		}
		
	   /*@PostMapping("/findpw")
	   public String findPw(@RequestParam(value="id") String memId, @RequestParam(value="name") String memberName, @RequestParam(value="phone") String phone){
	      boolean res = service.findPw(memId, memberName, phone);
	      if(res){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }*/
		
//		@PostMapping("/findpw")
//		public String findPw(@RequestBody MemberDto dto) {
//		  String id = dto.getMemId();
//		  String name = dto.getMemberName();
//		  String phone = dto.getPhone();
//
//		  boolean res = service.findPw(id, name, phone);
//		  if (res) {
//		    return "success";
//		  } else {
//		    return "failed";
//		  }
//		}
  
}
