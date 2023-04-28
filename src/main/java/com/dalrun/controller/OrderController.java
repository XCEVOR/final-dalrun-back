package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CartDto;
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
    public String writeOrderData (OrderDto oDto) {
        System.out.println("  @ OrderController String writeOrderData (CartDto cdto) { " + new Date());
        System.out.println(oDto);
        boolean isSucc = service.writeOrderData(oDto);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }

}

