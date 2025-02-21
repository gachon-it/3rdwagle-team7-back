package com.hackathon.wagle.global.auth.jwt.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    public static final String ACCESS_TOKEN_SUBJECT = "Authorization";
    private static final String ID_CLAIM = "id";
    private static final String EMAIL_CLAIM = "email";
    private static final String ROLE_CLAIM = "role";
    private static final String ROLE_PREFIX = "ROLE_";
    private static final String DUMMY_EMAIL = "dummy_email";
    private final Key key;

    public JwtProvider(@Value("${wagle.auth.jwt.key}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes()); // 키 변환
    }

    @Value("${wagle.auth.jwt.accessTokenExpiration}")
    private Long accessTokenExpiration;

    public String generateAccessToken(Long id, String email, String role) {
        return Jwts.builder()
                .claim(ID_CLAIM, id)
                .claim(EMAIL_CLAIM, email)
                .claim(ROLE_CLAIM, ROLE_PREFIX+role)
                .setSubject(ACCESS_TOKEN_SUBJECT) // 사용자 정보(고유 식별자)
                .setIssuedAt(new Date()) // 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration)) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256) // 서명 알고리즘
                .compact(); // 최종 문자열 생성
    }
}
