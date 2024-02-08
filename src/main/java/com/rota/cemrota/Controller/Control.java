package com.rota.cemrota.Controller;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.Model.Usuario;
import com.rota.cemrota.Service.UserService;
import com.rota.cemrota.security.Login;
import com.rota.cemrota.security.TokenUtil;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/home")
public class Control {
    
   @Autowired
   private AuthenticationManager authenticationManager; 
   
   @Autowired
   private UserService userService;

   @PostMapping("/login")
   public ResponseEntity<String> getPri(@RequestParam("nome_usuario") String nome_user,
   @RequestParam("senha") String senha){
      try {
         Login usuario = new Login(nome_user, senha);
         UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.getNome_usuario(), usuario.getSenha());
         AuthenticationManager auth =(AuthenticationManager) this.authenticationManager.authenticate(usernamePasswordAuthenticationToken); 
         var user = (Usuario) auth.authenticate(usernamePasswordAuthenticationToken).getPrincipal();
         return ResponseEntity.ok(TokenUtil.EncodeT(user));
      } catch (Exception e) {
         throw new NoSuchElementException("não cadastrado");
      }
   }

   @PostMapping(value = "/cadastrarUsuario")   
   public ResponseEntity<Usuario> CriaUsuario(
      @RequestParam("file") MultipartFile file,
      @RequestParam("nome_usuario") String nome_usuario,
      @RequestParam("senha") String senha,
      @RequestParam("email") String email,
      @RequestParam("sobrenome") String sobrenome 
   ) throws IllegalStateException, IOException{//como aqui estara presente imagem, a estrategia de @RequestParam é melhor
      Usuario usuario = new Usuario(nome_usuario, senha, email, sobrenome);
      
      Usuario user =  this.userService.CadastrarUsuario(usuario,file);
      return ResponseEntity.ok(user);
   }
}
