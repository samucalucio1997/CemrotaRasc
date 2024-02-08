package com.rota.cemrota.Repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rota.cemrota.Model.Usuario;





public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    
   Usuario findByEmail(String email);

}
