package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaria_springboot.pizzaria.user.UserRecordDto;
import com.pizzaria_springboot.pizzaria.user.UserService;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    UserService userService;

    @Before
    public void userService() {
        userService = new UserService();
    }
    
    @Test
    public void createUserValidationTest() {
        final UserRecordDto userRecordDto = new UserRecordDto(
        "userName", 
        "password", 
        "Gabriel", 
        false, 
        null
        );
        Assert.assertTrue(userService.isValidNewUser(userRecordDto));
    }
}
