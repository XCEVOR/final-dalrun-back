package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CartDto;
import com.dalrun.dto.OrderDetailDto;
import com.dalrun.dto.OrderDto;

@Mapper
@Repository
public interface OrderDao {

    List<OrderDto> orderlist ();
    
    int writeOrderData (OrderDto oDto);
    
    int writeOrderDetail(List<OrderDetailDto> orderlist);
    
    OrderDto getOrder(long orderNumber);
    
    List<OrderDetailDto> getOrderDetail(long orderNumber);
    
}
