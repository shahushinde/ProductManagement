package com.productManagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.productManagement.entity.Product;
import com.productManagement.entity.User;

public interface LoginService {
	
	public boolean loginValidate(User user);

	public boolean addUser(User user);
	
	public List<User> getUserList();

	public Product addproduct(Product product);
	
	
	public List<Product> productList();

	public User getUserByName(String username);

	public boolean editProfile(User user);

	public boolean deleteUser(String username);

	public Product editProduct(String productid);

	public boolean changeProduct(Product product);

	public boolean deleteProduct(String productid);

	public int uploadSheet(CommonsMultipartFile file, HttpSession session);





	
}
