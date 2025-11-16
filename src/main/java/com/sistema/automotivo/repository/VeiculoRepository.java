package com.sistema.automotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.automotivo.model.Veiculo;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    // Consultas personalizadas com base em filtros
    List<Veiculo> findByStatus(String status);
    List<Veiculo> findByModeloNomeContainingIgnoreCase(String nome);
    List<Veiculo> findByPrecoBetween(Double precoMin, Double precoMax);
}
