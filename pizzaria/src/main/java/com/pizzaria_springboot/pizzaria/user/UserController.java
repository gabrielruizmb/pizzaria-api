package com.pizzaria_springboot.pizzaria.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController { 

    final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(
        @RequestBody @Validated UserRecordDto userRecordDto
    ) {
        try {
            userService.createUserValidation(userRecordDto.convertToModel());
            return ResponseEntity.created(null).body(null);
        } catch(Exception exception) {
            return ResponseEntity.badRequest()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
        @PathVariable("id") Long id, 
        @RequestBody @Validated UserRecordDto userRecordDto
    ) {
        try {
            userService.isNewUser(
                id, userRecordDto.convertToModel()
            );
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        try {
            userService.deleteUserValidation(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecordDto> getUserById(
        @PathVariable("id") Long id
    ) {
        try {
            return ResponseEntity.ok().body(userService.getUserValidation(id));              
        } catch(Exception exception){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UserRecordDto>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    //public ResponseEntity<UserRecordDto> 
}
//     @GetMapping
//     public ResponseEntity<List<UserRecordDto>> getUsers() {
//         return ResponseEntity.status(HttpStatus.OK)
//                 .body(userService.getUsers());
//     }

//     // @PostMapping
//     // public ResponseEntity<UserRecordDto> createUser(UserRecordDto userRecordDto) {
//     //     return ResponseEntity.status(HttpStatus.OK).body(null);
//     // }
// }
