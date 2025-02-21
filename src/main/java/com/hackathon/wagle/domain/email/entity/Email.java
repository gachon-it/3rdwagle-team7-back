package com.hackathon.wagle.domain.email.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder()
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="email")
@Entity
public class Email {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="studentId")
	private String studentId;
	
	@Column(name="studentName")
	private String studentName;
	
	@Column(name="studentPhoneNumber")
	private String phoneNumber;
	
	@Column(name="studentEmail")
	private String studentEmail;
	
	@Column(name="imagePath")
	private String imagePath;
	
	@Column(name="reason")
	private String reason;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	
}
