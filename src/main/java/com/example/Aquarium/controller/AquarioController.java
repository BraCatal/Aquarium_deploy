package com.example.Aquarium.controller;

import com.example.Aquarium.model.Aquario;
import com.example.Aquarium.repository.AquarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aquario")
public class AquarioController {

    @Autowired
    private AquarioRepository aquarioRepository;

    // GET all
    @GetMapping
    public List<Aquario> listarTodos() {
        return aquarioRepository.findAll();
    }

    // POST
    @PostMapping
    public Aquario criar(@RequestBody Aquario aquario) {
        return aquarioRepository.save(aquario);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Aquario> atualizar(@PathVariable Long id, @RequestBody Aquario aquarioAtualizado) {
        Optional<Aquario> optionalAquario = aquarioRepository.findById(id);
        if (optionalAquario.isPresent()) {
            Aquario aquarioExistente = optionalAquario.get();
            aquarioExistente.setNome(aquarioAtualizado.getNome());
            aquarioExistente.setLocalizacao(aquarioAtualizado.getLocalizacao());
            aquarioExistente.setCapacidade(aquarioAtualizado.getCapacidade());
            return ResponseEntity.ok(aquarioRepository.save(aquarioExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (aquarioRepository.existsById(id)) {
            aquarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





