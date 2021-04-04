package com.lucaspxt.password.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.password.domain.Password;

@ExtendWith(SpringExtension.class)
public class PasswordTest {
	
	@Test
	public void newPasswordTest() {
		String pass = "AbTp9!fok";
		Password password = new Password(pass);
		
		Assertions.assertEquals(pass, password.getPassword());
	}
	
}
