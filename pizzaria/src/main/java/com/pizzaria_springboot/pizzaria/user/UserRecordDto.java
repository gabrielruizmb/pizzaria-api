package com.pizzaria_springboot.pizzaria.user;

import com.pizzaria_springboot.pizzaria.adress.AdressModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDto(
	@NotBlank @Size(
		min = 5,
		max = 20,
		message = "O nome de usuário deve conter entre 5 e 20 caracteres"
	) String username,

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
	boolean admin,
	AdressModel adress
) {
	public UserModel convertToModel() {
		UserModel userModel = new UserModel(
			username, password, name, admin, adress
		);
		return userModel;
	}
}
