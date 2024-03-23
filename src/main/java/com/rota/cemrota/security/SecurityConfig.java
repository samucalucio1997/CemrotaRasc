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
              p -> {p.requestMatchers(HttpMethod.POST, "/home/cadastrarUsuario").permitAll()
              .requestMatchers(HttpMethod.POST,"/home/login").permitAll()
              .anyRequest().authenticated();
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       })
      //  .oauth2Login(n -> {
      //   n.permitAll();
      // })
      .addFilterBefore(this.FilterChain, UsernamePasswordAuthenticationFilter.class).build();
   }
   
   @Bean
   public AuthenticationManager AuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
           System.out.println("passou aqui");  
           return authenticationConfiguration.getAuthenticationManager();
   }
  
   @Bean
   public PasswordEncoder passwordEncoder(){ 
            System.out.println("BCryptpasswordEncoder trabalhando");
            return new BCryptPasswordEncoder();
   } 
}
