package com.dalrun.controller;

//import com.board.board.config.LoginUser;
//import com.board.board.config.auth.SessionUser;
import com.dalrun.dto.DotMapDto;
import com.dalrun.service.DotMapService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller @RequestMapping("earth")
public class earthController {
	

    private final DotMapService dotMapService=null;
    
/*
//    @Operation(summary = "페이지를 반환", description = "도트맵 페이지를 반환 합니다.")
    @GetMapping("")
    public String earthPage(Model model) {
        List<DotMapDto.Response> dotList = dotMapService.getDotMapInfo();
        model.addAttribute("dotList",dotList);
        return "earth/earth";
    }

//    @Operation(summary = "도트맵 구매 요청", description = "스마트컨트랙트가 성공적으로 마쳤을때 호출 됩니다.")
    @PostMapping("/{userid}")
    public ResponseEntity buyDot(@PathVariable Long userid ,@RequestBody DotMapDto.Request dotDto,@LoginUser SessionUser sessionUser) {

        if(!userid.equals(sessionUser.getId())) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(dotMapService.saveDot(dotDto,userid));
    }
    */
}
