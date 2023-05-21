package com.dalrun.controller;

import static org.hamcrest.CoreMatchers.notNullValue;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
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
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.ScoreRankDto;
import com.dalrun.dto.DashboardData;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDetailDto;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.dto.VisitorsDto;
import com.dalrun.service.AdminService;
import com.dalrun.service.CompetitionService;
import com.dalrun.service.CrewService;
import com.dalrun.service.DiaryService;
import com.dalrun.service.ProductService;
import com.dalrun.service.ShoeReviewService;
import com.dalrun.util.EditorUtil;
import com.dalrun.util.FileNameListUtil;
import com.dalrun.util.MultiFileUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	@Autowired
	CrewService crewService;
	@Autowired
	ProductService productService;
	@Autowired
	CompetitionService compService;
	@Autowired
	ShoeReviewService srService;
	@Autowired
	DiaryService diaryService;
	 
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
	    System.out.println(params.toString());
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
	
	@PostMapping(value = "getcrew") 
	public CrewDto getCrew(@RequestParam("target") int crewSeq) {
		System.out.println("AdminController getCrew " + new Date()); 
		return crewService.getMyCrewinfo(crewSeq); 
	}
	/*
	@PostMapping(value = "getCrewMember") 
	public List<CrewMemberDto> getCrewMember(int crewSeq) {
		System.out.println("AdminController getCrewMember " + new Date()); 
		return crewService.(crewSeq); 
	}
	*/
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
	// 문의
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
	
	// 리뷰
	@PostMapping(value = "getshoereview")
	public Map<String, Object> getshoereview(@RequestParam("target") int srSeq) {
		System.out.println("AdminController getshoereview " + new Date());
		
		Map<String, Object> srmap = new HashMap<>();
		
		ShoeReviewDto sr = srService.getShoereview(srSeq);
		List<ShoeReviewDetailDto> srd = srService.getShoereviewDetail(srSeq);
		
		srmap.put("sr", sr);
		srmap.put("srd", srd);
		
		return srmap;
	}
	
	@PostMapping(value = "shoereviewRegi") 
	public String shoereviewRegi(ShoeReviewDto srdto, @RequestParam(value="descList", required=false) String[] descList,
								  @RequestParam(value="fileList", required=false) List<MultipartFile> files,
								  @RequestParam(value="mainImg", required=false) MultipartFile mainImg,
								  HttpServletRequest req) throws UnsupportedEncodingException {
		
		System.out.println("AdminController shoereviewRegi " + new Date());
		
		int size = 0;
		
		if(files == null) size = 1;	// 대표 이미지만 등록할 경우
		else {
			size = files.size();
			files.add(0, mainImg);	// 저장할 파일들에 대표 이미지 파일 추가
		}		
		
		// 파일명 취득
		String[] oriFilenames = new String[size];	// 원본 파일명을 저장할 배열
		String[] newFilenames = new String[size];	// 파일명을 저장할 배열
		List<ShoeReviewDetailDto> srdList = new ArrayList<>();
		
		
		System.out.println("size= " + size);
		for(int i = 0; i < size; i++) {
			String filename = "";
			
			if(files == null) {	// 대표 이미지만 등록할 경우
				filename = mainImg.getOriginalFilename(); 
			} else {
				MultipartFile file = files.get(i);
				filename = file.getOriginalFilename();	// 원본 파일명				
			}
			
			oriFilenames[i] = filename;
			newFilenames[i] = MultiFileUtil.getMultiFileName(filename, i);	// 새로운 파일명
			
			System.out.println("oriFilename=" + oriFilenames[i]);
			System.out.println("newFilename=" + newFilenames[i]);
		}
		
		// DB에 파일명 저장
		srdto.setOriSrImage(oriFilenames[0]);
		srdto.setSrimage(newFilenames[0]);
		
		// 신발리뷰 등록
		boolean b = srService.shoereviewRegi(srdto);
		if(b) {	
			int seq = srdto.getSrSeq();
			
			// 파일 upload 경로			
			String path = req.getServletContext().getRealPath("/dalrun-hc/review/" + seq);
			System.out.println("fileupload path = " + path);
			
			
			// 리뷰상세정보
			if(descList != null) {
				for(int i = 0; i < descList.length; i++) {
					srdList.add(new ShoeReviewDetailDto(seq, descList[i], newFilenames[i+1], oriFilenames[i+1]));
				}
			}
			
			List<MultipartFile> newfiles = new ArrayList<>();
			newfiles.add(mainImg);
			
			// 서버에 파일 저장
			boolean isS = false;
			
			if(files == null) isS = MultiFileUtil.multiFileUpload(newfiles, size, path, newFilenames);
			else isS = MultiFileUtil.multiFileUpload(files, size, path, newFilenames);
			System.out.println("file upload " + isS);
			
			if(isS) {
				// 리뷰상세정보 저장
				if(descList != null) {
					boolean srb = srService.shoereviewDetailRegi(srdList);
					if(srb) return "YES";
				}
			};
		}
		
		return "YES";
		
	}

	@PostMapping(value = "admin_updateshoereview")
	public String updateshoereview(ShoeReviewDto srdto, @RequestParam(value = "srdSeq", required=false) List<Integer> srdSeq,
										@RequestParam(value = "updateImg", required=false) List<String> updatedFiles,
										@RequestParam(value="addFiles", required=false) List<MultipartFile> addFiles,
										@RequestParam(value="descList", required=false) String[] descList,
										@RequestParam(value="mainImg", required=false) MultipartFile mainImg,
										HttpServletRequest req) {
		
		System.out.println("AdminController updateshoereview " + new Date());
		
		int seq = srdto.getSrSeq();
		
		String fileuploaded_path = req.getServletContext().getRealPath("/dalrun-hc/review/" + seq);
		
		String[] filenamesList = FileNameListUtil.getFileNameList(fileuploaded_path);
		
		boolean delMainFile = false;
		
		List<Integer> srdSeqList = service.getSrdSeq(seq);
		
		if(srdSeq != null) {	// 삭제할 detail DB가 있을 경우
			for(int srdseq : srdSeqList) {
				System.out.println();
				if(!srdSeq.contains(srdseq)) {
					boolean b = service.delshoereviewdetail(srdseq);	// 해당 DB삭제
					if(b) System.out.println("detail data delete success : " + srdseq);
					else System.out.println("detail data delete fail : " + srdseq);
				}				
			}
			
			System.out.println(updatedFiles);
			for(String filename : filenamesList) {
				if(!updatedFiles.contains(filename)) {
					System.out.println("delete files : " + filename);
					
					File file = new File(fileuploaded_path + "/" + filename);
					file.delete();	// 해당 파일 삭제
				}
			}
			
		} else {
			for(int srdseq : srdSeqList) {
				boolean b = service.delshoereviewdetail(srdseq);	// 모든 detail DB삭제
				if(b) System.out.println("detail data delete success : " + srdseq);
				else System.out.println("detail data delete fail : " + srdseq);
			}
		}
		
		List<ShoeReviewDetailDto> srdList = new ArrayList<>();
		
		if(!CollectionUtils.isEmpty(addFiles)) {	// 추가 파일이 있을 경우
			int size = addFiles.size();
			
			String addFileNames[] = new String[size];	
			String newAddFilenames[] = new String[size];	
			
			if(mainImg == null) {	// 추가파일O + 대표이미지 변경X
				size = addFiles.size();
				
				for(int i = 0; i < size-1; i++) {				
					MultipartFile file = addFiles.get(i);
					
					addFileNames[i] = file.getOriginalFilename();	// 추가 파일 원본 파일명
					newAddFilenames[i] = MultiFileUtil.getMultiFileName(addFileNames[i], i);	// 추가 파일 새 파일명
					
					// 추가 파일 DB에 저장
					srdList.add(new ShoeReviewDetailDto(seq, descList[i], newAddFilenames[i], addFileNames[i]));
				} 
			}
			else {	// 추가파일O + 대표이미지 변경O
				size = addFiles.size() + 1;
				
				for(int i = 0; i < size; i++) {	
				// 대표 이미지 추가
				addFiles.add(0, mainImg);
				MultipartFile file = addFiles.get(i);
				
				// 대표 이미지 파일명
				addFileNames[i] = file.getOriginalFilename();	// 추가 파일 원본 파일명
				newAddFilenames[i] = MultiFileUtil.getMultiFileName(addFileNames[i], i);	// 추가 파일 새 파일명
				
				// 추가 파일 DB에 저장
				srdList.add(new ShoeReviewDetailDto(seq, descList[i], newAddFilenames[i], addFileNames[i]));
				}
			}
		
			
			// 대표이미지 DB에 파일명 저장
			srdto.setOriSrImage(addFileNames[0]);
			srdto.setSrimage(newAddFilenames[0]);
			
			// 추가 파일 업로드
			boolean upload = MultiFileUtil.multiFileUpload(addFiles, size, fileuploaded_path, newAddFilenames);
			if(upload) {
				System.out.println("addfiles upload success");
				
				boolean b = srService.shoereviewDetailRegi(srdList);	// detail DB에 저장
				if(b) System.out.println("detail data insert success");
			}
		} 
		
		if(mainImg != null) {	// 대표 이미지가 변경되면
			String mainFilename = mainImg.getOriginalFilename();
			String newMainFilename = MultiFileUtil.getMultiFileName(mainFilename, 0);
			
			// 대표이미지 DB에 파일명 저장
			srdto.setOriSrImage(mainFilename);
			srdto.setSrimage(newMainFilename);
			
			File mainfile = new File(fileuploaded_path + "/" + filenamesList[0]);
			mainfile.delete();	// 해당 파일 삭제
			
			File newMainFile = new File(fileuploaded_path + "/" + newMainFilename);
			
			if(!newMainFile.exists()) {	// 새로운 대표 이미지 저장
				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newMainFile));
					bos.write(mainImg.getBytes());
					bos.close();
				} catch (Exception e) {
					System.out.println(e);
					return "NO";
				} 
			}
		}
		
		// 값만 변경
		if(CollectionUtils.isEmpty(addFiles) && descList != null) {
			for(String desc : descList) {
				srdList.add(new ShoeReviewDetailDto(seq, desc));
			}
			boolean b = service.updateshoereviewdetail(srdList);
			if(b) System.out.println("update detail sccess");
		}
		
		
		// review DB 수정
		boolean b = service.updateshoereview(srdto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delshoereview")
	public String delshoereview(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController delshoereview " + new Date());
		
		boolean b = service.delshoereview(checkedList);
		return str(b);
	}
	
	// 다이어리
	@PostMapping(value = "getdiary")
	public DiaryDto getDiary(@RequestParam("target") int diarySeq) {
		System.out.println("AdminController getDiary " + new Date());
		
		DiaryDto diary = diaryService.getDiary(diarySeq);
		return diary;
	}
	
	@PostMapping(value = "admin_updatediary")
	public String updatediary(DiaryDto diarydto) {
		System.out.println("AdminController updatediary " + new Date());
		
		boolean b = service.updatediary(diarydto);
		return str(b);
	}
	
	@PostMapping(value = "admin_deldiary")
	public String deldiary(@RequestParam("checkedList") int[] checkedList) {
		System.out.println("AdminController deldiary " + new Date());
		
		boolean b = service.deldiary(checkedList);
		return str(b);
	}
	
	// 대회 일정
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
		
	    return response.toString();
	}
	
	@PostMapping(value = "competitionRegi")
	public String competitionRegi(CompetitionDto compdto,
								  @RequestParam(value="uploadImg", required=false) MultipartFile img,
								  HttpServletRequest req) {
		
		System.out.println("AdminController competitionRegi " + new Date());
		
		// 이미지 upload 경로
		String path = req.getServletContext().getRealPath("/dalrun-hc/competition");
		
		// 파일명 취득후 저장
		String orignalFileName = img.getOriginalFilename();	// 원본 파일명
		String newFileName = EditorUtil.getNewFileName(orignalFileName);  // 새로운 파일명
		System.out.println("oriname=" + orignalFileName + " newname=" + newFileName);
		
		compdto.setCompimage(newFileName);
		compdto.setOriCompimage(orignalFileName);
		
		String filepath = path + "/" + newFileName;
		
		boolean b = compService.insertcompetition(compdto);
		if(b) {
			// 파일 업로드
			File file = new File(filepath);
			
			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				bos.write(img.getBytes());
				bos.close();
			} catch (Exception e) {
				return "file upload fail";
			} 
			return "YES";			
		}
		return "NO";
	}
	
	@PostMapping(value = "admin_updatecomperition")
	public String updatecomperition(CompetitionDto compdto,
									@RequestParam(value = "uploadImg", required=false) MultipartFile img,
									HttpServletRequest req) {
		
		System.out.println("AdminController updatecomperition " + new Date());
		System.out.println(compdto.toString());
		
		String path = req.getServletContext().getRealPath("/dalrun-hc/competition");
		String filename = compdto.getCompimage();
		
		File file = new File(path + "/" + filename);	// 기존의 파일
		
		if(img != null) {	// 파일 수정
			// 기존의 파일과 중복되지 않으면 기존의 파일 삭제 후 저장
			String orignalFileName = img.getOriginalFilename();	// 원본 파일명
			
			if(!compdto.getOriCompimage().equals(orignalFileName)) {
				System.out.println("update file");
				
				// 기존의 파일을 삭제하고 새로 저장(이름은 그대로 유지)
				file.delete();
				compdto.setOriCompimage(orignalFileName);

				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(img.getBytes());
					bos.close();
				} catch (Exception e) {
					return "file upload fail";
				} 
			} else { // 파일 중복
				System.out.println("exist file");
				compdto.setCompimage("");
				compdto.setOriCompimage("");
			}
		}
		else {	// 기존의 파일 유지
			System.out.println("keep file");
			compdto.setCompimage("");
			compdto.setOriCompimage("");
		}
		
		boolean b = service.updatecomperition(compdto);
		return str(b);
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
		System.out.println("add file =" + addFiles);
		
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
	
	// 대시보드
	@GetMapping(value = "getDashboardData")
	public DashboardData getDashboardData() {
		System.out.println("AdminController getDashboardData " + new Date());
		
		return service.getDashboardData();
	}
	
	@GetMapping(value = "getWeekSummaryData")
	public List<DashboardData> getWeekSummaryData() {
		System.out.println("AdminController getWeekSummaryData " + new Date());
		
		return service.getWeekSummaryData();
	}
	
	// 차트
	@PostMapping(value = "getScoreRank")
	public Map<String, Object> getScoreRank() {
		System.out.println("AdminController getScoreRank " + new Date());
		
		List<Integer> crewSeqList = service.getCrweSeqList();
		List<CrewDto> crewList = new ArrayList<>();
		
		for(int crewSeq : crewSeqList) {
			CrewDto crew = crewService.getMyCrewinfo(crewSeq);
			System.out.println(crew.getCrewTotalScore());
			crewList.add(crew);
		}
		
		crewList.sort(Comparator.comparingLong(CrewDto::getCrewTotalScore).reversed());

		List<ScoreRankDto> crewRank = new ArrayList<>();
		for (CrewDto crew : crewList) {
			int currMonth = YearMonth.now().getMonthValue();
			int currYear = YearMonth.now().getYear();
			
			ScoreRankDto dto = new ScoreRankDto(currMonth, currYear, crew.getCrewSeq(), crew.getCrewName(), crew.getMemId(), 0, crew.getCrewLevel(), crew.getCrewTotalScore(), 0); 
			crewRank.add(dto);
        }
		
		List<ScoreRankDto> memRank = service.getMemberScoreRank();
		
		Map<String, Object> rankMap = new HashMap<>();
		rankMap.put("memRank", memRank);
		rankMap.put("crewRank", crewRank);
		
		return rankMap;
	}
	
	// 방문자
	@PostMapping(value = "saveCookieData")
	public String saveCookieData(@RequestParam("user") String user) {
		System.out.println("AdminController saveCookieData " + new Date());
		
    	boolean s = service.saveCookieData(user);
    	if(!s) return "NO";
    	else System.out.println("save cookie data");
		
		return "YES";
	}
	
	@PostMapping(value = "updateCookie")
	public String updateCookie(@RequestParam("user") String user) {
		System.out.println("AdminController updateCookie " + new Date());
		
		// 마지막 방문 시간 업데이트
		boolean b = service.updateCookie(user);
		if(b) System.out.println("update cookie data");
		return str(b);
	}
	@GetMapping(value = "getDailyVisitorsCnt")
	public List<VisitorsDto> getDailyVisitorsCnt() {
		System.out.println("AdminController getDailyVisitorsCnt " + new Date());
		
		return service.getDailyVisitorsCnt();
	}
}
