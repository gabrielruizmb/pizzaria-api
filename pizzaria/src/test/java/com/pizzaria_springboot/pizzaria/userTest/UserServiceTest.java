package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
        UserRecordDto userRecordDto = createUserRecordDto();

        Mockito.when(userRepository.findByUsername(userRecordDto.username()))
                .thenReturn(null);

        // Mockito.when(this.userRepository.findById(userModel.getId()))
        //         .thenReturn(Optional.of(userModel));
    }
    
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
    public void isValidNewUserTest() {
        Assert.assertTrue(this.userService.isValidNewUser(createUserRecordDto()));     
    }

    @Test
    public void isValidUserUpdate() {

        Long id = 1L;

        Assert.assertTrue(this.userService.isValidUserUpdate(
            id, createUserRecordDto())
        );   
    }
}
