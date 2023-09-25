package com.pizzaria_springboot.pizzaria.userTest;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pizzaria_springboot.pizzaria.user.UserModel;
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

        UserModel userModel = creatUserModel();

        Mockito.when(userRepository.findByUsername(userModel.getUsername()))
                .thenReturn(null);

        Mockito.when(userRepository.save(userModel))
                .thenReturn(userModel);

        Mockito.when(userRepository.existsById(1L))
                .thenReturn(true);
    }

    public UserModel creatUserModel() {
        UserModel userModel = new UserModel(
            "userName", 
            "password", 
            "Gabriel", 
            false, 
            null
        );
        return userModel;
    }

    @Test
    public void createUserValidationTest() {
        UserModel userModel = creatUserModel();
        userService.createUserValidation(userModel);
        verify(userRepository).findByUsername(userModel.getUsername());
        verify(userRepository).save(userModel);
    }

    @Test
    public void deleteUserTest() {
        Long id = 1L;
        userService.deleteUserValidation(id);
        verify(userRepository).existsById(id);
        verify(userRepository).deleteById(id);
    }
}
