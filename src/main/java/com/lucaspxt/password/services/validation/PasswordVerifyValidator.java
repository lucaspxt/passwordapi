package com.lucaspxt.password.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucaspxt.password.domain.helper.RegexPattern;
import com.lucaspxt.password.dto.PasswordDTO;
import com.lucaspxt.password.resources.exceptions.FieldMessage;
import com.lucaspxt.password.services.PasswordService;
import com.lucaspxt.password.services.utils.Regex;

public class PasswordVerifyValidator implements ConstraintValidator<PasswordVerify, PasswordDTO> {
	
	@Autowired
	PasswordService passwordService;
	
	@Override
	public void initialize(PasswordVerify ann) {
		
	}
	
	@Override
	public boolean isValid(PasswordDTO passwordDto, ConstraintValidatorContext context) {
		Regex regex = new Regex();
		List<RegexPattern> regexListError;
		List<FieldMessage> fieldMessagelist = new ArrayList<>();
		regexListError = regex.getRegexErrorList(passwordService.getRegexList(), passwordDto.getPassword());
		
		for (RegexPattern e : regexListError) {
			if (!passwordDto.getPassword().matches(e.getPattern())) {
				fieldMessagelist.add(new FieldMessage("password", e.getErrorMessage()));
			}
		}
		
		for (FieldMessage e : fieldMessagelist) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMsg()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return fieldMessagelist.isEmpty();
	}
}
