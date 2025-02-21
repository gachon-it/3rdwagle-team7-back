package com.hackathon.wagle.global.auth.jwt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    REFRESH_TOKEN_NOT_MATCH("[RefreshToken]이 [Redis]에 저장된 토큰과 다릅니다"),
    REFRESH_TOKEN_EXPIRED("[RefreshToken]이 만료됐습니다"),
    ACCESS_TOKEN_EXPIRED("[AccessToken]이 만료됐습니다"),
    ACCESS_TOKEN_NOT_FOUND("[AccessToken]을 찾을 수 없습니다"),
    JWT_TOKEN_FORBIDDEN("[Token]에 올바른 권한이 없습니다."),
    JWT_TOKEN_INVALID("유효한 [Token]이 아닙니다.");

    private final String message;
}
