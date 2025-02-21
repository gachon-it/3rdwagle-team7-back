package com.hackathon.wagle.domain.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    PASSWORD_NOT_MATCH("비밀번호가 일치하지 않습니다"),
    STUDENT_NUMBER_DUPLICATE("중복되는 학번입니다."),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다");


    private final String message;
}
