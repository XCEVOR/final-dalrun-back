package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.OrderDao;
import com.dalrun.dto.CartDto;
import com.dalrun.dto.OrderDetailDto;
import com.dalrun.dto.OrderDto;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao dao;
    
    public List<OrderDto> orderlist () {
        return dao.orderlist();
    }
    
    public boolean writeOrderData (OrderDto oDto ) {
        int num = dao.writeOrderData(oDto);
        return num > 0 ? true : false;
    }
    
    public boolean writeOrderDetail(List<OrderDetailDto> orderlist) {
		int n = dao.writeOrderDetail(orderlist);
		return n>0?true:false;
	}
    
    public OrderDto getOrder(long orderNumber) {
		return dao.getOrder(orderNumber);
	}
    
    public List<OrderDetailDto> getOrderDetail(long orderNumber) {
		return dao.getOrderDetail(orderNumber);
	}
  
}