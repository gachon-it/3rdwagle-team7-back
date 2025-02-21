package com.hackathon.wagle.domain.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.wagle.domain.email.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>{
	
}
