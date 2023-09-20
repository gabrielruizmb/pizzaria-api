package com.pizzaria_springboot.pizzaria.user;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    // public final UserRepository userRepository;
    
    // public UserService(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    public boolean isValidNewUser(UserRecordDto userRecordDto) {

        // isUniqueUsername(userRecordDto.username());
        // var userModel = new UserModel();
        // BeanUtils.copyProperties(userRecordDto, userModel);
        //userRepository.save(userModel);
        return true;
    }

    // public boolean isUniqueUsername(String username) {
    //     // Assert.isTrue(userRepository.findByName(username) == null, 
    //     //               "Este nome de usuário já está em uso.");
    //     return true;
    // }
}
