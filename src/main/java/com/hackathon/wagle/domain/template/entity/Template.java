package com.hackathon.wagle.domain.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "templates")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 자동 증가 ID

    @Column(nullable = false, unique = true)
    private String name;  // 템플릿 이름 (ex: "성적정정")

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  // 템플릿 내용 (String.format() 사용)

    public static Template of(String name, String content) {
        return Template.builder()
                .name(name)
                .content(content)
                .build();
    }
}
