package com.rota.cemrota.ApiGoogleServices;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;


public record Distance(
 String text,
 int value
) {
     @JsonCreator
     public static Distance fromDistance(String Json) throws IOException{
        return new ObjectMapper().readValue(Json, Distance.class);
     }
     
     @JsonValue
     public String toJson() throws IOException{
        return new ObjectMapper().writeValueAsString(this);
     }
}
