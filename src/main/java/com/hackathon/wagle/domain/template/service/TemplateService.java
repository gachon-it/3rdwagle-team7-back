package com.hackathon.wagle.domain.template.service;

import com.hackathon.wagle.domain.template.dto.TemplateRequestDto;
import com.hackathon.wagle.domain.template.entity.Template;
import com.hackathon.wagle.domain.template.repository.TemplateRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    // DTO를 활용한 초기 데이터 삽입
    @PostConstruct
    public void initTemplates() {
        log.info("Initializing templates");

        templateRepository.deleteAll();

        if (templateRepository.count() == 0) {

            List<TemplateRequestDto> defaultTemplates = List.of(
                    new TemplateRequestDto("성적정정", "안녕하세요 %s 교수님."+
                            "저는 %s에 재학중인 %s %s입니다. 저는 이번 학기에 들었던 %s 강의에서 성적과 관련하여 문의드리고자 합니다." +
                            "제가 확인한 바에 따르면 제 성적이 잘못 반영되었다고 판단합니다. 이에 성적 정정을 요청드리고자 하며, 성적 확인 후 수정이 가능할지 확인해주시면" +
                            " 감사하겠습니다. 필요하신 추가 자료나 확인 사항이 있으시면 언제든지 말씀해 주세요." +
                            "교수님의 바쁘신 일정에도 불구하고 메일 확인에 감사드립니다." +
                            "감사합니다."),

                    new TemplateRequestDto("강의빌넣", "안녕하세요 %s 교수님. 저는 %s에 재학중인 %s %s입니다. 이번 학기에 %s을 수강하고자 신청했으나, " +
                            "수강 인원이 이미 마감되어 수강 신청을 할 수 없었습니다. 해당 강의가 제 전공에 매우 중요하고, 해당 강의가 제공하는 내용이 제 학업 및 진로에 큰 도움이 될 것으로 생각하여 수강을 희망합니다." +
                            "따라서 교수님께 수강 인원 증원을 요청드리고자 합니다. 혹시 추가 수강생을 받을 수 있는 여유가 있다면 수강할 수 있는 기회를 주시면 정말 감사하겠습니다." +
                            "교수님께서 바쁘신 중에 시간을 내어 주셔서 감사합니다." +
                            "부디 긍정적인 답변을 기다리겠습니다." +
                            "감사합니다.")
            );

            for (TemplateRequestDto dto : defaultTemplates) {
                createTemplate(dto); // DTO 를 이용해 저장
            }
        }
        log.info("Initialized templates");
    }


    // DTO 를 이용한 템플릿 저장
    public void createTemplate(TemplateRequestDto requestDto) {
        Template template = new Template();
        template.setName(requestDto.name());
        template.setContent(requestDto.content());
        templateRepository.save(template);
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