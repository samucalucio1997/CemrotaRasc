package com.rota.cemrota.ApiGoogleServices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Step {
  @JsonProperty("polyline")  
  private Polyline[] poly;

public Polyline[] getPoly() {
    return poly;
}

public void setPoly(Polyline[] poly) {
    this.poly = poly;
}



  
}
