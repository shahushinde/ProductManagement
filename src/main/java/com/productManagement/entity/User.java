package com.productManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private String username;
	private String password;
	private String email;
	private String role;
	private String gender;
	private String question;
	private String answer;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String role, String gender, String question,
			String answer) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.gender = gender;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", gender=" + gender + ", question=" + question + ", answer=" + answer + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}
