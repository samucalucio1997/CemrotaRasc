package com.rota.cemrota.ApiGoogleServices;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Polyline {
   @JsonProperty("points") 
   private String points;

public String getPoints() {
    return points;
}

public void setPoints(String points) {
    this.points = points;
}
}
