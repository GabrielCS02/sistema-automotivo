package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Marca;
import com.sistema.automotivo.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deletar(Long id) {
        marcaRepository.deleteById(id);
    }
}
