package com.lucaspxt.password.domain.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RegexPatternTest {

	@Test
	public void newRegexPatternTest() {
		RegexPattern regexPattern = new RegexPattern("^.*(?=.*[0-9]).*$", "Error message");
		
		Assertions.assertEquals("^.*(?=.*[0-9]).*$", regexPattern.getPattern());
		Assertions.assertEquals("Error message", regexPattern.getErrorMessage());
	}
	
	
	
}
