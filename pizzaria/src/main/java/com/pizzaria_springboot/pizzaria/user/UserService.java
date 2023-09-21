package com.pizzaria_springboot.pizzaria.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isValidNewUser(UserRecordDto userRecordDto) {
        UserModel dbUser = this.userRepository.findByUsername(
            userRecordDto.username()
        );
        Assert.isNull(dbUser, "Este nome de usuário já está em uso.");
        return true;
    }

    public boolean isValidUserUpdate(Long id, UserRecordDto userRecordDto) {

        UserModel userModel = this.userRepository.findByUsername(userRecordDto.username());
        if (userModel != null) {
            Assert.isTrue(
                id == userModel.getId(), "Este nome de usuário já está em uso."
            );
        }
        return true;
    }
}
