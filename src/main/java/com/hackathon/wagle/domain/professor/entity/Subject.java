package com.hackathon.wagle.domain.professor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 교수 이름
    @ManyToOne
    private Professor professor;

    // 과목
    private String subject;

    // 학수번호 8자리
    private int no;
}
