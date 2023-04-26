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
    
}