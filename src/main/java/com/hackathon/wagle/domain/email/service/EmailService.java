package com.hackathon.wagle.domain.email.service;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hackathon.wagle.domain.email.dto.EmailDetail;
import com.hackathon.wagle.domain.template.entity.Template;
import com.hackathon.wagle.domain.template.repository.TemplateRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
		
	@Autowired
	private TemplateRepository templateRepository;
	
	
	// 프로필 사진 변경
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
	
	
	
	
	// 성적 이의 제기
//	public void sendEmailWithScoreObject(String name) throws MessagingException {
//		
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//		
//		Optional<Template> optionalTemplate = templateRepository.findByName(name);
//		Template template = optionalTemplate.orElse(null);
//		
//		helper.setTo("chris0540@naver.com");
//		
//		helper.setSubject(template.getName());
//		
//		helper.setText(template.getContent());
//		
//		mailSender.send(message);
//		
//	}
//	
	
	
}
