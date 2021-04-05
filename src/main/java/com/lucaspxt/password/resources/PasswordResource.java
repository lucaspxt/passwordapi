package com.lucaspxt.password.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucaspxt.password.domain.Password;
import com.lucaspxt.password.dto.PasswordDTO;
import com.lucaspxt.password.dto.PasswordResultDTO;
import com.lucaspxt.password.services.PasswordService;

@RestController
@RequestMapping(value="/password")
public class PasswordResource {
	
	@Autowired
	private PasswordService passwordService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> isValid(@Valid @RequestBody PasswordDTO passwordDto){
		Password password = passwordService.fromDTO(passwordDto);
		PasswordResultDTO result = new PasswordResultDTO(passwordService.isValidPassword(password));
		
		return ResponseEntity.ok(result);
	}
	
}
