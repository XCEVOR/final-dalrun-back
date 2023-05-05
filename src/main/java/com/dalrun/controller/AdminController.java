package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.service.AdminService;
import com.dalrun.service.CompetitionService;
import com.dalrun.service.ProductService;
import com.dalrun.util.EditorUtil;
import com.dalrun.util.FileNameListUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	@Autowired
	ProductService productService;
	@Autowired
	CompetitionService compService;
	 
	private void pageNumber(SearchParam params) {
	    // 글의 시작과 끝
	    int pn = params.getPageNumber();  // 0 1 2 3 4
	    int start = 1 + (pn * 10);    // 1  11
	    int end = (pn + 1) * 10;    // 10 20

	    params.setStart(start);
	    params.setEnd(end);
	}
	
	private Map<String, Object> getList(List<?> list, int cnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 각 테이블의 리스트, 글의 총 수 불러오기
	// 회원 관리
	@GetMapping(value = "admin_memberlist")
	public Map<String, Object> memberlist(SearchParam params) {
	    System.out.println("AdminController memberlist " + new Date());
	    
	    pageNumber(params);	    
	    List<MemberDto> memberlist = service.memberlist(params);
		int len = service.getAllMember(params);
	    
	    return getList(memberlist, len);
	}

	@GetMapping(value = "admin_crewlist")
	public Map<String, Object> crewlist(SearchParam params) {
	    System.out.println("AdminController crewlist " + new Date());
	    
	    pageNumber(params);
	    List<CrewDto> crewlist = service.crewlist(params);
	    int len = service.getAllCrew(params);
	    
	    return getList(crewlist, len);
	}
	
	// 게시물 관리
	@GetMapping(value = "admin_productinquirylist")
	public Map<String, Object> productinquirylist(SearchParam params) {
	    System.out.println("AdminController productinquirylist " + new Date());
	    
	    pageNumber(params);
	    List<ProductInquiryDto> productinquirylist = service.productinquirylist(params);
	    int len = service.getAllProductinquiry(params);
	    
	    return getList(productinquirylist, len);
	}
	
	@GetMapping(value = "admin_qnalist")
	public Map<String, Object> qnalist(SearchParam params) {
	    System.out.println("AdminController qnalist " + new Date());
	    
	    pageNumber(params);	    
	    List<QnaDto> qnalist = service.qnalist(params);
		int len = service.getAllQna(params);
	    
	    return getList(qnalist, len);
	}
	
	@GetMapping(value = "admin_shoereviewlist")
	public Map<String, Object> shoereviewlist(SearchParam params) {
	    System.out.println("AdminController shoereviewlist " + new Date());
	    
	    pageNumber(params);
	    List<ShoeReviewDto> shoereviewlist = service.shoereviewlist(params);
	    int len = service.getAllShoereview(params);
	    
	    return getList(shoereviewlist, len);
	}
	
	@GetMapping(value = "admin_diarylist")
	public Map<String, Object> diarylist(SearchParam param) {
		System.out.println("AdminController diarylist " + new Date());
		
		pageNumber(param);
		List<DiaryDto> diarylist = service.diarylist(param);
		int len = service.getAllDiary(param);
		
		return getList(diarylist, len);
	}
	
	@GetMapping(value = "admin_competitionlist")
	public Map<String, Object> competitionlist(SearchParam params) {
	    System.out.println("AdminController competitionlist " + new Date());
	    
	    pageNumber(params);	    
	    List<CompetitionDto> competitionlist = service.competitionlist(params);
		int len = service.getAllCompetition(params);
	    
	    return getList(competitionlist, len);
	}
	
	// 상품 관리	
	@GetMapping(value = "admin_productlist")
	public Map<String, Object> productlist(SearchParam params) {
	    System.out.println("AdminController productlist " + new Date());
	    
	    pageNumber(params);
	    List<ProductDto> productlist = service.productlist(params);
	    int len = service.getAllProduct(params);
	    
	    return getList(productlist, len);
	}
	
	@GetMapping(value = "admin_orderlist")
	public Map<String, Object> orderlist(SearchParam params) {
	    System.out.println("AdminController orderlist " + new Date());
	    
	    pageNumber(params);
	    List<OrderDto> orderlist = service.orderlist(params);
	    int len = service.getAllOrder(params);
	    
	    return getList(orderlist, len);
	}
	
	// 수정/삭제
	private String str(boolean b) {
		if(!b) return "NO";
		return "YES";
	}
	
	// 회원 관리
	@PostMapping(value = "admin_updatemember")
	public String updatemember(MemberDto memDto) {
		System.out.println("AdminController updatemember " + new Date());
		System.out.println(memDto);
		
		boolean b = service.updatemember(memDto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delmember")
	public String delmember(@RequestParam("checkedList") String[] checkedList) {
		System.out.println("AdminController delmember " + new Date());
		System.out.println("checkedList = " + Arrays.toString(checkedList));
		
		boolean b = service.delmember(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "admin_updatecrew")
	public String updatecrew(CrewDto crewdto) {
		System.out.println("AdminController updatecrew " + new Date());
		System.out.println(crewdto);
		
		boolean b = service.updatcrew(crewdto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delcrew")
	public String delcrew(@RequestParam("checkedList") String[] checkedList) {
		System.out.println("AdminController delcrew " + new Date());
		System.out.println("checkedList = " + Arrays.toString(checkedList));
		
		boolean b = service.delcrew(checkedList);
		return str(b);
	}
	
	// 게시물 관리
	@PostMapping(value = "admin_updatereply")
	public String updatereply(ProductInquiryDto inqdto) {
		System.out.println("AdminController updatereply " + new Date());
		
		boolean b = service.updatereply(inqdto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delreply")
	public String delreply(int inqSeq) {
		System.out.println("AdminController delreply " + new Date());
		
		boolean b = service.delreply(inqSeq);
		return str(b);
	}
	
	@PostMapping(value = "admin_delproductinquiry")
	public String delproductinquiry(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController delproductinquiry " + new Date());
		
		boolean b = service.delproductinquiry(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "admin_delqna")
	public String delqna(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController delqna " + new Date());
		
		boolean b = service.delqna(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "admin_delshoereview")
	public String delshoereview(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController delshoereview " + new Date());
		
		boolean b = service.delshoereview(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "admin_deldiary")
	public String deldiary(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController deldiary " + new Date());
		
		boolean b = service.deldiary(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "getcompetition") 
	public CompetitionDto getCompetition(@RequestParam("target") int compSeq) {
		System.out.println("AdminController getCompetition " + new Date());
		
		CompetitionDto comp = compService.getCompBbs(compSeq);
		return comp;
	}
	
	@GetMapping(value = "getGeometricData")
	public String getGeometricData(String address) {
		String clientId = "13ylgllhb9";
		String clientSecret = "TkHolKJ7ljNNqOVJZtXoCwE9HCOgYgjMgajzh4VQ";
		
		StringBuffer response = null;
		
		// 장치에 요청할 URI
		try {
			
			String encodedQuery = URLEncoder.encode(address, "UTF-8"); // 입력받은 주소를 인코딩
			String queryParam = "?query=" + encodedQuery;
			
			URL url = new URL("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode" + queryParam);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        
	        // 요청 헤더
	        con.setRequestProperty("Content-Type", "application/json");
	        con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	        con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	
	        // Method 타입을 정의하고 API를 전송
	        con.setRequestMethod("GET");
	
	        BufferedReader br = null;
	        
	        int responseCode = con.getResponseCode();
	        if(responseCode == 200) { // 정상 호출
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else {  // 오류 발생
	            System.out.println("error!!!!!!! responseCode= " + responseCode);
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        }
	        String inputLine;
	
	        if(br != null) {
	            response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            
	            // 결과 출력
	            System.out.println(response.toString());
	        } else {
	            System.out.println("error !!!");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
		System.out.println(response);
		
		Double latitude = 0.0;
		Double longitude = 0.0;
		
		Map<String,Double> getmetricData = new HashMap<>();
		getmetricData.put("latitude", latitude);
		getmetricData.put("longitude", longitude);
		
	    return response.toString();
	}
	
	@PostMapping(value = "admin_delcompetition")
	public String delcompetition(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController delcompetition " + new Date());
		
		boolean b = service.delcompetition(checkedList);
		return str(b);
	}
	
	// 쇼핑몰 관리
	@PostMapping(value = "getproduct")
	public Map<String, Object> getProduct(@RequestParam("target") String productId) {
		System.out.println("AdminController getProduct " + new Date());
		
		Map<String, Object> map = new HashMap<>();
		
		int orderCnt = service.getProductOrder(productId);
		ProductDto product = productService.getCartProductInfo(productId);
		
		map.put("getProduct", product);
		map.put("orderCnt", orderCnt);
		
		return map; 
	}
	
	@PostMapping(value = "admin_updateproduct")
	public String updateproduct(ProductDto productdto, 
								@RequestParam(value = "updateImg", required=false) List<String> updatedFiles,
								@RequestParam(value="addFiles", required=false) List<MultipartFile> addFiles,
								HttpServletRequest req) {
		System.out.println("AdminController updateproduct " + new Date());
		System.out.println("update file =" + updatedFiles);
		
		// 파일 수정 : 파일 삭제 + 파일 추가
		String code = productdto.getProductCode();	// 상품 코드
		
		String fileuploaded_path = req.getServletContext().getRealPath("/dalrun-hc/store/products/" + code);
		String[] filenamesList = FileNameListUtil.getFileNameList(fileuploaded_path);
		
		for(String filename : filenamesList) {
			if(CollectionUtils.isEmpty(updatedFiles)) {	// 수정된 파일 목록이 없을 경우
				File file = new File(fileuploaded_path + "/" + filename);
				file.delete(); // 저장된 모든 파일 삭제
			}
			else if(!updatedFiles.contains(filename)) {	// 서버에 저장된 파일명과 수정된 파일명이 일치하지 않으면
				System.out.println("delete files : " + filename);
				
				File file = new File(fileuploaded_path + "/" + filename);
				file.delete();	// 해당 파일 삭제
			}
		}
		
		if(!CollectionUtils.isEmpty(addFiles)) {	// 추가 파일이 있을 경우
			int size = addFiles.size();
			String[] addFilepath = new String[size];	// 추가 파일경로를 저장할 배열
			
			for(int i = 0; i < size; i++) {
				MultipartFile file = addFiles.get(i);
			    String addFileName = file.getOriginalFilename();	// 추가 파일 원본 파일명
			    String newAddFilename = EditorUtil.getNewProductCodeFileName(addFileName, code, i);
			    
			    addFilepath[i] = fileuploaded_path + "/" + newAddFilename;
			    
			    File addFile = new File(addFilepath[i]);
				
				if(!addFile.exists()) {	// 해당 파일이 존재하지 않으면 파일 업로드
					try {
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(addFile));
						bos.write(addFiles.get(i).getBytes());
						bos.close();
					} catch (Exception e) {
						System.out.println("file upload fail : " + addFileName);
					} 
					System.out.println("file upload success : " + addFileName);
				}
				System.out.println("exist file : " + addFileName);
			}
		}
		boolean b = service.updateproduct(productdto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delproduct")
	public String delproduct(@RequestParam("checkedList") String[] checkedList) {
		System.out.println("AdminController delproduct " + new Date());
		
		boolean b = service.delproduct(checkedList);
		return str(b);
	}
	
	@PostMapping(value = "admin_updateorder")
	public String updateorder(OrderDto orderdto) {
		System.out.println("AdminController updateorder " + new Date());
		
		boolean b = service.updateorder(orderdto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delorder")
	public String delorder(@RequestParam("checkedList") String[] checkedList) {
		System.out.println("AdminController delorder " + new Date());
		
		boolean b = service.delorder(checkedList);
		return str(b);
	}
}
