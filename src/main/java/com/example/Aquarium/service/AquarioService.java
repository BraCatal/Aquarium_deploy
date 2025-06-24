package com.example.Aquarium.service;

import com.example.Aquarium.dto.AquarioDTO;
import com.example.Aquarium.mapper.AquarioMapper;
import com.example.Aquarium.model.Aquario;
import com.example.Aquarium.repository.AquarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AquarioService {

    private final AquarioRepository aquarioRepository;

    public AquarioService(AquarioRepository aquarioRepository) {
        this.aquarioRepository = aquarioRepository;
    }

    public List<AquarioDTO> listar() {
        return aquarioRepository.findAll()
                .stream()
                .map(AquarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AquarioDTO buscarPorId(Long id) {
    Aquario aquario = aquarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Aquário não encontrado"));
    return AquarioMapper.toDTO(aquario);
    }


    public AquarioDTO criar(AquarioDTO dto) {
        Aquario aquario = AquarioMapper.toEntity(dto);
        Aquario salvo = aquarioRepository.save(aquario);
        return AquarioMapper.toDTO(salvo);
    }

    public AquarioDTO atualizar(Long id, AquarioDTO dto) {
        Aquario aquario = aquarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aquário não encontrado"));

        aquario.setNome(dto.getNome());
        aquario.setLocalizacao(dto.getLocalizacao());
        aquario.setCapacidade(dto.getCapacidade());

        Aquario atualizado = aquarioRepository.save(aquario);
        return AquarioMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        aquarioRepository.deleteById(id);
    }
}

