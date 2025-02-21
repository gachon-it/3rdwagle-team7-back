package com.hackathon.wagle.domain.email.dto;

import lombok.Builder;

@Builder
public record EmailResponseDto(
        String title,
        String content
) {
    public static EmailResponseDto of(String title, String content) {
        return new EmailResponseDto(title, content);
    }
}
