package com.hackathon.wagle.domain.email.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hackathon.wagle.domain.email.dto.EmailDetail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private TemplateRepository templateRepository;
//	
	
	
//	public EmailDetail returnChangePhotoTemplate(int studentId, String templateName, String imagePath) {
//		
//		Student student = studentRepository.findByStudentId(studentId);
//		
//		String templateBody = templateRepository.findbyTemplateName(templateName);
//		
//		EmailDetail emailDetail = EmailDetail.builder()
//												.studentId(studentId)
//												.studentName(student.Name)
//												.phoneNumber(student.phoneNumber)
//												.email(student.email)
//												.head(templateName)
//												.context(templateBody)
//												.imagePath(imagePath)
//											.build();
//		
//		return emailDetail;
//		
//	}
	
	
	public void sendEmailWithAttachmentToFixedRecipient(EmailDetail emailDetail, String fixedRecipient) throws MessagingException{
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(fixedRecipient);
		helper.setSubject("사진 첨부 이메일 : " + emailDetail.getHead());
		helper.setText(emailDetail.getContext(), true);
		
		FileSystemResource file = new FileSystemResource(new File(emailDetail.getImagePath()));
		helper.addAttachment(file.getFilename(), file);
		
		mailSender.send(message);
	}
	
	
	
}
