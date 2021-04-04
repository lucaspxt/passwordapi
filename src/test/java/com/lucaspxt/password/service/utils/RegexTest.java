package com.lucaspxt.password.service.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.password.domain.helper.RegexPattern;
import com.lucaspxt.password.services.utils.Regex;

@ExtendWith(SpringExtension.class)
public class RegexTest {
	
	@Test
	public void regexIsValidTest() {
		Regex regex = new Regex();
		List<RegexPattern> list = new ArrayList<>();
		list.add(new RegexPattern("^(?=.*[0-9]).*$", "Erro."));
		Boolean isValid = regex.getRegexErrorList(list, "987654321").isEmpty();
		
		Assertions.assertEquals(true, isValid);
	}
	
	@Test
	public void regexIsNotValidTest() {
		Regex regex = new Regex();
		List<RegexPattern> list = new ArrayList<>();
		list.add(new RegexPattern("^(?=.*[0-9]).*$", "Erro."));
		Boolean isValid = regex.getRegexErrorList(list, "abcdefghi").isEmpty();
		
		Assertions.assertEquals(false, isValid);
	}
}
