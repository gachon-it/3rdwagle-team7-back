package com.hackathon.wagle.domain.user.dto.request;

public record UserLoginDto(
        String studentNumber,
        String password
) {
}
