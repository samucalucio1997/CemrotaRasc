package com.rota.cemrota.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rota.cemrota.ApiGoogleServices.PolilinhaDTO;
import com.rota.cemrota.ApiGoogleServices.RotasService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/apiGoogle")
public class ApiRestGoogleController {
    
    @Autowired
    private RotasService rotasService;
     
    @GetMapping("/li")
    public ResponseEntity<PolilinhaDTO> RotaPadrao(@RequestParam("origem") String origem,@RequestParam("destino") String destino){
        try {
            Flux<Object> retorno = this.rotasService.PegarRotaPadrao(origem, destino);
            String test = retorno.blockFirst().toString();
            System.out.println(test);
            return  null;
        } catch (Exception e) {
            throw e;
        }
    }

    
}
