package com.sistema.automotivo.controller;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        if (veiculo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/status/{status}")
    public List<Veiculo> buscarPorStatus(@PathVariable String status) {
        return veiculoService.buscarPorStatus(status);
    }

    @GetMapping("/modelo/{nome}")
    public List<Veiculo> buscarPorModelo(@PathVariable String nome) {
        return veiculoService.buscarPorModelo(nome);
    }

    @GetMapping("/preco")
    public List<Veiculo> buscarPorFaixaDePreco(@RequestParam Double min, @RequestParam Double max) {
        return veiculoService.buscarPorFaixaDePreco(min, max);
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo atualizado) {
        Veiculo existente = veiculoService.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();

        existente.setCor(atualizado.getCor());
        existente.setAnoFabricacao(atualizado.getAnoFabricacao());
        existente.setQuilometragem(atualizado.getQuilometragem());
        existente.setPreco(atualizado.getPreco());
        existente.setStatus(atualizado.getStatus());
        existente.setModelo(atualizado.getModelo());

        return ResponseEntity.ok(veiculoService.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
