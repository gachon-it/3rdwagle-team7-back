package com.hackathon.wagle.global.auth.jwt.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.wagle.global.auth.jwt.exception.ErrorMessage;
import com.hackathon.wagle.global.common.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static String LOG_FORMAT = "ExceptionClass: {}, Message: {}";
    private final static String CONTENT_TYPE = "application/json";
    private final static String CHAR_ENCODING = "UTF-8";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ErrorMessage jwtError = (ErrorMessage) request.getAttribute("jwtError");

        if (jwtError != null) {
            setResponse(response, jwtError.getMessage());
            log.error(LOG_FORMAT, jwtError, jwtError.getMessage());
        } else {
            setResponse(response, authException.getMessage());
            log.error(LOG_FORMAT, authException.getClass().getSimpleName(), authException.getMessage());
        }
    }

    private void setResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding(CHAR_ENCODING);

        String body = new ObjectMapper().writeValueAsString(ApiResponse.response(HttpStatus.UNAUTHORIZED, message));
        response.getWriter().write(body);
    }
}
