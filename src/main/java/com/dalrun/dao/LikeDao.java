package com.dalrun.dao;

import com.dalrun.dto.LikeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LikeDao {
    int like(String memId, int crewSeq);
    LikeDto getlike(LikeDto likedto);
    int cancellike(String memId, int crewSeq);
    
    //bbs likeCount update
    int likeUpcount(int crewSeq);
    int likeDowncount(int crewSeq);
}