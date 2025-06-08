package com.example.Aquarium.mapper;

import com.example.Aquarium.dto.AquarioDTO;
import com.example.Aquarium.dto.AnimalDTO;
import com.example.Aquarium.model.Aquario;

import java.util.List;
import java.util.stream.Collectors;

public class AquarioMapper {

    public static AquarioDTO toDTO(Aquario aquario) {
        AquarioDTO dto = new AquarioDTO();
        dto.setId(aquario.getId());
        dto.setNome(aquario.getNome());
        dto.setLocalizacao(aquario.getLocalizacao());
        dto.setCapacidade(aquario.getCapacidade());

        // Converter a lista de Animais
        List<AnimalDTO> animaisDTO = aquario.getAnimais()
                .stream()
                .map(AnimalMapper::toDTO)
                .collect(Collectors.toList());
        dto.setAnimais(animaisDTO);

        return dto;
    }
}

