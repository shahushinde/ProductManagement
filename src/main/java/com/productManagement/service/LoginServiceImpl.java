package com.productManagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.productManagement.dao.LoginnDaoImpl;
import com.productManagement.entity.ForgotPassword;
import com.productManagement.entity.Product;
import com.productManagement.entity.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginnDaoImpl dao;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public boolean loginValidate(User user) {
		String password = user.getPassword();
		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(password.getBytes());
        user.setPassword(encodedString);
		return dao.loginValidate(user);
	}

	@Override
	public boolean addUser(User user) {

		String password = user.getPassword();
		String encryptedpassword = null;
		Encoder encoder = Base64.getEncoder();
		encryptedpassword = encoder.encodeToString(password.getBytes());
		user.setStatus("InActive");
		user.setPassword(encryptedpassword);
//		//mailsending
//		String email=user.getEmail();
//		
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("shahushinde50@gmail.com");
//		message.setTo(email);
//		message.setText("wellcome in productManagement Application");
//		message.setSubject("welcome message");
//		
//		mailSender.send(message);
//		System.out.println("Mail send....");
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
		String password = user.getPassword();
		String encryptedpassword = null;
		Encoder encoder = Base64.getEncoder();
		encryptedpassword = encoder.encodeToString(password.getBytes());
		user.setPassword(encryptedpassword);
        user.setStatus("InActive");
		return dao.editProfile(user);
	}

	@Override
	public boolean deleteUser(String username) {

		return dao.deleteUser(username);
	}

	@Override
	public Product editProduct(String productid) {

		return dao.editProduct(productid);
	}

	@Override
	public boolean changeProduct(Product product) {

		return dao.changeProduct(product);
	}

	@Override
	public boolean deleteProduct(String productid) {

		return dao.deleteProduct(productid);
	}

	@Override
	public String uploadSheet(CommonsMultipartFile file, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/upload");
		String fileName = file.getOriginalFilename();
		byte[] data = file.getBytes();
		FileOutputStream fos;
		String message = null;

		try {
			fos = new FileOutputStream(new File(filePath + File.separator + fileName));
			fos.write(data);

			List<User> userList = readExcel(filePath + File.separator + fileName);
			message = dao.uploadUsers(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return message;
	}

	public List<User> readExcel(String path) {
		DataFormatter formatter = new DataFormatter();
		List<User> userList = new ArrayList<User>();
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			User user = null;

			while (rows.hasNext()) {
				user = new User();
				user.setStatus("InActive");
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();
					int column = cell.getColumnIndex();

					switch (column) {
					case 0: {
						user.setUsername(cell.getStringCellValue());

						break;
					}
					case 1: {
						user.setPassword(cell.getStringCellValue());
						break;

					}
					case 2: {
						user.setGender(cell.getStringCellValue());
						break;

					}
					case 3: {
						user.setRole(cell.getStringCellValue());
						break;

					}
					case 4: {
						user.setEmail(cell.getStringCellValue());
						//mailsending
//						String email=user.getEmail();
//						
//						SimpleMailMessage message=new SimpleMailMessage();
//						message.setFrom("shahushinde50@gmail.com");
//						message.setTo(email);
//						message.setText("wellcome in productManagement Application");
//						message.setSubject("welcome message");
//						
//						mailSender.send(message);
//						System.out.println("Mail send....");
						break;

					}
					case 5: {
						
						user.setQuestion(cell.getStringCellValue());
						
						break;

					}
					case 6: {
						String answer = formatter.formatCellValue(cell);
						user.setAnswer(answer);
						
						break;
					}
					}
				}

				String password = user.getPassword();
				String encryptedpassword = null;
				Encoder encoder = Base64.getEncoder();
				encryptedpassword = encoder.encodeToString(password.getBytes());
				user.setPassword(encryptedpassword);
				user.setStatus("InActive");
				user.setPassword(encryptedpassword);
				userList.add(user);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return userList;
	}

	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {

		return dao.forgotPassword(forgotPassword);
	}

	@Override
	public String uploadProduct(CommonsMultipartFile file, HttpSession session) {

		String filePath = session.getServletContext().getRealPath("/WEB-INF/upload");
		String fileName = file.getOriginalFilename();
		byte[] data = file.getBytes();
		FileOutputStream fos;
		String message = null;
		if (!file.isEmpty()) {
			try {
				fos = new FileOutputStream(new File(filePath + File.separator + fileName));
				fos.write(data);

				List<Product> productList = readProductExcelSheet(filePath + File.separator + fileName);
				message = dao.uploadProduct(productList);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		} else {
			message = "first select file and then upload";
		}

		return message;
	}

	public List<Product> readProductExcelSheet(String file) {
		List<Product> productList = new ArrayList<Product>();
		DataFormatter formatter = new DataFormatter();
		try {

			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			Product product = null;
			while (rows.hasNext()) {
				Thread.sleep(5);
				product = new Product();
				String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				product.setProductid(timeStamp);
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {

					Cell cell = cells.next();
					int column = cell.getColumnIndex();

					switch (column) {
					case 0: {
						product.setProductname(cell.getStringCellValue());

						break;
					}
					case 1: {

						String productPrice = formatter.formatCellValue(cell);
						product.setProductprice(productPrice);
						break;
					}
					case 2: {
						String productexpiry = formatter.formatCellValue(cell);
						product.setProductexpirydate(productexpiry);
						break;
					}

					}

				}

				productList.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

}
