package com.productManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="addUserpage")
	public String addUserPage() {
		return "addUser";
		
	}
	
	
	@RequestMapping(value="addproductpage")
	public String addProductPage() {
		return "addProduct";
		
	}

	@RequestMapping(value="homepage")
	public String homePage() {
		return "home";
		
	}
	
	

	@RequestMapping(value="UploadUser")
	public String UploadUser() {
		return "excelsheetUpload";
		
	}
	
	@RequestMapping(value="productupload")
	public String UploadProduct() {
		return "productupload";
		
	}
	
	@RequestMapping(value="forgotpassword")
	public String forgotPassword() {
		return "forgotPassword";
		
	}

	
}
