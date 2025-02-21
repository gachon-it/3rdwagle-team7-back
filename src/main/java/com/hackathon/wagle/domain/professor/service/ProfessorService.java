package com.hackathon.wagle.domain.professor.service;

import com.hackathon.wagle.domain.professor.dto.EmailDto;
import com.hackathon.wagle.domain.professor.dto.NameResponseDto;
import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.entity.Subject;
import com.hackathon.wagle.domain.professor.repository.ProfessorRepository;
import com.hackathon.wagle.domain.professor.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    // 교수의 진행중인 과목을 subject 테이블에서 가져옴. name 기반
    public NameResponseDto findByName(String name) {
        Professor professor = professorRepository.findByName(name);
        List<Subject> subject = subjectRepository.findByProfessor(professor);

        NameResponseDto nameResponseDto = new NameResponseDto(professor,subject);

        return nameResponseDto;
    }

}
