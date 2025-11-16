package com.sistema.automotivo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "modelos")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    // Muitos modelos pertencem a uma marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonBackReference
    @JsonIgnore
    private Marca marca;

    // Um modelo pode estar ligado a vários veículos
    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    // Construtores
    public Modelo() {}

    public Modelo(String nome, Integer anoLancamento, Marca marca) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.marca = marca;
    }

    // Getters e Setters
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

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
