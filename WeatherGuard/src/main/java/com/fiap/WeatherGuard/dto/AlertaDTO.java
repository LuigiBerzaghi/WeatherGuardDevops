package com.fiap.WeatherGuard.dto;

import java.time.LocalDateTime;

public class AlertaDTO {

    private String tipo;
    private String descricao;
    private String cidade;
    private LocalDateTime data;
    private boolean visualizado;

    public AlertaDTO() {}

    public AlertaDTO(String tipo, String descricao, String cidade, LocalDateTime data, boolean visualizado) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.cidade = cidade;
        this.data = data;
        this.visualizado = visualizado;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }
}

