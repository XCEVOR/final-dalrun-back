package com.dalrun.service;

import com.dalrun.dao.LikeDao;
import com.dalrun.dto.LikeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LikeService {
    @Autowired
    LikeDao dao;

    public boolean like(String memId, int crewSeq){
        LikeDto dto = dao.getlike(new LikeDto(memId, crewSeq));
        if (dto==null){
            return dao.like(memId, crewSeq)==1;
        }else{
            return false;
        }
    }

    public boolean getlike(String memId, int crewSeq){
        return dao.getlike(new LikeDto(memId, crewSeq))!=null;
    }

    public boolean cancellike(String memId, int crewSeq){
        LikeDto dto = dao.getlike(new LikeDto(memId, crewSeq));
        if(dto==null){
            return false;
        }else{
            return dao.cancellike(memId, crewSeq)==1;
        }
    }
    
    public void likeUpcount(int crewSeq) {
    	dao.likeUpcount(crewSeq);
    }
    
    public void likeDowncount(int crewSeq) {
    	dao.likeDowncount(crewSeq);
    }
}