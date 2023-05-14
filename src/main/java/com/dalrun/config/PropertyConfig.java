package com.dalrun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource("classpath:properties/env-hc.properties") // env-hc.properties 파일 소스 등록
})

public class PropertyConfig {

}