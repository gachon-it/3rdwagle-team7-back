package com.hackathon.wagle.domain.user.exception;

import com.hackathon.wagle.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.hackathon.wagle.domain.user.exception.ErrorMessage.STUDENT_NUMBER_DUPLICATE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class DuplicatedStudentNumberException extends BaseException {
    public DuplicatedStudentNumberException() {
        super(BAD_REQUEST, STUDENT_NUMBER_DUPLICATE.getMessage());
    }
}
