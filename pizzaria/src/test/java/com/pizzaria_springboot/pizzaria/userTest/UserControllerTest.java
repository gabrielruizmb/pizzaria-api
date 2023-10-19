package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaria_springboot.pizzaria.features.user.UserController;
import com.pizzaria_springboot.pizzaria.features.user.UserModel;
import com.pizzaria_springboot.pizzaria.features.user.UserRecordDto;
import com.pizzaria_springboot.pizzaria.features.user.UserRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	public UserRecordDto createValidUser() {
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

	public UserRecordDto createInvalidUser() {
		UserRecordDto userRecordDto = new UserRecordDto(
			1L,
			"", 
			"newTestPassword", 
			"newTestName", 
			false, 
			null
		);
		return userRecordDto;
	}

    public UserModel createUserModel() {
        UserModel userModel = new UserModel(
            "userName", 
            "password", 
            "Gabriel", 
            false, 
            null
        );
        return userModel;
    }

    public void setUp() {
        UserModel userModel = createUserModel();
        Mockito.when(userRepository.existsByUsername(userModel.getUsername()))
                .thenReturn(false);
        Mockito.when(userRepository.save(userModel))
                .thenReturn(userModel);
		Mockito.when(userRepository.existsById(1L))
				.thenReturn(true);
    }

	@Test
	public void createValidUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createValidUser())))
				.andExpect(status().isCreated());
	}

	@Test
	public void createInvalidUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createInvalidUser())))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void updateUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.put("/usuarios/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createValidUser())))
				.andExpect(status().isOk());
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
