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
public class UserServiceTests {

    @Autowired
    private final UserService userService = new UserService();

    @MockBean
    UserRepository userRepository;

    @Before
    public void setUp() {

        Long id = 1L;
        UserModel userModel = createUserModel();

        Mockito.when(userRepository.findByUsername(userModel.getUsername()))
                .thenReturn(null);

        Mockito.when(userRepository.save(userModel))
                .thenReturn(userModel);

        Mockito.when(userRepository.existsById(id))
                .thenReturn(true);

        Mockito.when(userRepository.findById(id))
                .thenReturn(java.util.Optional.of(userModel));
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

    @Test
    public void createUserValidationTest() {
        UserModel userModel = createUserModel();
        userService.createUserValidation(userModel);
        verify(userRepository).findByUsername(userModel.getUsername());
        verify(userRepository).save(userModel);
    }

    @Test
    public void updateUserValidation() {
        Long id = 1L;
        UserModel userModel = createUserModel();
        userService.updateUserValidation(id, userModel);
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

    @Test
    public void getUserValidationTest() {
        Long id = 1L;
        userService.getUserValidation(id);
        verify(userRepository).existsById(id);
        verify(userRepository).findById(id);
    }

    @Test
    public void getUsersTest() {
        userService.getUsers();
        verify(userRepository).findAll();
    }
}
