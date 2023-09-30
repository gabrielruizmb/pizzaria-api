package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaria_springboot.pizzaria.user.UserRecordDto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	public UserRecordDto createUserRecordDto() {
		UserRecordDto userRecordDto = new UserRecordDto(
			"userName", 
            "password", 
            "Gabriel", 
            false, 
            null
		);
		return userRecordDto;
	}

	@Test
	public void getUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createUserRecordDto())))
				.andExpect(status().isCreated());
	}
}
