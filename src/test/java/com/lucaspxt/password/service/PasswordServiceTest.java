package com.lucaspxt.password.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.password.domain.Password;
import com.lucaspxt.password.services.PasswordService;

@ExtendWith(SpringExtension.class)
public class PasswordServiceTest {
	
	@TestConfiguration
	static class CategoriaServiceTestConfiguration{
		
		@Bean
		public PasswordService passwordService() {
			return new PasswordService();
		}
		
	}
	
	@Autowired
	PasswordService passwordService;
	
	@Test
	public void passwordServiceTestIsValid() {
		List<String> pass = new ArrayList<>();
		pass.add("AbTp9!fok");
		pass.add("9bTp-!f0k");
		pass.add("Bgc3p!@#$%-^&*()+9fok");
		pass.add("12Ab%#@ced");
		Integer total = pass.size();
		Integer totalValid = 0;
		
		for (String p : pass) {
			if (passwordService.isValidPassword(new Password(p))) {
				totalValid += 1;
			}
		}
		
		Assertions.assertEquals(total, totalValid);
	}
	
	@Test
	public void passwordServiceTestIsNotValid() {
		List<String> pass = new ArrayList<>();
		pass.add("");
		pass.add("ab");
		pass.add("AAAbbbCc");
		pass.add("AbTp9!foA");
		pass.add("AbTp9-foA-");
		pass.add("AbTp9 fok");
		Integer total = pass.size();
		Integer totalNotValid = 0;
		
		for (String p : pass) {
			if (!passwordService.isValidPassword(new Password(p))) {
				totalNotValid += 1;
			}
		}
		
		Assertions.assertEquals(total, totalNotValid);
	}
}
