package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pizzaria_springboot.pizzaria.user.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	// @MockBean
	// UserService userService;

	@Test
	public void getUserTest() throws Exception{
        mockMvc.perform(post("/usuarios"))
                .andExpect(status().isCreated());
	}
}
