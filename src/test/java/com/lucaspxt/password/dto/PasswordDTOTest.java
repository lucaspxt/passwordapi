package com.lucaspxt.password.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.password.model.Password;


@ExtendWith(SpringExtension.class)
public class PasswordDTOTest {

	@Test
	public void passwordDtoTest() {
		String pass = "AbTp9!fok";
		Password password = new Password(pass);
		PasswordDTO passwordDto = new PasswordDTO(password);
		
		Assertions.assertEquals(pass, passwordDto.getPassword());
	}
	
}
