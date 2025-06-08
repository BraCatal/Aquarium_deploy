package com.example.Aquarium.service;

import com.example.Aquarium.model.Animal;
import com.example.Aquarium.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizar(Long id, Animal animalAtualizado) {
        Animal animal = buscarPorId(id);
        animal.setNome(animalAtualizado.getNome());
        animal.setEspecie(animalAtualizado.getEspecie());
        animal.setIdade(animalAtualizado.getIdade());
        animal.setAquario(animalAtualizado.getAquario());
        return animalRepository.save(animal);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }
}
