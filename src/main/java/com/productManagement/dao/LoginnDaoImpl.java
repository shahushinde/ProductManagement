package com.productManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productManagement.entity.Product;
import com.productManagement.entity.User;

@Repository
public class LoginnDaoImpl implements LoginDao {

	@Autowired
	SessionFactory factory;

	@Override
	public boolean loginValidate(User user) {

		Session session = factory.openSession();
		User usr = session.get(User.class, user.getUsername());
		System.err.println("from dao layer=" + usr);
		boolean ispresent = false;
		if (usr != null) {
			if (usr.getUsername().equals(user.getUsername())) {
				ispresent = true;
			}
		}

		return ispresent;
	}

	@Override
	public boolean addUser(User user) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User usr = session.get(User.class, user.getUsername());
		boolean isAdded = false;
		if (usr == null) {
			session.save(user);
			transaction.commit();
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public List<User> getUserList() {
		Session session = factory.openSession();

		List userList = session.createCriteria(User.class).list();
		// System.out.println(userList);

		return userList;
	}

	@Override
	public Product addProduct(Product product) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Product prod=null;
		try {
			session.save(product);
			transaction.commit();
			prod=product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public List<Product> productList() {
		Session session=factory.openSession();
		List prodList=session.createCriteria(Product.class).list();
		return prodList;
	}

	@Override
	public User getUserByName(String username) {
		Session session=factory.openSession();
		User usr=null;
		try {
		usr=session.get(User.class, username);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;
	}

	public boolean editProfile(User user) {


		Session session=factory.openSession();
		Transaction tt=session.beginTransaction();
		boolean isEdited=false;
		try {
			session.saveOrUpdate(user);
			tt.commit();
			isEdited=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEdited;
	}

	



}