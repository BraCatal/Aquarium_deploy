package com.example.Aquarium.controller;

import com.example.Aquarium.dto.AquarioDTO;
import com.example.Aquarium.mapper.AquarioMapper;
import com.example.Aquarium.model.Aquario;
import com.example.Aquarium.service.AquarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aquarios")
public class AquarioController {

    private final AquarioService aquarioService;

    public AquarioController(AquarioService aquarioService) {
        this.aquarioService = aquarioService;
    }

    @GetMapping
    public List<AquarioDTO> listarTodos() {
        return aquarioService.listarTodos()
                .stream()
                .map(AquarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AquarioDTO buscarPorId(@PathVariable Long id) {
        return AquarioMapper.toDTO(aquarioService.buscarPorId(id));
    }

    @PostMapping
    public AquarioDTO criar(@RequestBody Aquario aquario) {
        Aquario novoAquario = aquarioService.salvar(aquario);
        return AquarioMapper.toDTO(novoAquario);
    }

    @PutMapping("/{id}")
    public AquarioDTO atualizar(@PathVariable Long id, @RequestBody Aquario aquario) {
        Aquario atualizado = aquarioService.atualizar(id, aquario);
        return AquarioMapper.toDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        aquarioService.deletar(id);
    }
}


