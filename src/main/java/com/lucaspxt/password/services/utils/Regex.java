package com.lucaspxt.password.services.utils;

import java.util.ArrayList;
import java.util.List;

import com.lucaspxt.password.domain.helper.RegexPattern;

public class Regex {
	
	public List<RegexPattern> getRegexErrorList(List<RegexPattern> regexList, String value){
		List<RegexPattern> regexErrorList = new ArrayList<>();
		
		for (RegexPattern regex : regexList) {
			if (!value.matches(regex.getPattern())) {
				regexErrorList.add(regex);
			}
		}
		return regexErrorList;
	}
	
}
