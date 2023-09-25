package com.pizzaria_springboot.pizzaria.user;

import org.springframework.beans.BeanUtils;
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

    public boolean isValidUserUpdate(Long id, UserRecordDto userRecordDto) {

        UserModel dbUser = this.userRepository.findByUsername(userRecordDto.username());
        if (dbUser != null) {
            Assert.isTrue(
                id == dbUser.getId(), "Este nome de usuário já está em uso."
            );
        }
        return true;
    }

    public void deleteUserValidation(Long id) {
        Assert.isTrue(
            this.userRepository.existsById(id), 
            "Usuário não encontrado."
        );
        this.userRepository.deleteById(id);
    }

    // public UserModel findUser(Long id) {
    //     Assert.isTrue(
    //         this.userRepository.existsById(id), 
    //         "Usuário não encontrado."
    //     );

    //     return this.userRepository.findById(id).orElse(null);
    // }
}
