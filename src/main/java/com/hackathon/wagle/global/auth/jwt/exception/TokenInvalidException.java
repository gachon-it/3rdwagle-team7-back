package com.hackathon.wagle.global.auth.jwt.exception;


import com.hackathon.wagle.global.common.exception.BaseException;

import static com.hackathon.wagle.global.auth.jwt.exception.ErrorMessage.JWT_TOKEN_INVALID;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class TokenInvalidException extends BaseException {

    public TokenInvalidException() {
        super(BAD_REQUEST, JWT_TOKEN_INVALID.getMessage());
    }
}
