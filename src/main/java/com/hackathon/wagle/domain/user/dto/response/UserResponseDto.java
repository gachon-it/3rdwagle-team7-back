package com.hackathon.wagle.domain.user.dto.response;

import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.entity.enums.Role;
import lombok.Builder;

@Builder
public record UserResponseDto(
         String username,
         String major,
         String studentNumber,
         String email,
         Role role
) {
    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .username(user.getUsername())
                .major(user.getMajor())
                .studentNumber(user.getStudentNumber())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
