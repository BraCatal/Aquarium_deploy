package com.example.Aquarium.service;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.mapper.AnimalMapper;
import com.example.Aquarium.model.Animal;
import com.example.Aquarium.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalDTO> listar() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AnimalDTO criar(AnimalDTO dto) {
        Animal animal = AnimalMapper.toEntity(dto);
        Animal salvo = animalRepository.save(animal);
        return AnimalMapper.toDTO(salvo);
    }

    public AnimalDTO atualizar(Long id, AnimalDTO dto) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEspecie(dto.getEspecie());
        // se tiver idade ou aquário no DTO, adicione também aqui

        Animal atualizado = animalRepository.save(existente);
        return AnimalMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }
}

