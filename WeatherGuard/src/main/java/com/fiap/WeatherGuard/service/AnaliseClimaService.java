package com.fiap.WeatherGuard.service;

import com.fiap.WeatherGuard.client.ClimaClient;
import com.fiap.WeatherGuard.dto.OpenWeatherResponse;
import com.fiap.WeatherGuard.model.Alerta;
import com.fiap.WeatherGuard.model.Usuario;
import com.fiap.WeatherGuard.service.AlertaService;
import com.fiap.WeatherGuard.service.UsuarioService;
import com.fiap.WeatherGuard.service.UsuarioAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseClimaService {

    @Autowired
    private ClimaClient climaClient;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlertaService alertaService;

    @Autowired
    private UsuarioAlertaService usuarioAlertaService;

    public void verificarClimaPorLocalizacao(double lat, double lon) {
        OpenWeatherResponse resposta = climaClient.buscarClima(lat, lon);
        if (resposta == null || resposta.getCidade() == null) return;

        String cidade = resposta.getCidade();
        String tipo = null;
        String descricao = null;

        try {
            double chuva = resposta.getRain() != null && resposta.getRain().get("1h") != null
                    ? ((Number) resposta.getRain().get("1h")).doubleValue() : 0;
            double vento = resposta.getWind() != null && resposta.getWind().get("speed") != null
                    ? ((Number) resposta.getWind().get("speed")).doubleValue() : 0;
            double temperatura = resposta.getMain() != null && resposta.getMain().get("temp") != null
                    ? ((Number) resposta.getMain().get("temp")).doubleValue() : 0;

            if (chuva > 50) {
                tipo = "Alagamento";
                descricao = "Risco de alagamento detectado (chuva > 50mm/h)";
            } else if (vento > 80) {
                tipo = "Vendaval";
                descricao = "Risco de vendaval detectado (vento > 80km/h)";
            } else if (temperatura > 38) {
                tipo = "Onda de Calor";
                descricao = "Risco de calor extremo detectado (temperatura > 38°C)";
            }

            if (tipo != null) {
                Alerta alerta = alertaService.criarAlerta(tipo, descricao, cidade);

                List<Usuario> usuarios = usuarioService.listarTodos();
                for (Usuario usuario : usuarios) {
                    if (usuario.getCidade().equalsIgnoreCase(cidade)) {
                        usuarioAlertaService.associarAlertaAoUsuario(usuario, alerta);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao analisar clima: " + e.getMessage());
        }
    }
}
