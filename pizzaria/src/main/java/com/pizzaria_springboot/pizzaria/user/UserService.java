package com.pizzaria_springboot.pizzaria.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUserValidation(UserModel userModel) {
        
        Assert.isNull(
            this.userRepository.findByUsername(userModel.getUsername()),
            "Este nome de usuário já está em uso."
        );
            
        this.userRepository.save(userModel);
    }

    public void updateUserValidation(Long id, UserModel userModel) {

        UserModel dbUserModel = 
        this.userRepository.findByUsername(userModel.getUsername());

        if (dbUserModel != null) {
            Assert.isTrue(
                dbUserModel.getId() == id,
                "Este nome de usuário já está em uso."
            );
        }
        this.userRepository.save(userModel);
    }

    public void deleteUserValidation(Long id) {

        Assert.isTrue(
            this.userRepository.existsById(id), 
            "Usuário não encontrado."
        );
        this.userRepository.deleteById(id);
    }

    public UserRecordDto getUserValidation(Long id) {

        Assert.isTrue(
            this.userRepository.existsById(id), 
            "Usuário não encontrado."
        );
        UserModel dbUserModel = this.userRepository.findById(id).get();

        return dbUserModel.convertToDto();
    }

    public List<UserRecordDto> getUsers() {

        List<UserModel> dbUsers = this.userRepository.findAll();
        List<UserRecordDto> userRecordDtos = new ArrayList<>();
        for (UserModel dbUser : dbUsers) {
            userRecordDtos.add(dbUser.convertToDto());
        }
        return userRecordDtos;
    }
}
