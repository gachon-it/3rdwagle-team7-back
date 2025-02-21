package com.hackathon.wagle.domain.email;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.wagle.domain.user.service.UserService;

import jakarta.mail.internet.MimeMessage;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/change-picture-form")
	public String changePicture() {
		return "sendPicture.html";
	}
	
	@PostMapping("/send")
	public String sendTestEmail(@RequestParam("studentNubmer") String studentNumber
								, @RequestParam("file") MultipartFile file) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true, "UTF-8");
			
			
			// 이메일 전송 주소
			helper.setTo("photochange12@gmail.com");
			
			// 제목
			helper.setSubject("증명사진 변경 관련 요청 드립니다.");
			
			// 내용
			
			
			
			User user = userService.findByStudentNumber(studentNumber);
			
			
			String userName = "vlrhsgkek"; //user.getName();
			String studentNumber = "12341234"; //user.getStudentNumber();
			String major = "whfflqek"; //user.getStudentMajor();
			
			String emailBody = "" + userName + "\n" 
	                 + studentNumber + "\n" 
	                 + major + "\n"
	                 + "Spring Boot에서 보낸 이메일입니다.";

			helper.setText(emailBody, true);
			
			// 파일 첨부 추가
			if(file != null && !file.isEmpty()) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			
			mailSender.send(message);
			// 성공시 리디렉션 페이지
			return "redirect:https://www.naver.com";
		} catch (Exception e) {
			e.printStackTrace();
			return "이메일 전송 실패: " + e.getMessage();
		}
	}
	
	
	
}
