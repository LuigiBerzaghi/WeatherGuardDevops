package com.fiap.WeatherGuard.controller;

import com.fiap.WeatherGuard.model.Alerta;
import com.fiap.WeatherGuard.service.AlertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    // Criar alerta (manual - ex: para testes)
    @PostMapping
    public ResponseEntity<Alerta> criarAlerta(@Valid @RequestBody Alerta alerta) {
        Alerta novo = alertaService.criarAlerta(
                alerta.getTipo(),
                alerta.getDescricao(),
                alerta.getCidade()
        );
        return ResponseEntity.status(201).body(novo);
    }

    // Buscar todos os alertas
    @GetMapping
    public ResponseEntity<List<Alerta>> listarTodos() {
        return ResponseEntity.ok(alertaService.listarTodos());
    }

    // Buscar alerta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.buscarPorId(id));
    }

    // Buscar alertas por cidade
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Alerta>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(alertaService.listarPorCidade(cidade));
    }

    // Deletar alerta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alertaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
