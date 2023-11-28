package com.pizzaria_springboot.pizzaria.features.user;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDto(
	UUID id,

	@Email
	String email,

	@NotBlank @Size(
		min = 8,
		max = 20,
		message = "A senha deve conter entre 8 e 20 caracteres"
	) String password,

	@NotBlank @Size(
		min = 2, 
		max = 50, 
		message = "O nome deve conter entre 2 e 50 caracteres"
	) String name,
	boolean admin
	) {
	public UserModel convertToModel() {
		UserModel userModel = new UserModel(
			id, email, password, name, admin
		);
		return userModel;
	}
}
