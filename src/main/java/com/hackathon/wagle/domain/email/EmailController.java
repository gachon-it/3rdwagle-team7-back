package com.hackathon.wagle.domain.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.wagle.domain.template.service.TemplateService;
import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.service.UserService;

import jakarta.mail.internet.MimeMessage;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TemplateService templateService;
	
	@GetMapping("/change-picture-form")
	public String changePicture() {
		return "sendPicture.html";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/send")
	public String sendTestEmail(@RequestParam("studentNumber") String studentNumber
								, @RequestParam("file") MultipartFile file) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true, "UTF-8");
			
			// 이메일 전송 주소
			helper.setTo("photochange12@gmail.com");
			
			// 제목
			helper.setSubject("증명사진 변경 관련 요청 드립니다.");
			
			User user = userService.findByStudentNumber(studentNumber);
			
			// 내용
			String userName = user.getUsername();
			String major = user.getMajor();
			
			String emailBody = studentNumber + major + userName + "입니다 \n" 
	                  + "첨부한 사진으로 프로필 사진 변경 부탁드립니다";

			helper.setText(emailBody, true);
			
			// 파일 첨부 추가
			if(file != null && !file.isEmpty()) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			
			mailSender.send(message);
			// 성공시 리디렉션 페이지
			return "redirect:https://www.gachon.ac.kr/kor/index.do";  // 성공 페이지로 리다이렉트
		} catch (Exception e) {
			e.printStackTrace();
			return "이메일 전송 실패: " + e.getMessage();
		}
	}
	
	
	// 유형 선택해서 이메일 보내기
	@PostMapping("/send-email")
	public String sendEmail(@RequestParam("name") String name
	                        , @RequestParam("professorName") String professorName
	                        , @RequestParam("courseName") String courseName
	                        , @RequestParam("studentNumber") String studentNumber) {
	    
	    User user = userService.findByStudentNumber(studentNumber);
	    String userName = user.getUsername();
	    
	    
	    String template = templateService.getFormattedTemplate(name, professorName, studentNumber, userName, courseName);

	    // 이메일 제목 설정
	    String subject = professorName + " 교수님에게 보내는 " + name + "관련 문의 드립니다";
	    
	    try {
	    	
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

	        
	        // 나중에 교수님 메일 주소로 교체하기
	        helper.setTo("dmsdmsqhghk919@gmail.com");  

	        helper.setSubject(subject);

	        helper.setText(template, true);  

	        // 이메일 전송
	        mailSender.send(message);

	        return "redirect:https://www.gachon.ac.kr/kor/index.do";  // 성공 페이지로 리다이렉트
	    } catch (Exception e) {
	    	e.printStackTrace();
			return "이메일 전송 실패: " + e.getMessage();
	    }
	}

	
}
