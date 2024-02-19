package com.rota.cemrota.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.Model.PontoInteresse;
import com.rota.cemrota.Repository.PontoInteresseRepository;

@Service
public class PontoInteresseService {

    @Autowired
    private PontoInteresseRepository pontoInteresseRepository;

    public PontoInteresse CadastrarPonto(PontoInteresse ponto){
          PontoInteresse pontoInteresse = this.pontoInteresseRepository.findByTitulo(ponto.getTitulo()).stream().findFirst().get();
          if (pontoInteresse!=null) {
            throw new RuntimeException("Já existe esse Ponto");
          }
          return this.pontoInteresseRepository.save(ponto);
    }
}
