package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.CartDao;
import com.dalrun.dto.CartDto;

@Service
@Transactional
public class CartService {

    @Autowired
    CartDao dao;
    
    public boolean addToCart (CartDto cdto) {
        int isSucc = dao.addToCart(cdto);
        return isSucc > 0 ? true : false;
    }
    
    public List<CartDto> getCartList () {
        return dao.getCartList();
    }
    
    public List<CartDto> getUserCartList (String memId) {
        return dao.getUserCartList(memId);
    }
    
    public int getUserCartQuantity (String productId) {
        return dao.getUserCartQuantity(productId);
    }
    
    public boolean deleteCartItem (String productId) {
        int isSucc = dao.deleteCartItem(productId);
        return isSucc > 0 ? true : false;
    }
    
    public boolean updateCartItem (CartDto cdto) {
        int isSucc = dao.updateCartItem(cdto);
        return isSucc > 0 ? true : false;
    }
    
    public boolean emptyCart (String memId) {
        int isSucc = dao.emptyCart(memId);
        return isSucc > 0 ? true : false;
    }
    
}