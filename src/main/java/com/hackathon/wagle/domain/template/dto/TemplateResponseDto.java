package com.hackathon.wagle.domain.template.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateResponseDto {
    private Long id;
    private String formattedContent;


    public TemplateResponseDto(Long id, String formattedContent) {
        this.id = id;
        this.formattedContent = formattedContent;
    }
}