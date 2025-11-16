package com.sistema.automotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.automotivo.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
