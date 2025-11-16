package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }

    // Filtros personalizados
    public List<Veiculo> buscarPorStatus(String status) {
        return veiculoRepository.findByStatus(status);
    }

    public List<Veiculo> buscarPorModelo(String nome) {
        return veiculoRepository.findByModeloNomeContainingIgnoreCase(nome);
    }

    public List<Veiculo> buscarPorFaixaDePreco(Double precoMin, Double precoMax) {
        return veiculoRepository.findByPrecoBetween(precoMin, precoMax);
    }
}
