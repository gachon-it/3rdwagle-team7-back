package com.hackathon.wagle.domain.user.controller;

import com.hackathon.wagle.domain.user.dto.request.UserRequestDto;
import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.service.UserService;
import com.hackathon.wagle.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.hackathon.wagle.domain.user.controller.SuccessMessage.USER_CREATED;
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

}
