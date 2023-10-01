package com.pizzaria_springboot.pizzaria.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch(Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
        @PathVariable("id") Long id, 
        @RequestBody @Validated UserRecordDto userRecordDto
    ) {
        try {
            userService.updateUserValidation(
                id, userRecordDto.convertToModel()
            );
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(exception.getMessage());
        }
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
