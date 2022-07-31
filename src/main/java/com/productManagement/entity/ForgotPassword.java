package com.productManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ForgotPassword {
	
	@Id
	private String username;
	private String question;
	private String answer;
	private String newpassword;
	private String confirmpassword;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(String username, String question, String answer, String newpassword, String confirmpassword) {
		super();
		this.username = username;
		this.question = question;
		this.answer = answer;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "ForgotPassword [username=" + username + ", question=" + question + ", answer=" + answer
				+ ", newpassword=" + newpassword + ", confirmpassword=" + confirmpassword + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	
	
}
