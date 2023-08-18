package com.pizzaria_springboot.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionarioModel {
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private String nome;
	
	public FuncionarioModel() {

	}
	
	public FuncionarioModel(String nome) {
		this.nome = nome;
	}

}
