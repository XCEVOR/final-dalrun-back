package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CartDto;

@Mapper
@Repository
public interface CartDao {

    int addToCart (CartDto cdto);
    
    List<CartDto> getCartList ();
    
    List<CartDto> getUserCartList (String memId);
    
    int getUserCartQuantity (String memId);
    
    int deleteCartItem (String productId);
    
    int updateCartItem (CartDto cdto);
    
    int emptyCart (String memId);
    
}





