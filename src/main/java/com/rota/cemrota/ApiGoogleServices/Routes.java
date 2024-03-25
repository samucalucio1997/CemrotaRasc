package com.rota.cemrota.ApiGoogleServices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Routes {
    @JsonProperty("legs")    
    private Leg[] leg;
    @JsonProperty("bounds")
    private Object bounds;
    @JsonProperty("copyrights")
    private String copyrights;


    public Object getBounds() {
        return bounds;
    }

    public void setBounds(Object bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public Leg[] getLeg() {
        return leg;
    }

    public void setLeg(Leg[] leg) {
        this.leg = leg;
    }

   

    
}
