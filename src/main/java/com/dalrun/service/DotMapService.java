package com.dalrun.service;

import com.dalrun.domain.DotMap;
import com.dalrun.domain.User;
import com.dalrun.dto.DotMapDto;
//import com.dalrun.repository.DotMapRepository;
//import com.dalrun.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DotMapService {
//    private final DotMapRepository dotMapRepositoey;
//    private final UserRepository userRepository;
//    
//    public DotMapService(final DotMapRepository dotMapRepositoey ,final UserRepository userRepository) {
//    	this.dotMapRepositoey=dotMapRepositoey;
//    	this.userRepository=userRepository;
//		// TODO Auto-generated constructor stub
//	}

//    /* CREATE (도트맵 구매) */
//    @Transactional
//    public Long saveDot(DotMapDto.Request dotDto, Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("회원이 존재 하지 않습니다."));
//        dotDto.setUser(user);
//
//        return dotMapRepositoey.save(dotDto.toEntity()).getId();
//    }

    /* READ (구매자들 정보) */
//    @Transactional(readOnly = true)
//    public List<DotMapDto.Response> getDotMapInfo(){
//        List<DotMap> dotMapList = dotMapRepositoey.findAll();
//        List<DotMapDto.Response> dotList = dotMapList.stream().map(DotMapDto.Response::new).collect(Collectors.toList());
//        return dotList;
//    }

}