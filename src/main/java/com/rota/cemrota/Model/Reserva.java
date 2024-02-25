package com.rota.cemrota.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reserva {
   @EmbeddedId
   private ReservaId reservaId;
}
