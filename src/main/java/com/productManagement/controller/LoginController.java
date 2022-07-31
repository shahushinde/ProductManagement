package com.productManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
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
	public ModelAndView login(@ModelAttribute User user,HttpSession session) {
	
		
		user.setStatus("Active");
		session.setAttribute("loggedUser", user.getUsername());
		session.setAttribute("loggedUserStatus", user.getStatus());
          User usr =service.getUserByName(user.getUsername());
		ModelAndView mv = new ModelAndView();
		boolean isPresent = service.loginValidate(user);
		if (isPresent) {
		
		
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
