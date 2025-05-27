package com.fiap.WeatherGuard.controller;

import com.fiap.WeatherGuard.model.Usuario;
import com.fiap.WeatherGuard.model.UsuarioAlerta;
import com.fiap.WeatherGuard.service.UsuarioAlertaService;
import com.fiap.WeatherGuard.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-alertas")
public class UsuarioAlertaController {

    @Autowired
    private UsuarioAlertaService usuarioAlertaService;

    @Autowired
    private UsuarioService usuarioService;

    // Listar alertas de um usuário (ex: GET /api/usuario-alertas/usuario/5)
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<UsuarioAlerta>> listarAlertasPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        List<UsuarioAlerta> alertas = usuarioAlertaService.listarAlertasDoUsuario(usuario);
        return ResponseEntity.ok(alertas);
    }

    // Marcar alerta como visualizado (ex: PUT /api/usuario-alertas/visualizar/10)
    @PutMapping("/visualizar/{usuarioAlertaId}")
    public ResponseEntity<UsuarioAlerta> marcarComoVisualizado(@PathVariable Long usuarioAlertaId) {
        UsuarioAlerta atualizado = usuarioAlertaService.marcarComoVisualizado(usuarioAlertaId);
        return ResponseEntity.ok(atualizado);
    }
}
