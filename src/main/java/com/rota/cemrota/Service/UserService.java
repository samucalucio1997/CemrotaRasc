package com.rota.cemrota.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.Config.FilestorageProperties;
import com.rota.cemrota.Model.Usuario;
import com.rota.cemrota.Repository.UsuarioRepository;
@Service
public class UserService implements UserDetailsService{
     
   
    private final Path fileStoraged;

    @Autowired
    private EmailService emailService;
    

    public UserService(FilestorageProperties fileStoraged) {
        this.fileStoraged = Paths.get(fileStoraged.getUploadDir())
        .toAbsolutePath().normalize();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        System.out.println(usuarioRepository.TicasjmafaknEmail(nome));
        return usuarioRepository.TicasjmafaknEmail(nome);
    }

    public Usuario CadastrarUsuario(Usuario usuario,MultipartFile file) throws IllegalStateException, IOException{
        Usuario usr = (Usuario) usuarioRepository.TicasjmafaknEmail(usuario.getEmail());
        
        if (usr != null) {
           throw new RuntimeException("null");
        }

        if (!file.isEmpty()) {
            String path = file.getOriginalFilename();
            Path caminho = this.fileStoraged.resolve(path).toAbsolutePath().normalize();
            file.transferTo(caminho);
            usuario.setImgPerfil(path);
        }
        
        // this.emailService.Enviar(usuario.getEmail(),
        // usuario.getNome_usuario() + " cadastro foi confirmado",
        // "Bem-vindo ao cemrota");

        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        this.usuarioRepository.save(usuario);
        return usuario;
    }  

}
