package com.rota.cemrota.Model;

import java.util.UUID;

import jakarta.persistence.Embeddable;
@Embeddable
public class ReservaId {
   private UUID UsuarioId;
   private UUID PontoInteresseId;


   public ReservaId(UUID usuarioId, UUID pontoInteresseId) {
    UsuarioId = usuarioId;
    PontoInteresseId = pontoInteresseId;
}


public UUID getUsuarioId() {
    return UsuarioId;
}
public void setUsuarioId(UUID usuarioId) {
    UsuarioId = usuarioId;
}
public UUID getPontoInteresseId() {
    return PontoInteresseId;
}
public void setPontoInteresseId(UUID pontoInteresseId) {
    PontoInteresseId = pontoInteresseId;
}
}
