package com.rota.cemrota.Repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rota.cemrota.Model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    
   Usuario findByEmail(String email);

}
