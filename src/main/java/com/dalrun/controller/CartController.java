package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CartDto;
import com.dalrun.service.CartService;

@RestController
public class CartController {

    @Autowired
    CartService service;
    
    @PostMapping(value = "addToCart")
    public String addToCart (CartDto cdto) {
        System.out.println("  @ OrderController String addToCart (CartDto cdto) { " + new Date());
        System.out.println(cdto);
        boolean isSucc = service.addToCart(cdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    @PostMapping(value = "getCartList")
    public List<CartDto> getCartList () {
        System.out.println("  @ CartController List<CartDto> getCartList () { " + new Date());
        return service.getCartList();
    }
    
    
    
}



