package com.hackathon.wagle.domain.template.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.wagle.domain.template.dto.TemplateRequestDto;
import com.hackathon.wagle.domain.template.entity.Template;
import com.hackathon.wagle.domain.template.repository.TemplateRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Transactional
    public Template createTemplate(TemplateRequestDto requestDto) {
        System.out.println(requestDto.name());
        System.out.println(requestDto.content());
        Template template = Template.of(requestDto.name(), requestDto.content());
        return templateRepository.save(template);
    }

    // 특정 템플릿 가져와서 값을 치환
    public String getFormattedTemplate(String name, String... args) {
        Optional<Template> templateOpt = templateRepository.findByName(name);

        if (templateOpt.isPresent()) {
            String content = templateOpt.get().getContent();
            return String.format(content, (Object[]) args);  // 문자열 치환
        } else {
            throw new RuntimeException("템플릿을 찾을 수 없습니다: " + name);
        }
    }
}