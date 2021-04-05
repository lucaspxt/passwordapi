package com.lucaspxt.password.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lucaspxt.password.domain.Password;
import com.lucaspxt.password.domain.helper.RegexPattern;
import com.lucaspxt.password.dto.PasswordDTO;
import com.lucaspxt.password.services.utils.Regex;

@Service
public class PasswordService {

	public PasswordService() {
		super();
	}
	
	public Boolean isValidPassword(Password password) {
		Regex regex = new Regex();
		List<RegexPattern> regexList = getRegexList();
		
		return regex.getRegexErrorList(regexList, password.getPassword()).isEmpty();
	}
	
	public List<RegexPattern> getRegexList() {
		List<RegexPattern> list = new ArrayList<>();
		list.add(new RegexPattern("^.*(?=.{9,}).*$", "A senha deve possuir no mínimo 9 digitos."));
		list.add(new RegexPattern("^.*(?=.*[0-9]).*$", "A senha deve possuir ao menos um número."));
		list.add(new RegexPattern("^.*(?=.*[a-z]).*$", "A senha deve possuir ao menos uma letra minúscula."));
		list.add(new RegexPattern("^.*(?=.*[A-Z]).*$", "A senha deve possuir ao menos uma letra maiúscula."));
		list.add(new RegexPattern("^(?:([\w])(?!.*\1))*$", "A senha não deve possuir caracteres repetidos."));
		list.add(new RegexPattern("^.*(?=.*[!@#$%-^&+*()]).*$", "A senha deve possuir ao menos um caractere especial."));
		
		return list;
	}
	
	public Password fromDTO(PasswordDTO passwordDTO) {
		return new Password(passwordDTO.getPassword());
	}
	
}
