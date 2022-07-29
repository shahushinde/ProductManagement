package com.productManagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
		user.setStatus("InActive");
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
	public int uploadSheet(CommonsMultipartFile file, HttpSession session) {
	
		String filePath=session.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(filePath);
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		byte[]data=file.getBytes();
		int count=0;
		
		try {
			FileOutputStream fos=new FileOutputStream(new File(filePath + File.separator + fileName));
			fos.write(data);
			
			List<User> userList=readExcel(filePath + File.separator + fileName);
			count=dao.uploadUsers(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public List<User> readExcel(String path) {
		
		List<User> userList=new ArrayList<User>();
		try {
			FileInputStream fis=new FileInputStream(new File(path));
			Workbook workbook=new XSSFWorkbook(fis);
			Sheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rows=sheet.rowIterator();
			User user=null;
			
			while(rows.hasNext()) {
				 user=new User();
				Row row=rows.next();
				Iterator<Cell> cells=row.cellIterator();
			
				while(cells.hasNext()) {
					Cell cell=cells.next();
					int column=cell.getColumnIndex();
					
					switch (column) {
					case 0:{
						user.setUsername(cell.getStringCellValue());
						System.out.println();
						break;
					}
					case 1:{
						user.setPassword(cell.getStringCellValue());
						break;
					
					}
					case 2:{
						user.setGender(cell.getStringCellValue());
						break;
					
					}
					case 3:{
						user.setRole(cell.getStringCellValue());
						break;
					
					}
					case 4:{
						user.setQuestion(cell.getStringCellValue());
						break;
					
					}
					case 5:{
						user.setAnswer(cell.getStringCellValue());
						break;
					}
					}
				}
				userList.add(user);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		System.out.println(userList);
		
		return userList;
	}


	

	
}
