package com.rota.cemrota.ApiGoogleServices;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(
     double lat,
     double lng
) {
     @JsonCreator
     public static Location fromLocation(String Json) throws IOException{
          return new ObjectMapper().readValue(Json, Location.class);
     }
     @JsonValue
     public String toJson() throws IOException{
          return new ObjectMapper().writeValueAsString(this);
     }
}
