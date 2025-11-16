package com.sistema.automotivo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cor;

    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    private Double quilometragem;
    private Double preco;
    private String status;

    // Muitos veículos pertencem a um modelo
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    // Construtores
    public Veiculo() {}

    public Veiculo(String cor, Integer anoFabricacao, Double quilometragem, Double preco, String status, Modelo modelo) {
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.quilometragem = quilometragem;
        this.preco = preco;
        this.status = status;
        this.modelo = modelo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
