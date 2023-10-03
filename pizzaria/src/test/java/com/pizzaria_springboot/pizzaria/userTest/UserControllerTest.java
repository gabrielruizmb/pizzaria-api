package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
			1L,
			"testUsername", 
            "testPassword", 
            "testName", 
            false, 
            null
		);
		return userRecordDto;
	}

	public UserRecordDto createNewUserRecordDto() {
		UserRecordDto userRecordDto = new UserRecordDto(
			1L,
			"newTestUsername", 
			"newTestPassword", 
			"newTestName", 
			false, 
			null
		);
		return userRecordDto;
	}

	@Test
	public void createUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createUserRecordDto())))
				.andExpect(status().isCreated());
	}

	@Test
	public void updateUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.put("/usuarios/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createNewUserRecordDto())))
				.andExpect(status().isNoContent());
	}

	@Test
	public void deleteUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/usuarios/{id}", 1))
				.andExpect(status().isNoContent());
	}

	@Test
	public void getUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/usuarios/{id}", 1))
				.andExpect(status().isOk());
	}

	@Test
	public void getUsersTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/usuarios/lista"))
				.andExpect(status().isOk());
	}
}
