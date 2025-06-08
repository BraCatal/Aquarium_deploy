package com.example.Aquarium.mapper;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.model.Animal;

public class AnimalMapper {

    public static AnimalDTO toDTO(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setNome(animal.getNome());
        dto.setEspecie(animal.getEspecie());
        dto.setIdade(animal.getIdade());
        return dto;
    }
}

