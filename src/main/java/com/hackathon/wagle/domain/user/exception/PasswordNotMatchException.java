package com.hackathon.wagle.domain.user.exception;

import com.hackathon.wagle.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.hackathon.wagle.domain.user.exception.ErrorMessage.PASSWORD_NOT_MATCH;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class PasswordNotMatchException extends BaseException {
    public PasswordNotMatchException() {
        super(BAD_REQUEST, PASSWORD_NOT_MATCH.getMessage());
    }
}
