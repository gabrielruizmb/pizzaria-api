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

        UserModel dbUser = this.userRepository.findByUsername(userRecordDto.username());
        if (dbUser != null) {
            Assert.isTrue(
                id == dbUser.getId(), "Este nome de usuário já está em uso."
            );
        }
        return true;
    }

    public boolean deleteUser(Long id) {
        Assert.isTrue(
            this.userRepository.existsById(id), 
            "Usuário não encontrado."
        );
        this.userRepository.deleteById(id);
        return true;
    }

    // public UserModel findUser(Long id) {
    //     Assert.isTrue(
    //         this.userRepository.existsById(id), 
    //         "Usuário não encontrado."
    //     );

    //     return this.userRepository.findById(id).orElse(null);
    // }
}
