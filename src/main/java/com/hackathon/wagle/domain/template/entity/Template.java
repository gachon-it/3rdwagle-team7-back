package com.hackathon.wagle.domain.template.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 자동 증가 ID

    @Column(nullable = false, unique = true)
    private String name;  // 템플릿 이름 (ex: "성적정정")

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  // 템플릿 내용 (String.format() 사용)

	public static Template of(String name2, String content2) {
		// TODO Auto-generated method stub
		return null;
	}
}
