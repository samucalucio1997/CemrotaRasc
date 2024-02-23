package com.rota.cemrota.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   
   @Autowired
   private FilterToken FilterChain;
   
   @Bean 
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return 
        http.csrf(n -> {
           try {
            n.disable()
              .sessionManagement(management -> management
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authorizeHttpRequests(
              p -> {p.requestMatchers(HttpMethod.POST, "/cadastrarUsuario").permitAll()
              .requestMatchers(HttpMethod.GET,"/login").permitAll()
              .anyRequest().permitAll();}
              ).headers().frameOptions().disable();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }).addFilterBefore(this.FilterChain, UsernamePasswordAuthenticationFilter.class).build();
   }
   
   @Bean
   AuthenticationManager AuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
     return authenticationConfiguration.getAuthenticationManager();
   }
  
   @Bean
   PasswordEncoder passwordEncoder(){ 
            return new BCryptPasswordEncoder();
   } 
}
