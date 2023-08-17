package com.pizzaria_springboot.pizzaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria_springboot.pizzaria.models.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long>{
  
}
