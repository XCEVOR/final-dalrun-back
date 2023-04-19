package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.OrderDao;
import com.dalrun.dto.OrderDto;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao dao;
    
    public List<OrderDto> orderlist () {
        return dao.orderlist();
    }
}