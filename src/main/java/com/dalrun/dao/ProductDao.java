package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.ProductDto;

@Mapper
@Repository
public interface ProductDao {

    List<ProductDto> allProductList ();
    
    List<ProductDto> getProductData (String productCode);
    
}
