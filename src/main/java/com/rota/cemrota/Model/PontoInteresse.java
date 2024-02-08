package com.rota.cemrota.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
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
    private Double longitude;
    private Double latitude;
    private String turnos;
    private String dias;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Endereco endereco;
}
