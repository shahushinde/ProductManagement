package com.productManagement.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
	

	
	@GetMapping(value="editProduct")
	public String showProduct(@RequestParam String productid,Model model) {
		
		Product product=service.editProduct(productid);
	
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	
	
	@PostMapping(value="editProd")
	public String  editProduct(@ModelAttribute Product product,Model model) {
		System.err.println(product);
		boolean isEdited=service.changeProduct(product);
		if(isEdited) {
			model.addAttribute("msg", "Product Edited Successfully");
			return "editProduct";
		}else {
			model.addAttribute("msg", "Product Not Edited Successfully");
			return "editProduct";
		}
	
	}
	
	
	@GetMapping(value="deleteProduct")
  public String deleteProduct(@RequestParam String productid,Model model) {
		boolean isdeleted=service.deleteProduct(productid);
		List<Product> product=service.productList();
		model.addAttribute("product", product);
	return "listOfProduct";
		
	}
	
	@PostMapping("uploadProduct")
	public String uploadProduct(@RequestParam CommonsMultipartFile file,HttpSession session,Model model) {
		
		String message=service.uploadProduct(file,session);
		model.addAttribute("msg", message);
		return "home";
		
	}
	
}
