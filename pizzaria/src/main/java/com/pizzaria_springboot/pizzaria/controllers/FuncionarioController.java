package com.pizzaria_springboot.pizzaria.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria_springboot.pizzaria.dtos.FuncionarioRecordDto;
import com.pizzaria_springboot.pizzaria.models.FuncionarioModel;
import com.pizzaria_springboot.pizzaria.repositories.FuncionarioRepository;
import com.pizzaria_springboot.pizzaria.services.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "funcionarios")
public class FuncionarioController {

	FuncionarioRepository funcionarioRepository;
	FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioRepository funcionarioRepository, 
								 FuncionarioService funcionarioService) {
		this.funcionarioRepository = funcionarioRepository;
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/lista")
	public ResponseEntity<List<FuncionarioModel>> findAllFuncionarios() {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid 
			FuncionarioRecordDto funcionarioRecordDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(
				this.funcionarioService.funcionarioValidation(funcionarioRecordDto));
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				exception.getMessage());
		}
	}
}
