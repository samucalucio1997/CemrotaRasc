package com.rota.cemrota.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PontoInteresse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTurnos() {
        return turnos;
    }

    public void setTurnos(String turnos) {
        this.turnos = turnos;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getQtd_quartos() {
        return qtd_quartos;
    }

    public void setQtd_quartos(int qtd_quartos) {
        this.qtd_quartos = qtd_quartos;
    }

    public int getQtd_hospedes() {
        return qtd_hospedes;
    }

    public void setQtd_hospedes(int qtd_hospedes) {
        this.qtd_hospedes = qtd_hospedes;
    }

    public Double getValor_quarto() {
        return valor_quarto;
    }

    public void setValor_quarto(Double valor_quarto) {
        this.valor_quarto = valor_quarto;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private Double longitude;
    private Double latitude;
    private String turnos;
    private String dias;
    private int qtd_quartos;
    private int qtd_hospedes;
    private Double valor_quarto;
    @Enumerated(EnumType.STRING)
    private Servico servico;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Endereco endereco;
}
