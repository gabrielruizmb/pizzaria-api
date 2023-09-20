package com.pizzaria_springboot.pizzaria.oldClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.pizzaria_springboot.pizzaria.user.UserModel;
import com.pizzaria_springboot.pizzaria.user.UserRecordDto;
import com.pizzaria_springboot.pizzaria.user.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUserValidation(UserRecordDto 
                                     userRecordDto) {

        var userModel = new UserModel();
		BeanUtils.copyProperties(userRecordDto, userModel);   
        
        Assert.isTrue( this.userRepository.findByName(
                       userModel.getName()) == null, 
                       "Este funcionário já está registrado.");

        userRepository.save(userModel);
    }

    public Optional<UserModel> findUserModel(Long id) {
        Assert.isTrue(this.userRepository.existsById(id), 
                      "Este registro de funcionário não existe.");
        
        return userRepository.findById(id);
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public void updateFuncionarioValidation(final Long id, 
            UserRecordDto funcionarioRecordDto) {
        
        Optional<UserModel> dbFuncionario = this.userRepository.findById(id);
        Assert.isTrue(dbFuncionario.isPresent(), 
                      "Este registro de funcionário não existe");
                      
        var funcionarioModel = dbFuncionario.get();
        BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);

        userRepository.save(funcionarioModel);  
    }

    public void deleteFuncionarioValidation(Long id) {
        Assert.isTrue(this.userRepository.existsById(id), 
                      "Este registro de funcionário não existe.");

        userRepository.deleteById(id);
    }
}
