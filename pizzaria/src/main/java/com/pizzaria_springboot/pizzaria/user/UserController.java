package com.pizzaria_springboot.pizzaria.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController { 

    // final UserService userService;
    
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    @PostMapping
    public ResponseEntity<UserRecordDto> createUser(
        @RequestBody @Validated UserRecordDto userRecordDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
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
