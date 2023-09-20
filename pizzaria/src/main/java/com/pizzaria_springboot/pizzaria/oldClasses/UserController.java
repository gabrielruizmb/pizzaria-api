package com.pizzaria_springboot.pizzaria.oldClasses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria_springboot.pizzaria.user.UserModel;
import com.pizzaria_springboot.pizzaria.user.UserRecordDto;
import com.pizzaria_springboot.pizzaria.user.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "usuarios")
public class UserController {

	UserRepository userRepository;
	UserService userService;

	public UserController(UserRepository userRepository, 
								 UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findUser(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
				this.userService.findUserModel(id));
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				exception.getMessage());
		}
	}

	@GetMapping("/lista")
	public ResponseEntity<List<UserModel>> findAllFuncionarios() {
		return ResponseEntity.status(HttpStatus.OK).body(
			this.userService.findAllUsers());
	}

	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody @Valid 
			UserRecordDto userRecordDto) {
		try {
			this.userService.createUserValidation(userRecordDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				exception.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateFuncionario(@PathVariable("id") final Long id,
			@RequestBody @Valid UserRecordDto funcionarioRecordDto) {
			
		try {
			this.userService.updateFuncionarioValidation(id, funcionarioRecordDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(
				"Funcionário editado com sucesso!");
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable("id") final Long id) {
		try {
			this.userService.deleteFuncionarioValidation(id);
			return ResponseEntity.status(HttpStatus.OK).body(
				"Funcionário deletado com sucesso!");	
		} catch (Exception exception){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				exception.getMessage());
		}
	}
}
