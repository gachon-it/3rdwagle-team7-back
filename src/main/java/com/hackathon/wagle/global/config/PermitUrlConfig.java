package com.hackathon.wagle.global.config;

import org.springframework.stereotype.Component;

@Component
public class PermitUrlConfig {

    public String[] getPublicUrl(){
        return new String[]{
                "/**",
        };
    }

    public String[] getMemberUrl(){
        return new String[]{
        };
    }
}
