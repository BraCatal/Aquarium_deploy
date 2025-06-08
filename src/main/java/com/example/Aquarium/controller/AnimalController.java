package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.mapper.AnimalMapper;
import com.example.Aquarium.model.Animal;
import com.example.Aquarium.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalDTO> listarTodos() {
        return animalService.listarTodos()
                .stream()
                .map(AnimalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AnimalDTO buscarPorId(@PathVariable Long id) {
        return AnimalMapper.toDTO(animalService.buscarPorId(id));
    }

    @PostMapping
    public AnimalDTO criar(@RequestBody Animal animal) {
        Animal novoAnimal = animalService.salvar(animal);
        return AnimalMapper.toDTO(novoAnimal);
    }

    @PutMapping("/{id}")
    public AnimalDTO atualizar(@PathVariable Long id, @RequestBody Animal animal) {
        Animal atualizado = animalService.atualizar(id, animal);
        return AnimalMapper.toDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalService.deletar(id);
    }
}


