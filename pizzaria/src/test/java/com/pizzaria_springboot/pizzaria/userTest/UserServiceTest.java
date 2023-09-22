package com.pizzaria_springboot.pizzaria.userTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        UserRecordDto userRecordDto = createUserRecordDto();

        Mockito.when(userRepository.findByUsername(userRecordDto.username()))
                .thenReturn(null);

        Mockito.when(userRepository.existsById(1L))
                .thenReturn(true);

        Mockito.when(this.userRepository.findById(1L))
                .thenReturn(java.util.Optional.of(createUserModel()));
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

    public UserModel createUserModel() {
        UserRecordDto userRecordDto = createUserRecordDto();
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return userModel;
    }

    @Test
    public void isValidNewUserTest() {
        Assert.assertTrue(this.userService.isValidNewUser(createUserRecordDto()));     
    }

    @Test
    public void isValidUserUpdateTest() {
        Long id = 1L;

        Assert.assertTrue(this.userService.isValidUserUpdate(
            id, createUserRecordDto())
        );   
    }

    @Test
    public void deleteUserTest() {
        Long id = 1L;

        Assert.assertTrue(this.userService.deleteUser(id));
    }

    // @Test
    // public void findUserTest() {
    //     Long id = 1L;

    //     Assert.assertEquals(this.userService.findUser(id), createUserModel());
    // }
}
