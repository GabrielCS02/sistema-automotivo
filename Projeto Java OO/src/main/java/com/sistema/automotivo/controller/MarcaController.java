package com.sistema.automotivo.controller;

import com.sistema.automotivo.model.Marca;
import com.sistema.automotivo.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*") // permite acesso do frontend
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> listarTodas() {
        return marcaService.listarMarcas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        Marca marca = marcaService.buscarPorId(id);
        if (marca == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public Marca cadastrar(@RequestBody Marca marca) {
        return marcaService.salvar(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody Marca marcaAtualizada) {
        Marca marcaExistente = marcaService.buscarPorId(id);
        if (marcaExistente == null) return ResponseEntity.notFound().build();
        marcaExistente.setNome(marcaAtualizada.getNome());
        return ResponseEntity.ok(marcaService.salvar(marcaExistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        marcaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
