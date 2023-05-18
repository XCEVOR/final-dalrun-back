package com.dalrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.service.ProductService;
import com.dalrun.util.EditorUtil;
import com.dalrun.util.FileNameListUtil;
import com.dalrun.util.MultiFileUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    
    
    // ====================================================================================================    
    // server test
    @GetMapping(value = "allProductListGetMapping")
    public List<ProductDto> allProductListGetMapping () {
        System.out.println("  @ ProductController List<ProductDto> productlist () { " + new Date());
        return service.allProductListService();
    }

    @GetMapping(value = "allProductListDeduplication")
    public List<ProductDto> allProductListDeduplication () {
        System.out.println("  @ ProductController List<ProductDto> allProductListDeduplication () { " + new Date());
        System.out.println("  @ service.allProductListDeduplication() { " + service.allProductListDeduplication());
        return service.allProductListDeduplication();
    }
    
    @PostMapping(value = "getProductData")
    public List<ProductDto> getProductData (String productCode) {
        System.out.println("  @ ProductController ProductDto getProductData (String productCode) { " + new Date());
        return service.getProductData(productCode);     
    }
    
    @PostMapping(value = "getSelectedProductInfo")
    public List<ProductDto> getSelectedProduct (String productCode, String productColor, String productSize) {
        System.out.println("  @ ProductController getSelectedProduct { " + new Date());
        System.out.println("  @ String productCode, String productColor, String productSize) {" + productCode + " " + productColor + " " + productSize);
        ProductDto pdto = new ProductDto(productCode, productColor, productSize);
        return service.getSelectedProductInfo(pdto);
    }
    
    @PostMapping(value = "updateProductView")
    public String updateProductView (ProductDto pdto) {
        System.out.println("  @ ProductController updateProductView (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pdto);
        boolean isSucc = service.updateProductView(pdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "updateProductLike")
    public String updateProductLike (ProductDto pdto) {
        System.out.println("  @ ProductController updateProductLike (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pdto);
        boolean isSucc = service.updateProductLike(pdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "updateProductRecomm")
    public String updateProductRecomm (ProductDto pdto) {
        System.out.println("  @ ProductController updateProductRecomm (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pdto);
        boolean isSucc = service.updateProductRecomm(pdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "getProductRecomm")
    public List<ProductDto> getProductRecomm () {
        System.out.println("  @ ProductController getProductRecomm { " + new Date());
        return service.getProductRecomm();
    }
    
    @PostMapping(value = "getAllProductListSortView")
    public List<ProductDto> getAllProductListSortView () {
        System.out.println("  @ ProductController getAllProductListSortView { " + new Date());
        return service.getAllProductListSortView();
    }
    
    @PostMapping(value = "getAllProductListSortLike")
    public List<ProductDto> getAllProductListSortLike () {
        System.out.println("  @ ProductController getAllProductListSortLike { " + new Date());
        return service.getAllProductListSortLike();
    }
    
    
    
    @PostMapping(value = "getProductInquiry")
    public List<ProductInquiryDto> getProductInquiry (String productCode) {
        System.out.println("ProductController ProductDto getProductData (String productCode) { " + new Date());
        System.out.println(productCode);
        return service.getProductInquiry();     
    }
    
    @PostMapping(value = "writeProductInquiry")
    public String writeProductInquiry (ProductInquiryDto pidto) {
        System.out.println("  @ ProductController writeProductInquiry (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pidto);
        boolean isSucc = service.writeProductInquiry(pidto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "writeProductInquirySub")
    public String writeProductInquirySub (ProductInquiryDto pidto) {
        System.out.println("  @ ProductController writeProductInquirySub (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pidto);
        boolean isSucc = service.writeProductInquirySub(pidto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "writeProductInquiryRefDepth")
    public String writeProductInquiryRefDepth (ProductInquiryDto pidto) {
        System.out.println("  @ ProductController writeProductInquiryRefDepth (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pidto);
        boolean isSucc = service.writeProductInquiryRefDepth(pidto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "writeProductInquiryRefDepthSub")
    public String writeProductInquiryRefDepthSub (ProductInquiryDto pidto) {
        System.out.println("  @ ProductController writeProductInquiryRefDepthSub (ProductInquiryDto pidto) { " + new Date());
        System.out.println(pidto);
        boolean isSucc = service.writeProductInquiryRefDepthSub(pidto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";  
    }
    
    @PostMapping(value = "getproductinquiry")
    public List<ProductInquiryDto> getProductinquiryAndReply(@RequestParam("target") int inqSeq) {
    	System.out.println("  @ ProductController getProductinquiryAndReply " + new Date());
    	
    	List<ProductInquiryDto> inqAndReply = service.getProductinquiryAndReply(inqSeq);
    	return inqAndReply;
    }
    

    
    
    @GetMapping(value = "getpath")
    public void getpath (HttpServletRequest hsreq) {
        String fileuploaded_path = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        System.out.println("  @@ fileuploaded_path: " + fileuploaded_path);
    }
    
    @GetMapping(value = "getFileNamePath")
    public void getFileNamePath (HttpServletRequest hsreq) {
        String fileuploaded_path = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        FileNameListUtil.getFileNameList(fileuploaded_path);
        System.out.println("  @@ fileuploaded_path: " + fileuploaded_path);
    }
    
    @PostMapping(value = "getProductAllPictureList")
    public String[] getProductAllPictureList (String productCode, HttpServletRequest hsreq) {
        // 실제 배포시 문제 가능성 예상. 어떻게 될지 모르겠으니 예의주시 바람. HttpServletRequest 에 따름.
        String fileuploaded_path = hsreq.getServletContext().getRealPath("/dalrun-hc/store/products/" + productCode);
      
        System.out.println("  @@ fileuploaded_path: " + fileuploaded_path);
        
        String[] filenamesList = FileNameListUtil.getFileNameList(fileuploaded_path);
        
        return filenamesList;
    }
    
    @PostMapping(value = "getProductAllRecommPictureList")
    public String[] getProductAllRecommPictureList (String productCode, HttpServletRequest hsreq) {
        // 실제 배포시 문제 가능성 예상. 어떻게 될지 모르겠으니 예의주시 바람. HttpServletRequest 에 따름.
        String fileuploaded_path = hsreq.getServletContext().getRealPath("/dalrun-hc/store/recomproducts/" + productCode);
      
        System.out.println("  @@ fileuploaded_path: " + fileuploaded_path);
        
        String[] filenamesList = FileNameListUtil.getFileNameList(fileuploaded_path);
        
        return filenamesList;
    }
    
    
    
    
    // ====================================================================================================    
    // upload test
    @PostMapping(value = "/uploadMyFile")
    public String uploadMyFile (ProductDto pdto,  // 폼 필드의 정보들.
                                @RequestParam(value = "fileupload_RequestParam", required = false)
                                MultipartFile mpFileLoad,  // 업로드시 파일 바이트로 넘어옴.
                                HttpServletRequest hsreq) {  // 파일 업로드 경로를 얻어오기 위함.
        
        System.out.println("  @ ProductController uploadMyFile ()");
        System.out.println(pdto.toString());
        System.out.println("  @ hsreq: " + hsreq);
        
        
        // upload의 경로 설정.
        // server
        String fileupload_path = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        
        
        // 파일 저장 경로 확인.
        System.out.println("  @@ fileupload_path: " + fileupload_path);
        
        
        // filename 취득. (이 라인에서 파일 이름이 null 인지 판단하여 파일이 들어온지 확인. 그렇지 않으면 아래 코드 실행 X)
        String origFilename = mpFileLoad.getOriginalFilename();  // 불러온 원본 파일명.
        
        // pdto origFilename에 저장.
        String newFilename = EditorUtil.getNewFileName(origFilename);
        
        // pdto newFilename에 저장.
        
        
        // 파일 업로드 경로.
        String fileupload_file_path = fileupload_path + "/" + newFilename;
        System.out.println("  @@ fileupload_file_path: " + fileupload_file_path);
        
        
        File myFile = new File(fileupload_file_path);
        try {
            BufferedOutputStream bufoutStream = new BufferedOutputStream(new FileOutputStream(myFile));
            bufoutStream.write(mpFileLoad.getBytes());
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
    
    // 상품 등록
    /*
    @PostMapping(value = "productRegi")
	public String productRegi(ProductDto pdto,
							  @RequestParam(value="fileList", required=false) List<MultipartFile> files,
							  HttpServletRequest request) {
		
		System.out.println("AdminController productRegi " + new Date());
		
		// 파일 upload 경로
		String path = request.getServletContext().getRealPath("/dalrun-hc/store/products/" + pdto.getProductCode());
		System.out.println(" fileUpload path = " + path);
				
		// 폴더 생성
		File folder = new File(path);
		if(!folder.exists()) {
			try {
				folder.mkdir();
				System.out.println("폴더 생성 성공");				
			} catch (Exception e) {
				System.out.println("폴더 생성 실패");
			}
		}
			
		// 파일명 취득후 저장
		int size = files.size();
		String[] filenames = new String[size];	// 원본 파일명을 저장할 배열
		// String[] newFilenames = new String[size];	// 새로운 파일명을 저장할 배열
		String[] filepath = new String[size];	// 파일경로를 저장할 배열
		
		for(int i = 0; i < size; i++) {
		    MultipartFile file = files.get(i);
		    String fileName = file.getOriginalFilename();	// 원본 파일명
		    // String newFileName = EditorUtil.getNewFileName(fileName);	// 새로운 파일명
		    
		    // filenames[i] = fileName;
		    filenames[i] = EditorUtil.getNewProductCodeFileName(fileName, pdto.getProductCode(), i);  // ProductCode == newFolder == newFileName+(num)
		    // newFilenames[i] = newFileName;
		    // filepath[i] = path + "/" + fileName;
		    filepath[i] = path + "/" + EditorUtil.getNewProductCodeFileName(fileName, pdto.getProductCode(), i);  // ProductCode == newFolder == newFileName+(num)
		    
		    System.out.println("filepath = " + filepath[i]);
		}
		
		// ;으로 구분된 하나의 문자열로 저장
		// pdto.setProductOrigFile(String.join(";", filenames));
		// pdto.setProductNewFile(String.join(";", newFilenames));
		System.out.println(pdto.toString());
		
		// 상품 등록
		boolean b = service.insertProduct(pdto);
		if(b) {
			// 파일 업로드
			for(int i = 0; i < size; i++) {
				File file = new File(filepath[i]);
				
				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(files.get(i).getBytes());
					bos.close();
				} catch (Exception e) {
					return "file upload fail";
				} 
			}
			return "YES";			
		}
		return "NO";
	}
	*/
    
    // 상품 등록
    @PostMapping(value = "productRegi")
	public String productRegi(ProductDto pdto,
							  @RequestParam(value="fileList", required=false) List<MultipartFile> files,
							  HttpServletRequest request) {
		
		System.out.println("AdminController productRegi " + new Date());
		
		// 파일 upload 경로
		String path = request.getServletContext().getRealPath("/dalrun-hc/store/products/" + pdto.getProductCode());
		System.out.println(" fileUpload path = " + path);
			
		// 파일명 취득후 저장
		int size = files.size();
		String[] newFilenames = new String[size];	// 파일명을 저장할 배열
	
		for(int i = 0; i < size; i++) {
		    MultipartFile file = files.get(i);
		    String fileName = file.getOriginalFilename();	// 원본 파일명
		    
		    newFilenames[i] = EditorUtil.getNewProductCodeFileName(fileName, pdto.getProductCode(), i);  // ProductCode == newFolder == newFileName+(num)
		}
		
		boolean isS = MultiFileUtil.multiFileUpload(files, size, path, newFilenames);
		
		System.out.println(pdto.toString());
		
		if(isS) {			
			// 상품 등록
			boolean b = service.insertProduct(pdto);
			if(b) {
				return "YES";			
			}
		}
		return "NO";
	}
    
}
