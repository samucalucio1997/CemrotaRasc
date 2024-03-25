package com.rota.cemrota.ApiGoogleServices;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record Duration(
     String text,
     int value
) {
     @JsonCreator
     public static Duration fromString(String json) throws IOException{
           return new ObjectMapper().readValue(json, Duration.class);
     } 

     @JsonValue
     public String toJson() throws JsonProcessingException{
          return new ObjectMapper().writeValueAsString(this);
     }
}
