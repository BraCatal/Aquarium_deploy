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

        if (animal.getAquario() != null) {
            dto.setAquarioId(animal.getAquario().getId());
        }

        return dto;
    }

    public static Animal toEntity(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setId(dto.getId());
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setIdade(dto.getIdade());

        // O campo aquario será setado no Service, se necessário

        return animal;
    }
}



