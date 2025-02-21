package com.hackathon.wagle.domain.professor.repository;

import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.entity.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    List<Subject> findByProfessor(Professor professor);
}
