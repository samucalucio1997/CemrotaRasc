package com.rota.cemrota.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String icone;

    private  String descricao;

    public Atrativo() {
    }

    public Atrativo(String icone, String descricao) {
        this.icone = icone;
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
