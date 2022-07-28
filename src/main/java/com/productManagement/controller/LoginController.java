package com.productManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping(value = "login")
	public ModelAndView login(@ModelAttribute User user,HttpSession session) {
		
		session.setAttribute("user", user);
		
          User usr =service.getUserByName(user.getUsername());
          System.out.println("session===>"+usr);
		// System.err.println(user);
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

}
