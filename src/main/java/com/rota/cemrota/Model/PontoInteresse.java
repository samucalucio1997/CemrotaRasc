package com.rota.cemrota.Model;

import java.util.UUID;

import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer.Target;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PontoInteresse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double longitude;
    private Double latitude;
    private String turnos;
    private String dias;
    private int qtd_quartos;
    private int qtd_hospedes;
    private Double valor_quarto;
    
    @Enumerated(EnumType.STRING)
    private Servico servico;
    
    @OneToOne
    private Endereco endereco;
    private String titulo;
    
    


    public PontoInteresse(Double longitude, Double latitude, String turnos, String dias, int qtd_quartos,
            int qtd_hospedes, Double valor_quarto, Servico servico, Endereco endereco, String titulo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.turnos = turnos;
        this.dias = dias;
        this.qtd_quartos = qtd_quartos;
        this.qtd_hospedes = qtd_hospedes;
        this.valor_quarto = valor_quarto;
        this.servico = servico;
        this.endereco = endereco;
        this.titulo = titulo;
    }

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

    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }


    private enum Servico {
        HOSPEDAGEM("hospedagem"),
        VENDA("venda"),
        EVENTO("evento"),
        PONTO_TURISTICO("ponto turistico");
         
        private final String descricao;
    
        private Servico(String descricao) {
            this.descricao = descricao;
        }
    
        public String getDescricao() {
            return descricao;
        }    
    }

}


