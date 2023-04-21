package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.ProductDao;
import com.dalrun.dto.ProductDto;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductDao dao;
    
    public List<ProductDto> allProductListService () {
        return dao.allProductList();
    }
    
    public ProductDto getProductData (String productId) {
        return dao.getProductData(productId);
    }
}
