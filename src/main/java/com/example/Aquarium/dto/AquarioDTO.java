package com.example.Aquarium.dto;

import java.util.List;

public class AquarioDTO {
    private Long id;
    private String nome;
    private String localizacao;
    private Integer capacidade;
    private List<AnimalDTO> animais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public List<AnimalDTO> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDTO> animais) {
        this.animais = animais;
    }
}



