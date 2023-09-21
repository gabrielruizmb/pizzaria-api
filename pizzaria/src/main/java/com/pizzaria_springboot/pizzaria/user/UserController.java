package com.pizzaria_springboot.pizzaria.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController { 
    
    @PostMapping
    public ResponseEntity<UserRecordDto> createUser(UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
