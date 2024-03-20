package com.rota.cemrota.Repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rota.cemrota.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    
   @Query(value = "select * from usuario where usuario.email=?1",nativeQuery = true)
   Usuario TicasjmafaknEmail(String email);

   // Usuario findByNome_usuario(String nome_usuario);

}
