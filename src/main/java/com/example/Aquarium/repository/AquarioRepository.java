package com.example.Aquarium.repository;

import com.example.Aquarium.model.Aquario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AquarioRepository extends JpaRepository<Aquario, Long> {

    // Já herdado do JpaRepository, mas declarado aqui por clareza
    Optional<Aquario> findById(Long id);

    // Exemplo: encontrar aquário por nome (opcional)
    // Optional<Aquario> findByNome(String nome);

}

