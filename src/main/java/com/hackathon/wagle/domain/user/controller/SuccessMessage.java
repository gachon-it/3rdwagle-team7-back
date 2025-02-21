package com.hackathon.wagle.domain.user.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    USER_LOGIN("로그인에 성공했습니다!"),
    USER_CREATED("회원가입에 성공했습니다!");

    private final String message;
}
