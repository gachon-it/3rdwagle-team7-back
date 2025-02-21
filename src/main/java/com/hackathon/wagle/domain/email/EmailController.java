package com.hackathon.wagle.domain.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/change-picture-form")
	public String changePicture() {
		return "sendPicture.html";
	}
	
	@PostMapping("/send")
	public String sendTestEmail(@RequestParam("file") MultipartFile file) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true, "UTF-8");
			
			helper.setTo("photochange12@gmail.com");
			helper.setSubject("테스트 이메일");
			helper.setText("Spring Boot에서 보낸 이메일입니다.", true);
			
			// 파일 첨부 추가
			if(file != null && !file.isEmpty()) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			
			mailSender.send(message);
			return "redirect:https://www.naver.com";
		} catch (Exception e) {
			e.printStackTrace();
			return "이메일 전송 실패: " + e.getMessage();
		}
	}
	
	
	
}
