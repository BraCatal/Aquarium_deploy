package com.example.Aquarium.service;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.mapper.AnimalMapper;
import com.example.Aquarium.model.Animal;
import com.example.Aquarium.model.Aquario;
import com.example.Aquarium.repository.AnimalRepository;
import com.example.Aquarium.repository.AquarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AquarioRepository aquarioRepository;

    public AnimalService(AnimalRepository animalRepository, AquarioRepository aquarioRepository) {
        this.animalRepository = animalRepository;
        this.aquarioRepository = aquarioRepository;
    }

    public List<AnimalDTO> listar() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AnimalDTO criar(AnimalDTO dto) {
        Animal animal = AnimalMapper.toEntity(dto);

        if (dto.getAquarioId() != null) {
            Aquario aquario = aquarioRepository.findById(dto.getAquarioId())
                    .orElseThrow(() -> new RuntimeException("Aquário não encontrado"));
            animal.setAquario(aquario);
        }

        Animal salvo = animalRepository.save(animal);
        return AnimalMapper.toDTO(salvo);
    }

    public AnimalDTO atualizar(Long id, AnimalDTO dto) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existente.setNome(dto.getNome());
        existente.setEspecie(dto.getEspecie());
        existente.setIdade(dto.getIdade());

        if (dto.getAquarioId() != null) {
            Aquario aquario = aquarioRepository.findById(dto.getAquarioId())
                    .orElseThrow(() -> new RuntimeException("Aquário não encontrado"));
            existente.setAquario(aquario);
        }

        Animal atualizado = animalRepository.save(existente);
        return AnimalMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }
}


