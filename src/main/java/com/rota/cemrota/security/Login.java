package com.rota.cemrota.security;

public class Login {
  private String nome_usuario;
  private String senha;




  public Login() {
}

public Login(String nome_usuario, String senha) {
    this.nome_usuario = nome_usuario;
    this.senha = senha;
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
public void setSenha(String senha) {
    this.senha = senha;
}
}
