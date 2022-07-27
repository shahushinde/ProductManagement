package com.productManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		session.setAttribute("user", listUser);
	 
		
	    mv.setViewName("listOfUsers");
	    return mv.addObject("user", listUser);
		
		
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

}
