package com.hackathon.wagle.test;

import lombok.Builder;

@Builder
public record TestDto(
        Long id,
        String name,
        String studentNumber,
        String email
) {
    public static TestDto of(Long id, String name, String studentNumber, String email) {
        return TestDto.builder()
                .id(id)
                .name(name)
                .studentNumber(studentNumber)
                .email(email)
                .build();
    }
}
