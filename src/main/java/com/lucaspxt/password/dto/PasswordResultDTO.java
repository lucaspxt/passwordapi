package com.lucaspxt.password.dto;

import java.io.Serializable;

public class PasswordResultDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Boolean isValid;
	
	public PasswordResultDTO(Boolean isValid) {
		super();
		this.isValid = isValid;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	
}
