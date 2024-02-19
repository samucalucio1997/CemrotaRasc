package com.rota.cemrota.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rota.cemrota.Model.PontoInteresse;

public interface PontoInteresseRepository extends JpaRepository<PontoInteresse,UUID>{

   List<PontoInteresse> findByTitulo(String titulo);

}
