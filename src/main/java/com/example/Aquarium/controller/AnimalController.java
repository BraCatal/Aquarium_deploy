package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalDTO> listar() {
        return animalService.listar();
    }
    
    @GetMapping("/{id}")
    public AnimalDTO buscarPorId(@PathVariable Long id) {
        return animalService.buscarPorId(id);
    }

    @PostMapping
    public AnimalDTO criar(@RequestBody AnimalDTO animalDTO) {
        return animalService.criar(animalDTO);
    }

    @PutMapping("/{id}")
    public AnimalDTO atualizar(@PathVariable Long id, @RequestBody AnimalDTO animalDTO) {
        return animalService.atualizar(id, animalDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalService.deletar(id);
    }
}





