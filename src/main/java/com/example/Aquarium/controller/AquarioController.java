package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AquarioDTO;
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

    @GetMapping
    public List<Aquario> listarTodos() {
        return aquarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aquario> buscarPorId(@PathVariable Long id) {
        Optional<Aquario> aquario = aquarioRepository.findById(id);
        return aquario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aquario criar(@RequestBody Aquario aquario) {
        return aquarioRepository.save(aquario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aquario> atualizar(@PathVariable Long id, @RequestBody Aquario aquarioAtualizado) {
        Optional<Aquario> aquarioOptional = aquarioRepository.findById(id);
        if (aquarioOptional.isPresent()) {
            Aquario aquarioExistente = aquarioOptional.get();
            aquarioExistente.setNome(aquarioAtualizado.getNome());
            aquarioExistente.setLocalizacao(aquarioAtualizado.getLocalizacao());
            aquarioExistente.setCapacidade(aquarioAtualizado.getCapacidade());
            aquarioExistente.setAnimais(aquarioAtualizado.getAnimais());
            return ResponseEntity.ok(aquarioRepository.save(aquarioExistente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (aquarioRepository.existsById(id)) {
            aquarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}







