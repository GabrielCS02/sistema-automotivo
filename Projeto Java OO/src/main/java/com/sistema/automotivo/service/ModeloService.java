package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Modelo;
import com.sistema.automotivo.repository.ModeloRepository;
import com.sistema.automotivo.repository.MarcaRepository; //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository; //

    public List<Modelo> listarModelos() {
        return modeloRepository.findAll();
    }

    public List<Modelo> listarPorMarca(Long marcaId) {
        return modeloRepository.findByMarcaId(marcaId);
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo salvar(Modelo modelo) {
        // Verifica se a marca existe antes de salvar
        if (modelo.getMarca() == null || modelo.getMarca().getId() == null) {
            throw new RuntimeException("A marca deve ser informada.");
        }

        if (!marcaRepository.existsById(modelo.getMarca().getId())) {
            throw new RuntimeException("A marca informada não existe. Cadastre a marca antes do modelo.");
        }

        return modeloRepository.save(modelo);
    }

    public void deletar(Long id) {
        modeloRepository.deleteById(id);
    }
}
