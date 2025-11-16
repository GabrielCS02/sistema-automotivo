package com.sistema.automotivo.controller;

import com.sistema.automotivo.dto.ModeloDTO;
import com.sistema.automotivo.model.Modelo;
import com.sistema.automotivo.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> listarTodos() {
        return modeloService.listarModelos();
    }

    @GetMapping("/marca/{id}")
    public ResponseEntity<List<ModeloDTO>> listarPorMarca(@PathVariable Long id) {
        List<Modelo> modelos = modeloService.listarPorMarca(id);

        List<ModeloDTO> resultado = modelos.stream()
                .map(m -> new ModeloDTO(m.getId(), m.getNome(), m.getAnoLancamento()))
                .toList();

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Long id) {
        Modelo modelo = modeloService.buscarPorId(id);
        if (modelo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public Modelo cadastrar(@RequestBody Modelo modelo) {
        return modeloService.salvar(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizar(@PathVariable Long id, @RequestBody Modelo modeloAtualizado) {
        Modelo existente = modeloService.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();

        existente.setNome(modeloAtualizado.getNome());
        existente.setAnoLancamento(modeloAtualizado.getAnoLancamento());
        existente.setMarca(modeloAtualizado.getMarca());

        return ResponseEntity.ok(modeloService.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        modeloService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
