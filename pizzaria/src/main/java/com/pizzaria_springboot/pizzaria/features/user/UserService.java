package com.pizzaria_springboot.pizzaria.features.user;

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

        if(userRepository.existsByUsername(userModel.getUsername()) == true) {
            throw new RuntimeException("Este nome de usuário já está em uso.");
        }
        userRepository.save(userModel);
    }

    public UserRecordDto updateUserValidation(Long id, UserModel userModel) {

        UserModel dbUserModel = userRepository.findByUsername(userModel.getUsername());
        
        if(dbUserModel != null) {
            Assert.isTrue(
                dbUserModel.getId() == id,
                "Este nome de usuário já está em uso."
            );
        }

        dbUserModel = userRepository.findById(id).get();

        Assert.notNull(dbUserModel, "Este usuário não existe.");

        userModel.setId(dbUserModel.getId());
        userRepository.save(userModel);

        return userModel.convertToDto();
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
