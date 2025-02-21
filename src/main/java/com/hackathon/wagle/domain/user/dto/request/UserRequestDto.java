package com.hackathon.wagle.domain.user.dto.request;

public record UserRequestDto(
        String username,
        String studentNumber,
        String major,
        String email,
        String password
) {
}
