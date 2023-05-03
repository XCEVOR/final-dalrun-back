package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.ShoeReviewDao;
import com.dalrun.dto.ShoeDto;


@Service
@Transactional
public class ShoeReviewService {

    @Autowired
    ShoeReviewDao dao;
    
    public List<ShoeDto> getAllShoeReviewList () {
        return dao.getAllShoeReviewList();
    }
    
}