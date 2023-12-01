package com.pizzaria_springboot.pizzaria.features.flavour;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class FlavourService {
    
    @Autowired
    FlavourRepository flavourRepository;

    public void post(FlavourDTO flavourDTO) {

        if(flavourRepository.existsByName(flavourDTO.name()) == true) {
            throw new RuntimeException("Este sabor já existe.");
        }
        flavourRepository.save(flavourDTO.convertToModel());
    }

    public void put(Long id, FlavourModel flavourModel) {

        // FlavourModel dbFlavour = flavourRepository.findByName(flavourModel.getName());
        
        // if(dbFlavour != null) {
        //     Assert.isTrue(
        //         dbFlavour.getId() == id,
        //         "Este sabor já existe."
        //     );
        // }

        // dbFlavour = flavourRepository.findById(id).get();

        // Assert.notNull(dbFlavour, "Este sabor não existe.");

        // flavourModel.setId(dbFlavour.getId());
        flavourRepository.save(flavourModel);
    }

    public void deleteById(Long id) {

        Assert.isTrue(
            flavourRepository.existsById(id), 
            "Este sabor não existe."
        );

        flavourRepository.deleteById(id);
    }

    public FlavourDTO getById(Long id) {

        Assert.isTrue(
            flavourRepository.existsById(id), 
            "Este sabor não existe."
        );

        return flavourRepository.findById(id).get().convertToDTO();
    }

    public List<FlavourDTO> getAll() {
        
        List<FlavourModel> dbFlavours = flavourRepository.findAll();
        List<FlavourDTO> flavourDTOs = new ArrayList<>();

        for(FlavourModel dbFlavour : dbFlavours) {
            flavourDTOs.add(dbFlavour.convertToDTO());
        }

        return flavourDTOs;
    }
}
