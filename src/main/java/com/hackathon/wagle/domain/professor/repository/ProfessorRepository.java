package com.hackathon.wagle.domain.professor.repository;

import com.hackathon.wagle.domain.professor.entity.Professor;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor findByName(String name);
    @NonNull
    List<Professor> findAll();

}
