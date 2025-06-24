package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AquarioDTO;
import com.example.Aquarium.service.AquarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aquario")
public class AquarioController {

    @Autowired
    private AquarioService aquarioService;

    @Operation(summary = "Buscar aquário por ID")
    @GetMapping("/{id}")
    public AquarioDTO buscarPorId(@PathVariable Long id) {
    return aquarioService.buscarPorId(id);
    }

    @GetMapping
    public List<AquarioDTO> listar() {
        return aquarioService.listar();
    }
    
    @PostMapping
    public AquarioDTO criar(@RequestBody AquarioDTO aquarioDTO) {
        return aquarioService.criar(aquarioDTO);
    }

    @PutMapping("/{id}")
    public AquarioDTO atualizar(@PathVariable Long id, @RequestBody AquarioDTO aquarioDTO) {
        return aquarioService.atualizar(id, aquarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        aquarioService.deletar(id);
    }
}







