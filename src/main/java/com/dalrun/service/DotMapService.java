package com.dalrun.service;

import com.dalrun.dao.DotMapDao;
import com.dalrun.dto.DotMapDto;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class DotMapService {
	
	 @Autowired
	 DotMapDao dao;

    
//    /* CREATE (도트맵 구매) */
//    @Transactional
//    public Long saveDot(DotMapDto.Request dotDto, Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("회원이 존재 하지 않습니다."));
//        dotDto.setUser(user);
//
//        return dotMapRepositoey.save(dotDto.toEntity()).getId();
//    }

    /* READ (구매자들 정보) */
   
    public List<DotMapDto> getDotMapInfo(){
      List<DotMapDto> dolist=dao.getAllDotMap();
      return dolist;
   }
   public boolean crew_buydotMap(DotMapDto dto){
	   return dao.crew_buydotMap(dto)>0;
	
   }
   public boolean my_buydotMap(DotMapDto dto){
	   return dao.my_buydotMap(dto)>0;
	
   }
   public boolean crewOutChangeDotmap(DotMapDto dto){
	  
	   return dao.crewOutChangeDotmap(dto)>0;
	
   }
   public boolean crewInChangeDotmap(DotMapDto dto){
	   return dao.crewInChangeDotmap(dto)>0;
	
   }

}
