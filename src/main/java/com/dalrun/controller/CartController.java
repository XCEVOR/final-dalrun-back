package com.dalrun.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CartDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.service.CartService;
import com.dalrun.service.ProductService;

@RestController
public class CartController {

    @Autowired
    CartService service;
    @Autowired
    ProductService prodservice;
    
    @PostMapping(value = "addToCart")
    public String addToCart (CartDto cdto) {
        System.out.println("  @ CartController String addToCart (CartDto cdto) { " + new Date());
        System.out.println(cdto);
        boolean isSucc = service.addToCart(cdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    @PostMapping(value = "getCartList")
    public List<CartDto> getCartList (String memId) {
        System.out.println("  @ CartController List<CartDto> getCartList () { " + new Date());
        return service.getCartList();
    }
    
    @PostMapping(value = "getUserCartList")
    public List<CartDto> getUserCartList (String memId) {
        System.out.println("  @ CartController List<CartDto> getUserCartList () { " + new Date());
        System.out.println("  @ memId: " + memId);
        return service.getUserCartList(memId);
    }
    
    @PostMapping(value = "getUserCartQuantity")
    public int getUserCartQuantity (String memId) {
        System.out.println("  @ CartController int getUserCartQuantity (String memId) { " + new Date());
        System.out.println("  @ memId: " + memId);
        return service.getUserCartQuantity(memId);
    }
    
    @PostMapping(value = "getUserCartInfoList")  // 카트의 상품 내용을 포기하기 위한 메서드
    public List<ProductDto> getUserCartInfoList (String memId) {
        System.out.println("  @ CartController List<CartDto> getUserCartList () { " + new Date());
        System.out.println("  @ memId: " + memId);
        
        List<CartDto> productIdList = service.getUserCartList(memId);  // 로그인된 멤버 아이디로 카트에 저장된 모든 productId 를 가져옴.
        List<ProductDto> productInfoList =  new ArrayList();  // 카트에 담딘 상품의 정보만 담기 위한 list
        
        
        for (CartDto cDto : productIdList) {  // productId 를 하나씩 빼내어 그에 해당하는 상품의 모든 정보를 저장.
            System.out.println(cDto.getProductId());
            System.out.println(cDto.getCartProdQuantity());
            String productId = cDto.getProductId();  // cDto 에서 productId 만 빼냄.
            
            ProductDto cartProdInfoDto = prodservice.getCartProductInfo(productId);  // productId 로 해당 상품의 개별 정보를 가져옴.
            System.out.println(cartProdInfoDto);
            productInfoList.add(cartProdInfoDto);  // 개별 정보를 list 하나씩 저장.
        }
        
        System.out.println(Arrays.toString(productInfoList.toArray()));
        
        return productInfoList;  // 완성된 상품 정보 리스트를 프론트에 반환함.
    }
    
    @PostMapping(value = "getHashmapUserCartInfoQuantityList")  // 카트의 상품 내용을 포기하기 위한 메서드
    public HashMap<String, Object> getHashmapUserCartInfoQuantityList (String memId) {
        System.out.println("  @ CartController List<CartDto> getUserCartList () { " + new Date());
        System.out.println("  @ memId: " + memId);
        
        
        List<CartDto> productIdList = service.getUserCartList(memId);  // 로그인된 멤버 아이디로 카트에 저장된 모든 productId 를 가져옴.
        List<ProductDto> productInfoList =  new ArrayList();  // 카트에 담딘 상품의 정보만 담기 위한 list
        
        
        for (CartDto cDto : productIdList) {  // productId 를 하나씩 빼내어 그에 해당하는 상품의 모든 정보를 저장.
            System.out.println(cDto.getProductId());
            System.out.println(cDto.getCartProdQuantity());
            String productId = cDto.getProductId();  // cDto 에서 productId 만 빼냄.
            
            ProductDto cartProdInfoDto = prodservice.getCartProductInfo(productId);  // productId 로 해당 상품의 개별 정보를 가져옴.
            System.out.println(cartProdInfoDto);
            productInfoList.add(cartProdInfoDto);  // 개별 정보를 list 하나씩 저장.
        }
        
        System.out.println(Arrays.toString(productInfoList.toArray()));
        
        
        HashMap<String, Object> multiProductInfoQuantityMap = new HashMap<>();
        multiProductInfoQuantityMap.put("productInfoList", productInfoList);
        multiProductInfoQuantityMap.put("productIdList", productIdList);
        
        return multiProductInfoQuantityMap;  // 완성된 상품 정보 리스트를 프론트에 반환함.
    }
    
    @PostMapping(value = "deleteCartItem")
    public String deleteCartItem (String productId) {
        System.out.println("  @ CartController String deleteCartItem (String productId) { " + new Date());
        System.out.println("System.out.println(productId); " + productId);
        boolean isSucc = service.deleteCartItem(productId);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    @PostMapping(value = "updateCartItem")
    public String updateCartItem (CartDto cdto) {
        System.out.println("  @ CartController String updateCartItem (CartDto cdto) { " + new Date());
        System.out.println("System.out.println(cdto); " + cdto);
        boolean isSucc = service.updateCartItem(cdto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    @PostMapping(value = "emptyCart")
    public String emptyCart (String memId) {
        System.out.println("  @ CartController String emptyCart (String memId) { " + new Date());
        System.out.println("System.out.println(productId); " + memId);
        boolean isSucc = service.emptyCart(memId);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    
}



