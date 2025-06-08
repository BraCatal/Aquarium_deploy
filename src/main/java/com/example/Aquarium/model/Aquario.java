package com.example.Aquarium.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Aquario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    private Integer capacidade;

    @OneToMany(mappedBy = "aquario", cascade = CascadeType.ALL)
    private List<Animal> animais;
}

