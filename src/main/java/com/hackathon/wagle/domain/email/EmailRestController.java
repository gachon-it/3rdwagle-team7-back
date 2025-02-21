package com.hackathon.wagle.domain.email;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.wagle.domain.email.dto.EmailDetail;
import com.hackathon.wagle.domain.email.service.EmailService;

import jakarta.servlet.http.HttpSession;

@RestController
public class EmailRestController {
	
	
	@Autowired
	private EmailService emailService;
	
//	@PostMapping("/send-email")
//	public String sendEmailWithPicture(@RequestParam("templateName") String templateName
//										, @RequestParam("file") MultipartFile file
//										, HttpSession session
//										, Model model) {
//		
//		// 세션에 저장된 사용자 정보 가져오기
//		int studentId = (Integer)session.getAttribute("studentId");
//		
//		
//		try {
//			String fileName = file.getOriginalFilename();
//			String uploadDir = "uploads/";
//			String imagePath = uploadDir + fileName;
//			
//			File dir = new File(uploadDir);
//			if (!dir.exists()) dir.mkdirs();
//			
//			File saveFile = new File(imagePath);
//			file.transferTo(saveFile);
//			
//			EmailDetail emailDetail = emailService.returnChangePhotoTemplate(studentId, templateName, imagePath);
//			
//			emailService.sendEmailWithAttachmentToFixedRecipient(emailDetail,  "photochange12@gmail.com");
//			
//			return "이메일 전송 성공";
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "이메일 전송 실패: " + e.getMessage();
//		}
//	
//		
//	}
	
	
	
	
	
}
