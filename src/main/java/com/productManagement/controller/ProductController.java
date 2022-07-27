package com.productManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productManagement.entity.Product;
import com.productManagement.service.LoginService;

@Controller
public class ProductController {
	@Autowired
	private LoginService service;
	
	@PostMapping(value="addproduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		ModelAndView mv=new ModelAndView();
		//System.err.println(product);
		Product prod=service.addproduct(product);
		
		
		if(prod!=null) {
		
			mv.setViewName("addProduct");
			mv.addObject("message", "Product Added Successfully");
		
		}else {
			mv.setViewName("addProduct");
			mv.addObject("message", "Product Not Added");
		}
	return mv;


		
	}
	
	
	@RequestMapping(value="getProductList")
	public ModelAndView displayProductList() {
		
		List<Product> prodList=service.productList();
		ModelAndView mv =new ModelAndView();
		mv.setViewName("listOfProduct");
		mv.addObject("product", prodList);
		return mv;
		
	}

}
