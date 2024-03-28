package com.rota.cemrota.ApiGoogleServices;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Polyline implements Serializable {
   @JsonProperty("points") 
   private String points;

public String getPoints() {
    return points;
}

public void setPoints(String points) {
    this.points = points;
}
}
