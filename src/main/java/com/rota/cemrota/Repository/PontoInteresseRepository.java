package com.rota.cemrota.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rota.cemrota.Model.PontoInteresse;
@Repository
public interface PontoInteresseRepository extends JpaRepository<PontoInteresse,UUID>{

   List<PontoInteresse> findByTitulo(String titulo);

}
