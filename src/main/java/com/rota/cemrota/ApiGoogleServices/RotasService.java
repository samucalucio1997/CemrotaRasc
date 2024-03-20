package com.rota.cemrota.ApiGoogleServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class RotasService {

    // @Value("${chave}")
    // private String chave;
   
   public Flux<Object> PegarRotaPadrao(String origem, String destino){
      try {
        return WebClient.builder().baseUrl("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origem+"&destinations="+destino+"&key=AIzaSyDW7WsDOA3tMKkx8d9cxmGiw_PPk9Er-Q4")
        .build().get().retrieve().bodyToFlux(Object.class);
      } catch (Exception e) {
        throw e;
      }
   }

}
