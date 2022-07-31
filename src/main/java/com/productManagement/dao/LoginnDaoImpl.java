package com.productManagement.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.productManagement.entity.ForgotPassword;
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

		boolean ispresent = false;
		try {
			if (usr != null) {

				if (user.getPassword().equals(usr.getPassword())) {
					ispresent = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ispresent;
	}

	@Override
	public boolean addUser(User user) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User usr = session.get(User.class, user.getUsername());
		boolean isAdded = false;
		try {
			if (usr == null) {
				session.save(user);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isAdded;
	}

	@Override
	public List<User> getUserList() {
		Session session = factory.openSession();

		List userList = session.createCriteria(User.class).list();
		// System.out.println(userList);
		session.close();
		return userList;
	}

	@Override
	public Product addProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product prod = null;
		try {
			session.save(product);
			transaction.commit();
			prod = product;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return prod;
	}

	@Override
	public List<Product> productList() {
		Session session = factory.openSession();
		List<Product> prodList = session.createCriteria(Product.class).list();
		session.close();
		return prodList;
	}

	@Override
	public User getUserByName(String username) {
		Session session = factory.openSession();
		User usr = null;
		try {
			usr = session.get(User.class, username);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		String dbpassword=usr.getPassword();
		  Decoder decoder = Base64.getDecoder();
	        byte[] bytes = decoder.decode(dbpassword);
	        String password=new String(bytes);
	        usr.setPassword(password);
		return usr;
	}

	public boolean editProfile(User user) {

		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		boolean isEdited = false;
		try {
			session.update(user);
			tt.commit();
			isEdited = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return isEdited;
	}

	@Override
	public boolean deleteUser(String username) {
		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		User usr = session.get(User.class, username);
		boolean isDeleted = false;
		try {
			session.delete(usr);
			tt.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;
	}

	public Product editProduct(String productid) {
		Session session = factory.openSession();
		Product product = session.get(Product.class, productid);
		session.close();
		return product;
	}

	@Override
	public boolean changeProduct(Product product) {
		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		boolean isEdited = false;
		try {
			session.update(product);
			tt.commit();
			isEdited = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isEdited;
	}

	@Override
	public boolean deleteProduct(String productid) {
		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		Product product = session.get(Product.class, productid);
		boolean isDeleted = false;
		try {
			if (product != null) {
				session.delete(product);
				tt.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;
	}

	@Override
	public String uploadUsers(List<User> userList) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		int excluded = 0;
		try {
			for (User user : userList) {
				session = factory.openSession();
				transaction = session.beginTransaction();
				User usr = session.get(User.class, user.getUsername());
				if (usr != null) {
					if (!usr.getUsername().equals(user.getUsername())) {
						session.save(user);
						transaction.commit();
						count = count + 1;
					} else {

						excluded = excluded + 1;

					}
				} else {
					session.save(user);
					transaction.commit();
					count = count + 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count + " user uploaded," + excluded + " excluded";
	}

	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {
		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		String message = null;

		String username = forgotPassword.getUsername();
		User user = session.get(User.class, username);
	
		try {
			if (user != null) {

				if (forgotPassword.getQuestion().equals(user.getQuestion())
						&& forgotPassword.getAnswer().equals(user.getAnswer())) {

					if (forgotPassword.getNewpassword().equals(forgotPassword.getConfirmpassword())) {
						user.setPassword(forgotPassword.getNewpassword());
						String password=user.getPassword();
					    String encryptedpassword = null;  
					    Encoder encoder = Base64.getEncoder();
				        encryptedpassword = encoder.encodeToString(password.getBytes());
				        user.setPassword(encryptedpassword);
						session.update(user);
						tt.commit();
						message = "Password reset Successfully";

					} else {

						message = "New password and confirm password should be same";
					}

				} else {
					message = "Please select correct security question and answer";
				}
			} else {
				message = "User not existed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return message;
	}

	@Override
	public String uploadProduct(List<Product> productList) {
		Session session = null;
		Transaction transaction = null;
		String message = null;
		int count = 0;

		try {
			if (productList != null) {
				for (Product product : productList) {
					session = factory.openSession();
					transaction = session.beginTransaction();

					session.save(product);
					transaction.commit();
					count = count + 1;

				}
				message = count + " Product uploaded";
			}else {
				message="first select file";
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return message;
	}

}
