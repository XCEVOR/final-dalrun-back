package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dalrun.dto.MemberDto;
import com.dalrun.service.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
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
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember " + new Date());
		boolean b = service.addmember(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
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
	public String home(HttpSession session, Model model) {
		return "home";
	}
	
	@GetMapping("/logout")
	public String Logout() {
		
		return "logout";
	}
	
//	@GetMapping(value="/oauth/kakao/callback")
//	public @ResponseBody String kakaoCallback() {
//		return "kakao login success";
//	}
	
	// 1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
	// 2번 받은 code를 iKakaoS.getAccessToken로 보냄 ###access_Token###로 찍어서 잘 나오면은 다음단계진행
	// 3번 받은 access_Token를 iKakaoS.getUserInfo로 보냄 userInfo받아옴, userInfo에 nickname, email정보가 담겨있음
	@GetMapping(value="/oauth/kakao/callback")
	public ModelAndView kakaoLogin(@RequestParam(value="code", required = false) String code)
		throws Throwable{
		System.out.println("MemberController kakaoLogin() " + new Date());
		// 1번
		System.out.println("code:" + code);
		
		// 2번
		String access_Token = service.getKakaoAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		
		
		return null;	
		// return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음
	}
	
	// 회원 조회
	@PostMapping(value = "getmember")
	public MemberDto getMember(String target) {
		System.out.println("AdminController getMember " + new Date());
		
		MemberDto mem = service.getmember(target);
		
		return mem;
	}
}
