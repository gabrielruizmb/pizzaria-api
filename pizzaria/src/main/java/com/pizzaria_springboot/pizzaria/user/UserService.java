package com.pizzaria_springboot.pizzaria.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import jakarta.validation.constraints.AssertFalse;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUserValidation(UserModel userModel) {

        if(userRepository.existsByUsername(userModel.getUsername()) == true) {
            throw new RuntimeException("Este nome de usuário já está em uso");
        }
        userRepository.save(userModel);
    }

    public boolean isNewUser(Long id, UserModel userModel) {
        
        UserModel dbUserModel = userRepository.findByUsername(
            userModel.getUsername()
        );

        if(dbUserModel != null) {
            Assert.isTrue(
                dbUserModel.getId() == id,
                "Este nome de usuário já está em uso."
            );
        }

        dbUserModel = userRepository.findById(id).get();
        if(dbUserModel == null) {
            userRepository.save(userModel);
            return true;
        }

        userModel.setId(dbUserModel.getId());
        userRepository.save(userModel);
        return false;
    }

    public void deleteUserValidation(Long id) {

        Assert.isTrue(
            this.userRepository.existsById(id), 
            "Usuário não encontrado."
        );
        this.userRepository.deleteById(id);
    }

    public UserRecordDto getUserValidation(Long id) {

        // Assert.isTrue(
        //     this.userRepository.existsById(id), 
        //     "Usuário não encontrado."
        // );
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
