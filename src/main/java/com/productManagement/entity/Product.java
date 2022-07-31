package com.productManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private String productid;
	private String productname;
	private String productexpirydate;
	private String productprice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productid, String productname, String productexpirydate, String productprice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productexpirydate = productexpirydate;
		this.productprice = productprice;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productexpirydate="
				+ productexpirydate + ", productprice=" + productprice + "]";
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductexpirydate() {
		return productexpirydate;
	}
	public void setProductexpirydate(String productexpirydate) {
		this.productexpirydate = productexpirydate;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	
	
	
	
	
}
