package com.productManagement.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.productManagement.entity.ForgotPassword;
import com.productManagement.entity.Product;
import com.productManagement.entity.User;

public interface LoginDao {
	
	
	public boolean loginValidate(User user);
	
	
	public boolean addUser(User user);
	
	
	public List<User> getUserList();
	
	
	public Product addProduct(Product product);
	
	
	public List<Product> productList();
	
	public User getUserByName(String username);
	
	public boolean editProfile(User user);

	public boolean deleteUser(String username);
	
	public Product editProduct(String productid);
	
	public boolean changeProduct(Product product);
	
	public boolean deleteProduct(String productid);
	
	public String uploadUsers(List<User> userList);
	
	public String forgotPassword(ForgotPassword forgotPassword);
	
	public String uploadProduct(List<Product> productList);
	
}
