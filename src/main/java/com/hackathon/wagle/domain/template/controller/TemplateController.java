package com.hackathon.wagle.domain.template.controller;

import com.hackathon.wagle.domain.template.dto.TemplateRequestDto;
import com.hackathon.wagle.domain.template.entity.Template;
import com.hackathon.wagle.domain.template.service.TemplateService;
import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.service.UserService;
import com.hackathon.wagle.global.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private UserService userService;

    // 특정 템플릿 조회 및 값 치환
    @GetMapping("/{name}")
    public ApiResponse<String> getFormattedTemplate(
            @PathVariable String name, // 카테고리 목록(성적이의제기, 강의증원신청 등)
            @RequestParam String professorName,
            @RequestParam String courseName,
            @RequestParam String studentNumber,
            @RequestParam(required = false) String date // 출석 관련일 때만 필요
             ) {

        User user = userService.findByStudentNumber(studentNumber);

        String formattedTemplate;

        if("결석관련".equals(name) || "과제지연".equals(name)) { //결석 관련일 때만 date 추가
            if (date == null) {
                return ApiResponse.response(HttpStatus.BAD_REQUEST, "출석 또는 과제 관련 템플릿에는 날짜가 필요합니다!", null);
            }
            formattedTemplate = templateService.getFormattedTemplate(
                    name, professorName, user.getMajor(), user.getStudentNumber(),
                    user.getUsername(), courseName, date);
        }
        else { //다른 템플릿일 경우 date 없이 처리
            formattedTemplate = templateService.getFormattedTemplate(
                    name, professorName, user.getMajor(), user.getStudentNumber(),
                    user.getUsername(), courseName);
        }

        return ApiResponse.response(HttpStatus.OK, "템플릿을 성공적으로 반환했습니다!", formattedTemplate);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Template>> createTemplate(@RequestBody TemplateRequestDto dto) {
        Template template = templateService.createTemplate(dto);
        return ResponseEntity.ok(ApiResponse.response(HttpStatus.OK, "템플릿을 성공적으로 반환했습니다!",template));

    }
}
