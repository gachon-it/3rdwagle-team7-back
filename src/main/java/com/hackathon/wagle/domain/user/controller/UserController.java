package com.hackathon.wagle.domain.user.controller;

import com.hackathon.wagle.domain.user.dto.request.UserRequestDto;
import com.hackathon.wagle.domain.user.dto.request.UserLoginDto;
import com.hackathon.wagle.domain.user.dto.response.LoginDto;
import com.hackathon.wagle.domain.user.service.UserService;
import com.hackathon.wagle.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.hackathon.wagle.domain.user.controller.SuccessMessage.USER_CREATED;
import static com.hackathon.wagle.domain.user.controller.SuccessMessage.USER_LOGIN;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ApiResponse<Void> register(@RequestBody UserRequestDto dto) {

        userService.saveUser(dto);

        return ApiResponse.response(OK, USER_CREATED.getMessage());
    }

    @PostMapping("/api/login")
    public ApiResponse<LoginDto> login(@RequestBody UserLoginDto dto) {

        LoginDto response = userService.login(dto);


        return ApiResponse.response(OK, USER_LOGIN.getMessage(), response);
    }

}
