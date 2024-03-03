package com.rota.cemrota.Model;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reserva {
   @EmbeddedId
   private ReservaId reservaId;
   private double valor_total;
   private Date data_hora_entrada;
   private Date data_hora_saida;
   
   public ReservaId getReservaId() {
      return reservaId;
   }
   public void setReservaId(ReservaId reservaId) {
      this.reservaId = reservaId;
   }
   public double getValor_total() {
      return valor_total;
   }
   public void setValor_total(double valor_total) {
      this.valor_total = valor_total;
   }
   public Date getData_hora_entrada() {
      return data_hora_entrada;
   }
   public void setData_hora_entrada(Date data_hora_entrada) {
      this.data_hora_entrada = data_hora_entrada;
   }
   public Date getData_hora_saida() {
      return data_hora_saida;
   }
   public void setData_hora_saida(Date data_hora_saida) {
      this.data_hora_saida = data_hora_saida;
   }
   
}
