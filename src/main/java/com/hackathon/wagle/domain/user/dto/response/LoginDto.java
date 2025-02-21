package com.hackathon.wagle.domain.user.dto.response;

import lombok.Builder;

@Builder
public record LoginDto(
        UserResponseDto user,
        String token
) {
    public static LoginDto of(UserResponseDto user, String token) {
        return LoginDto.builder()
                .user(user)
                .token(token)
                .build();
    }
}
