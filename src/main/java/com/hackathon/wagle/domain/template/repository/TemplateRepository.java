package com.hackathon.wagle.domain.template.repository;

import com.hackathon.wagle.domain.template.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    Optional<Template> findByName(String name);  // 카테고리 이름으로 템플릿 조회
}