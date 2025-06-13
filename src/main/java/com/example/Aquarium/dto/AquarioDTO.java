package com.example.Aquarium.dto;

import java.util.List;

public class AquarioDTO {

    private Long id;
    private String nome;
    private String localizacao;
    private int capacidade;
    private List<Long> animaisIds;; // Certifique-se de que AnimalDTO esteja importado corretamente

    public AquarioDTO() {
    }

    public AquarioDTO(Long id, String nome, String localizacao, int capacidade, List<AnimalDTO> animais) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.animais = animais;
    }

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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<AnimalDTO> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalDTO> animais) {
        this.animais = animais;
    }
}



