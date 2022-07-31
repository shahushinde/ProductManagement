package com.productManagement.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productManagement.entity.ForgotPassword;
import com.productManagement.entity.User;
import com.productManagement.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	

	@RequestMapping(value = "/")
	public String loginPage() {
		return "login";
	}

	@PostMapping(value = "login")
	public ModelAndView login(@ModelAttribute User user,HttpSession session,Model model,String toEmail,String body,String subject) {
	
		
	
          User usr =service.getUserByName(user.getUsername());
		ModelAndView mv = new ModelAndView();
		boolean isPresent = service.loginValidate(user);
		if (isPresent) {
		
			usr.setStatus("Active");
			session.setAttribute("loggedUser", usr.getUsername());
			session.setAttribute("loggedUserStatus", usr.getStatus());
            session.setAttribute("userrole", usr.getRole());
			session.setAttribute("username", user.getUsername());
		
		   
			mv.setViewName("home");
	       
	        

		} else {
			mv.setViewName("login");
			mv.addObject("message", "Enter correct username and password");
			
		}

		return mv;

	}
	
	@PostMapping(value="forgotPasswordOfUser")
	public String forgotPasswordOfUser(@ModelAttribute ForgotPassword forgotPassword,Model model) {

		String message=service.forgotPassword(forgotPassword);
	
		model.addAttribute("message", message);
		return "forgotPassword";
		
	}
	
	
	
	
	
}
