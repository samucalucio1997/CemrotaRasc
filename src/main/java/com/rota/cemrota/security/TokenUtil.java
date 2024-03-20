package com.rota.cemrota.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rota.cemrota.Model.Usuario;

public class TokenUtil {
      
   
    public static String EncodeT(Usuario username){
        return JWT.create()
        .withIssuer("Auth")
        .withSubject(username.getEmail())
        .withClaim("id", username.getId().toString())
        .withExpiresAt(LocalDateTime.now()
        .plusMinutes(2)
        .toInstant(ZoneOffset.of("-03:00")))
        .sign(Algorithm.HMAC256("grpirn%#4096"));
    }

    public static String getSubject(String token){
      return JWT.require(Algorithm.HMAC256("grpirn%#4096"))
      .withIssuer("Auth").build().verify(token).getSubject();
    }
}
