package com.hackathon.wagle.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 경로에 대해 CORS 허용
                        .allowedOrigins("*") // 모든 도메인 허용 (보안이 필요하면 특정 도메인만 입력)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "OPTIONS") // 허용할 HTTP 메서드
                        .allowedHeaders("*") // 모든 헤더 허용
                        .exposedHeaders("")
                        .allowCredentials(true); // 쿠키 포함 요청 허용
            }
        };
    }
}
