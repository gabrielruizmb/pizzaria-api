// package com.pizzaria_springboot.pizzaria;

// import org.junit.Assert;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;

// import com.pizzaria_springboot.pizzaria.user.UserController;
// import com.pizzaria_springboot.pizzaria.user.UserRecordDto;

// @SpringBootTest
// class UserControllerTests {

// 	@Test
// 	public void createUserTest() {
// 		final UserRecordDto userRecordDto = new UserRecordDto(
// 			"userName", 
// 			"password", 
// 			"Gabriel", 
// 			false, 
// 			null
// 		);
		
// 		final UserController userController = new UserController(null, null);


// 		Assert.assertTrue(
// 			userController.createUser(userRecordDto).getHeaders().,
// 			HttpStatus.CREATED
// 		);
// 	}
// }
