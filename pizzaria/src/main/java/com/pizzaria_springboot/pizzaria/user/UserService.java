package com.pizzaria_springboot.pizzaria.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isValidNewUser(UserRecordDto userRecordDto) {
        this.userRepository.findByUsername(userRecordDto.username());
        return true;
    }
}
