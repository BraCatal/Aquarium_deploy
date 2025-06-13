package com.example.Aquarium.mapper;

import com.example.Aquarium.dto.AquarioDTO;
import com.example.Aquarium.model.Animal;
import com.example.Aquarium.model.Aquario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AquarioMapper {

    public AquarioDTO toDTO(Aquario aquario) {
        List<Long> animaisIds = aquario.getAnimais()
                                       .stream()
                                       .map(Animal::getId)
                                       .collect(Collectors.toList());

        return AquarioDTO.builder()
                .id(aquario.getId())
                .nome(aquario.getNome())
                .localizacao(aquario.getLocalizacao())
                .capacidade(aquario.getCapacidade())
                .animaisIds(animaisIds)
                .build();
    }

    public Aquario toEntity(AquarioDTO dto) {
        Aquario aquario = new Aquario();
        aquario.setId(dto.getId());
        aquario.setNome(dto.getNome());
        aquario.setLocalizacao(dto.getLocalizacao());
        aquario.setCapacidade(dto.getCapacidade());

        // A lista de animais não será montada aqui com base em IDs.
        // Isso deve ser feito em um service, caso necessário.
        aquario.setAnimais(null); // ou deixe sem setar, se preferir

        return aquario;
    }
}




