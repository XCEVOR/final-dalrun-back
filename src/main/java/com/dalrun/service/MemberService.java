package com.dalrun.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.MemberDao;
import com.dalrun.dto.CrewPointDto;
import com.dalrun.dto.MemberDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	//아이디 중복체크
	public boolean idcheck(String memId) {
		int n = dao.idcheck(memId);
		return n>0?true:false;
	}
	
	//회원가입
	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		
//		// 멤버 등록이 완료되면 DB에서 생성된 memId 값을 가져옴
//		String memId = dao.getMemberId(dto.getMemId());
//		//// 가져온 memId 값을 dto 객체에 설정
//		dto.setMemId(memId);
		
		return n>0?true:false;
	}
	
	//memId로 이미지 가져옴
	public String getMemId(String memId) {
		return dao.getMemId(memId);
	}
	
	//로그인
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
	//카카오 로그인을 통해 얻은 authorize_code를 사용하여 access_token을 발급받는 메소드
	//2번
	public String getKakaoAccessToken (String authorize_code) throws Exception {
		//변수 선언
	    String access_Token = "";
	    String refresh_Token = "";
	    //reqURL: String 타입의 카카오 로그인 인증서버의 URL
	    String reqURL = "https://kauth.kakao.com/oauth/token";
	    
	    try {
	    	//URL 객체 생성
			URL url = new URL(reqURL);

			//HttpURLConnection 객체 생성 및 설정
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");

			sb.append("&client_id=33861296b5dfb84484e1df231821dd86"); // REST_API키 본인이 발급받은 key 넣어주기
			sb.append("&redirect_uri=http://localhost:9200/kakaocallback"); // REDIRECT_URI 본인이 설정한 주소 넣어주기

			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// jackson objectmapper 객체 생성
			ObjectMapper objectMapper = new ObjectMapper();
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});

			access_Token = jsonMap.get("access_token").toString();
			refresh_Token = jsonMap.get("refresh_token").toString();

			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}
	
	//카카오 API를 이용해 사용자 정보를 가져오는 메서드
	//3번
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			//access token을 이용하여 카카오 api서버에 요청을 보내기위해 HttpURLConnection 객체를 생성
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//GET 메서드를 사용해 사용자 정보를 요청
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			System.out.println("result type" + result.getClass().getName()); // java.lang.String

			try {
				// jackson objectmapper 객체 생성
				//응답 결과는 JSON 형태의 문자열
				//자바 객체로 변환하기 위해 ObjectMapper 객체를 생성
				ObjectMapper objectMapper = new ObjectMapper();
				// JSON String -> Map(readValue() 메서드를 이용하여 JSON 문자열을 자바 Map 객체로 변환)
				Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
				});

				System.out.println(jsonMap.get("properties"));

				//변환된 Map 객체에서 필요한 정보를 추출하여 HashMap<String, Object> 타입으로 반환
				//사용자의 닉네임과 이메일 정보를 반환
				Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
				Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

				// System.out.println(properties.get("nickname"));
				// System.out.println(kakao_account.get("email"));

				String nickname = properties.get("nickname").toString();
				String email = kakao_account.get("email").toString();

				userInfo.put("nickname", nickname);
				userInfo.put("email", email);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
//	 public boolean kakaoLoginValidCheck(String email){
//	      MemberDto dto = dao.getmemberbyemail(email);
//	      if (dto.getMemId()==null || dto.getMemId()==""){
//	         return false;
//	      }
//	      return true;
//	 }
	
	//db에서 이메일 체크
	public boolean kakaoLoginValidCheck(String email){
	      MemberDto dto = getmemberbyemail(email);
	      if (dto==null){
	         return false;
	      }
	      return true;
	   }
	
	public MemberDto getmemberbyemail(String email){
		return dao.getmemberbyemail(email);
	}
	
	// 회원 조회
	public MemberDto getmember(String target) {
		return dao.getmember(target);
	}
	
	public boolean MemberMinusPoint(MemberDto dto) {
		return dao.MemberMinusPoint(dto)>0;
	}
	public List<MemberDto> mycrewMemberList(int crewSeq) {
		return dao.mycrewMemberList(crewSeq);
	}
	public boolean crewLeave(String memId) {
		return dao.crewLeave(memId)>0;
	}
	
//	public String findMemId(MemberDto dto) {
//		return dao.findMemId(dto);
//	}
	
}

