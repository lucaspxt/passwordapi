package com.lucaspxt.password.domain.helper;

import java.io.Serializable;

public class RegexPattern implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String pattern;
	private String errorMessage;
	
	public RegexPattern(String pattern, String errorMessage) {
		super();
		this.pattern = pattern;
		this.errorMessage = errorMessage;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
