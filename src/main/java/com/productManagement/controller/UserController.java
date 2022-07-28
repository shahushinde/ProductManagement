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
	
	
	@RequestMapping("delete")
	public String deleteUser(@RequestParam String username,Model model) {
		System.out.println(username);
		boolean isDeleted=service.deleteUser(username);
		List<User> userList=service.getUserList();
		
		model.addAttribute("user", userList);
		return "listOfUsers";
	
		
	}
	
	
	
//	 @RequestMapping("addUser11")
//	    public void sendMail(@ModelAttribute User user) {
//	    	  // Recipient's email ID needs to be mentioned.
//	        String to = "shahushinde488@gmail.com";
//
//	        // Sender's email ID needs to be mentioned
//	        String from = "shahushinde50@gmail.com";
//
//	        // Assuming you are sending email from through gmails smtp
//	        String host = "smtp.gmail.com";
//
//	        // Get system properties
//	        Properties properties = System.getProperties();
//
//	        // Setup mail server
//	        properties.put("mail.smtp.host", host);
//	        properties.put("mail.smtp.port", "465");
//	        properties.put("mail.smtp.ssl.enable", "true");
//	        properties.put("mail.smtp.auth", "true");
//
//	        // Get the Session object.// and pass username and password
//	        javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
//
//	            protected PasswordAuthentication getPasswordAuthentication() {
//
//	                return new PasswordAuthentication("shahushinde50@mail.com", "cilrubebkvdmdiuf");
//
//	            }
//
//	        });
//	        System.out.println("after authentication");
//
//	        // Used to debug SMTP issues
//	        session.setDebug(true);
//
//	        try {
//	            // Create a default MimeMessage object.
//	            MimeMessag message = new MimeMessage(session);
//
//	            // Set From: header field of the header.
//	            message.setFrom(new InternetAddress(from));
//
//	            // Set To: header field of the header.
//	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//	            // Set Subject: header field
//	            message.setSubject("This is the Subject Line!");
//
//	            // Now set the actual message
//	            message.setText("This is actual message");
//
//	            System.out.println("sending...");
//	            // Send message
//	            Transport.send(message);
//	            System.out.println("Sent message successfully....");
//	        } catch (MessagingException mex) {
//	            mex.printStackTrace();
//	        }
//
//	    }

}
