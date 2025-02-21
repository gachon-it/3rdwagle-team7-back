package com.hackathon.wagle.domain.professor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    public Professor(String name, String email, String department, int location) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 교수님 성함
    private String name;

    // 이메일
    private String email;

    // 학과 정보
    private String department;

    // 교수님 위치 : AI 공학관 {location} 호.
    private int location;

}
