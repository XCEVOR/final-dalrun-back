package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.ProductDto;
import com.dalrun.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    
    @GetMapping(value = "productlist")
    public List<ProductDto> productlist () {
        System.out.println("  ProductController List<ProductDto> productlist () { " + new Date());
        return service.productlist();
    }
}
