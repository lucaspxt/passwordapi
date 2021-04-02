package com.lucaspxt.password.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lucaspxt.password.model.Password;

public class PasswordDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="A senha deve possui ao menos 1 dígito")
	@Size(min=5, max=10, message="O tamanho da senha deve ser superior a 9 digitos.")
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
