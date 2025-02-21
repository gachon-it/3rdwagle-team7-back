package com.hackathon.wagle.domain.user.exception;

import com.hackathon.wagle.global.common.exception.BaseException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.hibernate.sql.exec.internal.BaseExecutionContext;
import org.springframework.http.HttpStatus;

import static com.hackathon.wagle.domain.user.exception.ErrorMessage.USER_NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super(BAD_REQUEST, USER_NOT_FOUND.getMessage());
    }
}
