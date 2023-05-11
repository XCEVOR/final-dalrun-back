package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;

@Mapper
@Repository
public interface ProductDao {

    List<ProductDto> allProductList ();
    
    List<ProductDto> allProductListDeduplication ();
    
    List<ProductDto> getProductData (String productCode);
    
    List<ProductDto> getSelectedProductInfo (ProductDto pdto);
    
    int updateProductView (ProductDto pdto);
    
    int updateProductLike (ProductDto pdto);
    
    int updateProductRecomm (ProductDto pdto);
    
    List<ProductDto> getProductRecomm ();
    
    List<ProductDto> getAllProductListSortView ();
    
    List<ProductDto> getAllProductListSortLike ();
    
    
    
    
    List<ProductInquiryDto> getProductInquiry ();
    
    int writeProductInquiry (ProductInquiryDto pidto);
    
    int writeProductInquirySub (ProductInquiryDto pidto);
    
    int writeProductInquiryRefDepth (ProductInquiryDto pidto);
    
    int writeProductInquiryRefDepthSub (ProductInquiryDto pidto);
    
    List<ProductInquiryDto> getProductinquiryAndReply(int inqSeq);
    
    
    
    
    ProductDto getCartProductInfo (String productId);
    
    int insertProduct(ProductDto pdto);
    
}
