package com.pizzaria_springboot.pizzaria.userTest;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pizzaria_springboot.pizzaria.user.UserModel;
import com.pizzaria_springboot.pizzaria.user.UserRecordDto;
import com.pizzaria_springboot.pizzaria.user.UserRepository;
import com.pizzaria_springboot.pizzaria.user.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private final UserService userService = new UserService();

    @MockBean
    UserRepository userRepository;

    @Before
    public void setUp() {
        UserRecordDto userRecordDto = new UserRecordDto(
            "userName", 
            "password", 
            "Gabriel", 
            false, 
            null
        );

        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);

        Mockito.when(userRepository.findByUsername(userRecordDto.username()))
                .thenReturn(java.util.Optional.of(userModel));

        Mockito.when(this.userRepository.findById(userModel.getId()))
                .thenReturn(Optional.of(userModel));
    }
    
    @Test
    public void isValidNewUserTest() {
        
        UserRecordDto userRecordDto = new UserRecordDto(
            "userName", 
            "password", 
            "Gabriel", 
            false, 
            null
        );
        Assert.assertTrue(this.userService.isValidNewUser(userRecordDto));     
    }
}
