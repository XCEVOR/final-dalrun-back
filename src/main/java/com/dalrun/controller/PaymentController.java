package com.dalrun.controller;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import jakarta.servlet.http.HttpSession;

@RestController  // = @Controller + @Responsebody
public class PaymentController {
    

    @Value("${JAVA_ENV_TEST}") // env-hc.properties 파일에 등록된 JAVA_ENV_TEST 값 가져오기
    String envTestValue;
    
    @Value("${REST_API_KEY}") // env-hc.properties 파일에 등록된 REST_API_KEY 값 가져오기
    String env_REST_API_KEY;
    
    @Value("${REST_API_SECRET}") // env-hc.properties 파일에 등록된 REST_API_SECRET 값 가져오기
    String env_REST_API_SECRET;
    
    @GetMapping("/getEnvValueTest")
    public ResponseEntity<Object> getEnvTestValue() {
        return new ResponseEntity<Object>(envTestValue, HttpStatus.OK);
    }
    

    
    private IamportClient api;
    
    public PaymentController() {
        // REST API 키와 REST API secret 를 아래에 순서대로 입력.
        this.api = new IamportClient(env_REST_API_KEY, env_REST_API_SECRET);
    }
    
    // 결제 정보 불러오는 기본 메서드.
    @ResponseBody
    @GetMapping("/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(
            Model model
            , Locale locale
            , HttpSession session
            , @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException {
        
        System.out.println(" @ imp_uid: " + imp_uid);
        
        api = new IamportClient(env_REST_API_KEY, env_REST_API_SECRET);
        
        return api.paymentByImpUid(imp_uid);
    }
    
    
    
    
    
    @GetMapping(value = "/korean")
    public String korean () {
        System.out.println("  HelloController korean (): " + new Date());
        System.out.println(" @ imp_uid: " + envTestValue);
        System.out.println(" @ imp_uid: " + env_REST_API_KEY);
        System.out.println(" @ imp_uid: " + env_REST_API_SECRET);
        return "한글 나와요~ ^오^";
    }
    
    
}
