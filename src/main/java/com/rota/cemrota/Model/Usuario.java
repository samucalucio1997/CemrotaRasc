package com.rota.cemrota.Model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String nome_usuario;
    private String senha;
    private String email;
    private String sobrenome;

    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;
    
    private String imgPerfil;
    
     
    
    // public Usuario() {
    // }

    // public Usuario(String nome_usuario, String senha, String email, String sobrenome) {
    //     this.nome_usuario = nome_usuario;
    //     this.senha = senha;
    //     this.email = email;
    //     this.sobrenome = sobrenome;
    // }

    public UUID getId() {
        return id;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return getSenha();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

}
