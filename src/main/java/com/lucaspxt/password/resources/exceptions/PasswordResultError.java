package com.lucaspxt.password.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.lucaspxt.password.dto.PasswordResultDTO;

public class PasswordResultError extends PasswordResultDTO{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public PasswordResultError(Boolean isValid) {
		super(isValid);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String msg) {
		errors.add(new FieldMessage(fieldName, msg));
	}
	
}
