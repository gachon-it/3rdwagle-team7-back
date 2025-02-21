package com.hackathon.wagle.domain.email.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmailDetail {
	
	private int studentId;
	private String studentName;
	private String imagePath;
	private String phoneNumber;
	private String email;
	private String head ;
	private String context;
}
