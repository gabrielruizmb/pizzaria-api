package com.pizzaria_springboot.pizzaria.oldClasses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria_springboot.pizzaria.adress.AdressModel;
import com.pizzaria_springboot.pizzaria.adress.AdressRecordDto;
import com.pizzaria_springboot.pizzaria.adress.AdressRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("enderecos")
public class AdressController {
	final AdressRepository adressRepository;
	public AdressController(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	}
	@PostMapping
	public ResponseEntity<Object> createAdress(@RequestBody @Valid AdressRecordDto adressRecordDto) {
		var adressModel = new AdressModel();
		BeanUtils.copyProperties(adressRecordDto, adressModel);
		try {
			this.adressRepository.save(adressModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(
				"Endereço registrado com sucesso!");
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
