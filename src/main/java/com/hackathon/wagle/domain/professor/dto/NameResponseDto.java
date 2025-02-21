package com.hackathon.wagle.domain.professor.dto;

import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class NameResponseDto {

    public NameResponseDto(Professor professor, List<Subject> subjects) {
        this.email = professor.getEmail();
        this.department = professor.getDepartment();
        this.subject = subjects.stream()
                .map(Subject::getSubject)
                .collect(Collectors.toList());
        this.no = subjects.stream()
                .map(Subject::getNo)
                .collect(Collectors.toList());
    }

    private String email;
    private String department;
    private List<String> subject;  // 과목
    private List<Integer> no; // 학수번호
}
