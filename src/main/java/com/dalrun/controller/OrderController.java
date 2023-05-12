package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dao.OrderDao;
import com.dalrun.dto.CartDto;
import com.dalrun.dto.OrderDetailDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService service;
    
    @GetMapping(value = "orderlist")
    public List<OrderDto> orderlist () {
        System.out.println("  @ OrderController List<OrderDto> orderlist () { " + new Date());
        return service.orderlist();
    }
    

    @PostMapping(value = "writeOrderData")
    public Map<String, Object> writeOrderData (OrderDto oDto) {
        System.out.println("  @ OrderController String writeOrderData (CartDto cdto) { " + new Date());
        System.out.println(oDto);
        boolean isSucc = service.writeOrderData(oDto);
        
        long orderNumber = oDto.getOrderNumber();	// insert후 생성된 orderNumber
        System.out.println("orderNumber = " + orderNumber);
        
        Map<String, Object> resultMap = new HashMap<>();	// insert결과와 orderNumber저장할 map
        String isS = "SUCCESS";
        
        resultMap.put("orderNumber", orderNumber);
        
        if (isSucc == false) {
        	isS = "FAIL";
        }
        
        resultMap.put("result", isS);
        return resultMap;
    }
    
    @PostMapping(value = "writeOrderDetail")
    public String writeOrderDetail(@RequestBody List<OrderDetailDto> orderlist) {
    	System.out.println("  @ OrderController writeOrderDetail " + new Date());

    	boolean isSucc = service.writeOrderDetail(orderlist);
    	
    	if(!isSucc) return "FAIL";
    	return "SUCCESS";
    }
    
    @PostMapping(value = "getorder")
    public OrderDto getOrder(@RequestParam("target") long orderNumber) {
    	System.out.println("  @ OrderController getOrder " + new Date());
    	
    	OrderDto order = service.getOrder(orderNumber);
    	
    	return order;
    }
    
    @PostMapping(value = "getOrderDetail")
    public List<OrderDetailDto> getOrderDetail(long orderNumber) {
    	System.out.println("  @ OrderController getOrderDetail " + new Date());
    	
    	List<OrderDetailDto> orderdetail = service.getOrderDetail(orderNumber);
    	
    	return orderdetail;
    }
    
    @PostMapping(value = "getOrderInfo")
    public OrderDto getOrderInfo (long orderNumber) {
        System.out.println("  @ OrderController getOrderInfo " + new Date());
        
        OrderDto order = service.getOrder(orderNumber);
        
        return order;
    }
}

