package com.example.Aquarium.dto;

public class AnimalDTO {
    private Long id;
    private String nome;
    private String especie;
    private Integer idade;
    private Long aquarioId; // Novo campo para o relacionamento

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getAquarioId() {
        return aquarioId;
    }

    public void setAquarioId(Long aquarioId) {
        this.aquarioId = aquarioId;
    }
}

