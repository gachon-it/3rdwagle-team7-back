package com.hackathon.wagle.domain.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.mail.internet.MimeMessage;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/send")
	public String sendTestEmail() {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true, "UTF-8");
			
			helper.setTo("photochange12@gmail.com");
			helper.setSubject("테스트 이메일");
			helper.setText("Spring Boot에서 보낸 이메일입니다.", true);
			
			mailSender.send(message);
			return "이메일 전송 성공";
		} catch (Exception e) {
			e.printStackTrace();
			return "이메일 전송 실패: " + e.getMessage();
		}
	}
	
	
	
}
