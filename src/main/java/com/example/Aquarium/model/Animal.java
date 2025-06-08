package com.example.Aquarium.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especie;

    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "aquario_id")  // Cria a FK na tabela Animal
    private Aquario aquario;
}