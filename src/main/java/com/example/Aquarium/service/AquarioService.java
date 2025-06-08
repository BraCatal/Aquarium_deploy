package com.example.Aquarium.service;

import com.example.Aquarium.model.Aquario;
import com.example.Aquarium.repository.AquarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquarioService {

    private final AquarioRepository aquarioRepository;

    public AquarioService(AquarioRepository aquarioRepository) {
        this.aquarioRepository = aquarioRepository;
    }

    public List<Aquario> listarTodos() {
        return aquarioRepository.findAll();
    }

    public Aquario buscarPorId(Long id) {
        return aquarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Aquário não encontrado"));
    }

    public Aquario salvar(Aquario aquario) {
        return aquarioRepository.save(aquario);
    }

    public Aquario atualizar(Long id, Aquario aquarioAtualizado) {
        Aquario aquario = buscarPorId(id);
        aquario.setNome(aquarioAtualizado.getNome());
        aquario.setLocalizacao(aquarioAtualizado.getLocalizacao());
        aquario.setCapacidade(aquarioAtualizado.getCapacidade());
        return aquarioRepository.save(aquario);
    }

    public void deletar(Long id) {
        aquarioRepository.deleteById(id);
    }
}
