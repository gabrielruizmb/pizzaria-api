package com.pizzaria_springboot.pizzaria.features.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AuthorizationService implements UserDetailsService{

    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public void createUser(UserRegisterDTO newUser) {
        Assert.isTrue(
            userRepository.findByEmail(newUser.email()) == null,
             "Este e-mail já está em uso."
        );
        
        userRepository.save(newUser.convertToModel());
    }
}
