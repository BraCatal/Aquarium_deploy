package com.example.Aquarium.dto;

import lombok.Data;

import java.util.List;

@Data
public class AquarioDTO {

    private Long id;
    private String nome;
    private String localizacao;
    private Integer capacidade;
    private List<AnimalDTO> animais; // Lista de animais associada ao aquário
}

