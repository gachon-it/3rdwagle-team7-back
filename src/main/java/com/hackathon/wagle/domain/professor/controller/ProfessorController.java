package com.hackathon.wagle.domain.professor.controller;

import com.hackathon.wagle.domain.professor.dto.EmailDto;
import com.hackathon.wagle.domain.professor.dto.NameResponseDto;
import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    // 교수의 이름을 받아 이메일과 학과를 리턴
    @GetMapping("/professor/{name}")
    public NameResponseDto findByName(@PathVariable String name) {
        return professorService.findByName(name);
    }


}
