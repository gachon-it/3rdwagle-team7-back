package com.hackathon.wagle.domain.template.controller;

import com.hackathon.wagle.domain.template.dto.TemplateRequestDto;
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
            @PathVariable String name, // 카테고리 목록(성적정정, 수강빌넣 등)
            @RequestParam String professorName,
            @RequestParam String courseName,
            @RequestParam String studentNumber
             ) {

        User user = userService.findByStudentNumber(studentNumber);

        String formattedTemplate = templateService.getFormattedTemplate(
                name, professorName, user.getMajor(), user.getStudentNumber(),
                user.getUsername(), courseName);
        return ApiResponse.response(HttpStatus.OK, "템플릿을 성공적으로 반환했습니다!", formattedTemplate);
    }

    @PostMapping
    public ApiResponse<Void> createTemplate(TemplateRequestDto dto) {
        return ApiResponse.response(HttpStatus.OK, "템플릿을 성공적으로 반환했습니다!");
    }
}
