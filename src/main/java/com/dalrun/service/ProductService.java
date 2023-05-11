package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.ProductDao;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductDao dao;
    
    public List<ProductDto> allProductListService () {
        return dao.allProductList();
    }
    
    public List<ProductDto> allProductListDeduplication () {
        return dao.allProductListDeduplication();
    }
    
    public List<ProductDto> getProductData (String productCode) {
        return dao.getProductData(productCode);
    }
    
    public List<ProductDto> getSelectedProductInfo (ProductDto pdto) {
        return dao.getSelectedProductInfo(pdto);
    }
    
    public boolean updateProductView (ProductDto pdto) {
        int isSucc = dao.updateProductView(pdto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean updateProductLike (ProductDto pdto) {
        int isSucc = dao.updateProductLike(pdto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean updateProductRecomm (ProductDto pdto) {
        int isSucc = dao.updateProductRecomm(pdto);
        return isSucc > 0 ? true : false;
    }
    
    public List<ProductDto> getProductRecomm () {
        return dao.getProductRecomm();
    }
    
    public List<ProductDto> getAllProductListSortView () {
        return dao.getAllProductListSortView();
    }
    
    public List<ProductDto> getAllProductListSortLike () {
        return dao.getAllProductListSortLike();
    }
    
    
    
    
    public List<ProductInquiryDto> getProductInquiry () {
        return dao.getProductInquiry();
    }
    
    public boolean writeProductInquiry (ProductInquiryDto pidto) {
        int isSucc = dao.writeProductInquiry(pidto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean writeProductInquirySub (ProductInquiryDto pidto) {
        int isSucc = dao.writeProductInquirySub(pidto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean writeProductInquiryRefDepth (ProductInquiryDto pidto) {
        int isSucc = dao.writeProductInquiryRefDepth(pidto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean writeProductInquiryRefDepthSub (ProductInquiryDto pidto) {
        int isSucc = dao.writeProductInquiryRefDepthSub(pidto);
        return isSucc > 0 ? true : false;
    }
    
    public List<ProductInquiryDto> getProductinquiryAndReply(int inqSeq) {
		return dao.getProductinquiryAndReply(inqSeq);
	}
    
    
    
    
    public ProductDto getCartProductInfo (String productId) {
        return dao.getCartProductInfo(productId);
    }
    
    public boolean insertProduct(ProductDto pdto) {
		int n = dao.insertProduct(pdto);
		return n>0?true:false;
	}
    

}
