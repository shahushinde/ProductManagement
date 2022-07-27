package com.productManagement.dao;

import java.util.List;

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

	
	
}
