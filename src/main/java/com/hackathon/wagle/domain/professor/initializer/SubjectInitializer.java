package com.hackathon.wagle.domain.professor.initializer;

import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.entity.Subject;
import com.hackathon.wagle.domain.professor.repository.ProfessorRepository;
import com.hackathon.wagle.domain.professor.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SubjectInitializer {
    @Bean
    public CommandLineRunner initial(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        return args -> {
            List<String> subjects = List.of(
                    "자료구조", "알고리즘", "운영체제",
                    "데이터베이스", "네트워크", "컴퓨터구조",
                    "소프트웨어공학", "인공지능", "머신러닝",
                    "딥러닝", "웹프로그래밍", "모바일프로그래밍"
            );

            List<Professor> professors = professorRepository.findAll();

            for (Professor professor : professors) {
                for (int i = 0; i < 3; i++) {
                    String subjectName = subjects.get((int) (Math.random() * subjects.size()));
                    int randomNo = (int) (Math.random() * 90000000) + 10000000;  // 8자리 랜덤 번호 생성
                    Subject subject = new Subject();
                    subject.setProfessor(professor);
                    subject.setSubject(subjectName);
                    subject.setNo(randomNo);
                    subjectRepository.save(subject);
                }
            }
        };
    }
}
