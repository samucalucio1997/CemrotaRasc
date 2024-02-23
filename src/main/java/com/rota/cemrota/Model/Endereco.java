package com.rota.cemrota.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_Endereco;   
    private String cidade;
    private String estado;
    private String rua;
    private String numero;
 
 
   public String getCidade() {
    return cidade;
}
public void setCidade(String cidade) {
    this.cidade = cidade;
}
public String getEstado() {
    return estado;
}
public void setEstado(String estado) {
    this.estado = estado;
}
public String getRua() {
    return rua;
}
public void setRua(String rua) {
    this.rua = rua;
}
public String getNumero() {
    return numero;
}
public void setNumero(String numero) {
    this.numero = numero;
}

 public UUID getId_Endereco() {
    return id_Endereco;
}
}
