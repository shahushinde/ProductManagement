package com.productManagement.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productManagement.dao.LoginnDaoImpl;
import com.productManagement.entity.Product;
import com.productManagement.entity.User;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginnDaoImpl dao;

	@Override
	public boolean loginValidate(User user) {
		
		return dao.loginValidate(user);
	}

	@Override
	public boolean addUser(User user) {
		
		return dao.addUser(user);
	}

	@Override
	public List<User> getUserList() {


		return dao.getUserList();
	}

	@Override
	public Product addproduct(Product product) {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductid(timeStamp);
		return dao.addProduct(product);
	}

	@Override
	public List<Product> productList() {
		
		return dao.productList();
	}

	@Override
	public User getUserByName(String username) {
	
		return dao.getUserByName(username);
	}

	@Override
	public boolean editProfile(User user) {
	
		return dao.editProfile(user);
	}


	

	
}
