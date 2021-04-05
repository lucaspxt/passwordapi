package com.lucaspxt.password.dto;

import java.io.Serializable;

import com.lucaspxt.password.domain.Password;
import com.lucaspxt.password.services.validation.PasswordVerify;

@PasswordVerify
public class PasswordDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String password;

	public PasswordDTO() {
		
	}
	
	public PasswordDTO(Password password) {
		this.password = password.getPassword();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
