package com.lucaspxt.password.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PasswordResultDTOTest {

	public PasswordResultDTOTest() {
		super();
	}

	@Test
	public void newPasswordResultDTOTest() {
		PasswordResultDTO PasswordResultDto = new PasswordResultDTO(true);
		
		Assertions.assertEquals(true, PasswordResultDto.getIsValid());
	}
	
}
