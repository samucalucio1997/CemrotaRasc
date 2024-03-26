package com.rota.cemrota.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.maps.internal.PolylineEncoding;
import com.rota.cemrota.ApiGoogleServices.DirectionsResponse;
import com.rota.cemrota.ApiGoogleServices.Leg;
import com.rota.cemrota.ApiGoogleServices.RotasService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/apiGoogle")
public class ApiRestGoogleController {
    
    @Autowired
    private RotasService rotasService;
     
    @GetMapping("/li")
    public ResponseEntity<Object> RotaPadrao(@RequestParam("origem") String origem,@RequestParam("destino") String destino) throws Exception{
        try {
            // ObjectMapper mapper = new ObjectMapper();
        
            this.rotasService.PegarRotaPadrao(origem, destino);

            // String test = retorno.blockFirst().toString();
            // System.out.println(test);
            // PolylineEncoding codec = new PolylineEncoding();
            // DirectionsResponse response = mapper.readValue(retorno.blockFirst().toString(), DirectionsResponse.class);
            
            return  ResponseEntity.status(200).body(null);
        } catch (Exception e) {
            throw e;
        }
    }

    
}
