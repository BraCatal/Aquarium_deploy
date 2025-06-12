package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AquarioDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aquario")
public class AquarioController {

    @GetMapping
    public List<AquarioDTO> listar() {
        return null;
    }

    @PostMapping
    public AquarioDTO criar(@RequestBody AquarioDTO aquarioDTO) {
        return null;
    }

    @PutMapping("/{id}")
    public AquarioDTO atualizar(@PathVariable Long id, @RequestBody AquarioDTO aquarioDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
    }
}



