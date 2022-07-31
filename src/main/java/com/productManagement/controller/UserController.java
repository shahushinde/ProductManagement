package com.productManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.productManagement.entity.User;
import com.productManagement.service.LoginService;



@Controller
public class UserController {

	@Autowired
	private LoginService service;
	


	@PostMapping(value = "addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		ModelAndView mv = new ModelAndView();
		boolean isAdded;

		isAdded = service.addUser(user);

		if (isAdded) {
			mv.setViewName("addUser");
			mv.addObject("message", "User Added Successfully");
			
			
		} else {
			mv.setViewName("addUser");
			mv.addObject("message", "User Is Already Existed");
		}

		return mv;

	}
	
	@RequestMapping(value="listOfUsers")
	public ModelAndView displayuser(HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		List<User> listUser=service.getUserList();
		List<User> userList = new ArrayList();
		
	
	  String username=(String) session.getAttribute("loggedUser");
	  String status=(String) session.getAttribute("loggedUserStatus");
	
	  for (User user : listUser) {
		if(user.getUsername().equals(username)) {
			user.setStatus(status);
		}
		userList.add(user);
	}
	 
		session.setAttribute("user", userList);
	    mv.setViewName("listOfUsers");
	    return mv.addObject("user", userList);
		
		
	}
	
	@RequestMapping("profile")
	public String getUserByName(@RequestParam String username,Model model) {
	
		User user=service.getUserByName(username);
		model.addAttribute("user", user);
		return "profile";
		
	}
	
	@PostMapping(value="editprofile")
	public String editProfile(@ModelAttribute User user,Model model){
		
		boolean isEdited=service.editProfile(user);
		if(isEdited) {
			model.addAttribute("message", "User Updated Successfully");
			return "profile";
		}else {
			model.addAttribute("message", "User Not Updated Successfully");
			return "profile";
		}
	}
	
	@PostMapping(value="uploadsheet")
	public String uploadsheet(@RequestParam CommonsMultipartFile file,HttpSession session,Model model) {
	
		String message=service.uploadSheet(file,session);
		model.addAttribute("msg", message);
		return "home";
		
	}
	
	
	@RequestMapping("delete")
	public String deleteUser(@RequestParam String username,Model model) {
		
		boolean isDeleted=service.deleteUser(username);
		List<User> userList=service.getUserList();
		
		model.addAttribute("user", userList);
		return "listOfUsers";
	
		
	}
	
	
	@GetMapping(value="userlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
		
	}
	
	
	
	

	


}
