package com.fiap.WeatherGuard.controller;

import com.fiap.WeatherGuard.service.AnaliseClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    @Autowired
    private AnaliseClimaService analiseClimaService;

    // Endpoint para disparar análise climática manualmente
    @GetMapping("/analisar")
    public ResponseEntity<String> analisarClima(@RequestParam double lat, @RequestParam double lon) {
        analiseClimaService.verificarClimaPorLocalizacao(lat, lon);
        return ResponseEntity.ok("Análise climática concluída com sucesso.");
    }
}
