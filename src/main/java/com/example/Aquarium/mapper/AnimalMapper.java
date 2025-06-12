package com.example.Aquarium.mapper;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.model.Animal;
import com.example.Aquarium.model.Aquario;

public class AnimalMapper {

    public static AnimalDTO toDTO(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setNome(animal.getNome());
        dto.setEspecie(animal.getEspecie());
        dto.setIdade(animal.getIdade());
        return dto;
    }

    public static Animal toEntity(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setId(dto.getId());
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setIdade(dto.getIdade());

        // Obs: aqui não associamos aquário diretamente, isso pode ser feito no Service
        return animal;
    }
}


