package com.pizzaria_springboot.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        
        Assert.isTrue( this.funcionarioRepository.findByNome(
                       funcionarioModel.getNome()) == null, 
                       "Este funcionário já está registrado.");

        return funcionarioRepository.save(funcionarioModel);
    }

    public Optional<FuncionarioModel> findFuncionarioModel(Long id) {
        Assert.isTrue(this.funcionarioRepository.existsById(id), 
                      "Este registro de funcionário não existe.");
        
        return funcionarioRepository.findById(id);
    }

    public List<FuncionarioModel> findAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void updateFuncionarioValidation(final Long id, 
            FuncionarioRecordDto funcionarioRecordDto) {
        
        Optional<FuncionarioModel> dbFuncionario = this.funcionarioRepository.findById(id);
        Assert.isTrue(dbFuncionario.isPresent(), 
                      "Este registro de funcionário não existe");
                      
        var funcionarioModel = dbFuncionario.get();
        BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);

        funcionarioRepository.save(funcionarioModel);  
    }

    public void deleteFuncionarioValidation(Long id) {
        Assert.isTrue(this.funcionarioRepository.existsById(id), 
                      "Este registro de funcionário não existe.");

        funcionarioRepository.deleteById(id);
    }
}
