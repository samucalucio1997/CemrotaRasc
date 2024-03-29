package com.rota.cemrota.Controller;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.Model.PontoInteresse;
import com.rota.cemrota.Model.Usuario;
import com.rota.cemrota.Service.PontoInteresseService;
import com.rota.cemrota.Service.UserService;
import com.rota.cemrota.security.TokenUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/home")
public class Control {
    
   @Autowired
   private AuthenticationManager authenticationManager; 

   @Autowired
   private PontoInteresseService pontoInteresseService;

   @Autowired
   private UserService userService;

   @PostMapping(value="/login")
public ResponseEntity<String> getPri(
   @RequestParam("nome_usuario") String nome_user,
   @RequestParam("senha") String senha
){
   try {
      UsernamePasswordAuthenticationToken authenticationToken =
         new UsernamePasswordAuthenticationToken(nome_user, senha);
      
      
      Authentication authentication = this.authenticationManager.authenticate(authenticationToken); 
      
      
      if (authentication.isAuthenticated()) {
         var auth = (Usuario) authentication.getPrincipal();
         
         return ResponseEntity.ok(TokenUtil.EncodeT(auth));
      } else {
         throw new NoSuchElementException("Usuário não autenticado");
      }
   } catch (Exception e) {
      throw new NoSuchElementException("Erro durante a autenticação");
   }
}

   @PostMapping(value = "/cadastrarUsuario")   
   public ResponseEntity<Usuario> CriaUsuario(
      @RequestParam(value = "file",required = false) MultipartFile file,
      @RequestParam(value="nome") String nome,
      @RequestParam(value = "senha") String senha,
      @RequestParam(value = "email") String email,
      @RequestParam("sobrenome") String sobrenome) throws IllegalStateException, IOException{//como aqui estara presente imagem, a estrategia de @RequestParam é melhor
      Usuario usuario = new Usuario();
      usuario.setEmail(email);
      usuario.setNome_usuario(nome);
      usuario.setSenha(senha);
      usuario.setSobrenome(sobrenome);
      Usuario user =  this.userService.CadastrarUsuario(usuario,file!=null?file:null);
      return ResponseEntity.ok(user);
   }
   
   @PostMapping("/cadastroPonto")
   public ResponseEntity<PontoInteresse> criarPontoInteress(@RequestBody PontoInteresse ponto){
       PontoInteresse pontoInteresse = this.pontoInteresseService.CadastrarPonto(ponto);
       return ResponseEntity.ok(pontoInteresse);
   }


}
