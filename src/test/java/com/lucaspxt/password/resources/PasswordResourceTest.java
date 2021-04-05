package com.lucaspxt.password.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucaspxt.password.domain.Password;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordResourceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void PasswordTestPostIsValid() throws Exception {
		Password password = new Password("AbTp9!fok");
		
		mockMvc.perform(post("/password")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(password)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isValid").value(true));
	}
	
	@Test
	public void PasswordTestPostIsValidWithoutListError() throws Exception {
		Password password = new Password("AbTp9!fok");
		
		mockMvc.perform(post("/validpassword")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(password)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isValid").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.errors").doesNotExist());
	}
	
	@Test
	public void PasswordTestPostIsNotValid() throws Exception {
		Password password = new Password("AbTp9 fok");
		
		mockMvc.perform(post("/validpassword")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(password)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isValid").value(false));
	}
	
	@Test
	public void PasswordTestPostIsNotValidWithListError() throws Exception {
		Password password = new Password("AbTp9 fok");
		
		mockMvc.perform(post("/validpassword")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(password)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isValid").value(false))
				.andExpect(MockMvcResultMatchers.jsonPath("$.errors").exists());
	}
	
}
