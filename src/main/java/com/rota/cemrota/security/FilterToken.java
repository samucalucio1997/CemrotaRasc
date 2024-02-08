package com.rota.cemrota.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rota.cemrota.Model.Usuario;
import com.rota.cemrota.Repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterToken extends OncePerRequestFilter{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String token = "";
        var Authorization = request.getHeader("Authorization");
        if (Authorization != null) {
            token = Authorization.replace("Bearer ", "");
            var subject = TokenUtil.getSubject(token);
            Usuario user =  this.usuarioRepository.findByEmail(subject);
            var userUl = new UsernamePasswordAuthenticationToken(user, null, 
            user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(userUl);
        }
        filterChain.doFilter(request, response);
    }

}
