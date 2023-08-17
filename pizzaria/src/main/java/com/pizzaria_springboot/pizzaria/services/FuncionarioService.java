package com.pizzaria_springboot.pizzaria.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.pizzaria_springboot.pizzaria.dtos.FuncionarioRecordDto;
import com.pizzaria_springboot.pizzaria.models.FuncionarioModel;
import com.pizzaria_springboot.pizzaria.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioModel funcionarioValidation(FuncionarioRecordDto 
                                                  funcionarioRecordDto) {
        var funcionarioModel = new FuncionarioModel();
		BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);      
        return funcionarioRepository.save(funcionarioModel);
    }
}
