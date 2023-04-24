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
    
    public List<ProductDto> getProductData (String productCode) {
        return dao.getProductData(productCode);
    }
    
    public boolean writeProductInquiry (ProductInquiryDto pidto) {
        int isSucc = dao.writeProductInquiry(pidto);
        return isSucc > 0 ? true : false;
    }
    

}
