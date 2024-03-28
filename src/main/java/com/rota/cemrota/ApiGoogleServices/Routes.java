package com.rota.cemrota.ApiGoogleServices;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Routes implements Serializable {
    // @JsonProperty("legs")    
    // private List<String> leg;
    @JsonProperty("bounds")
    private Object bounds;
    @JsonProperty("copyrights")
    private String copyrights;
    @JsonProperty("overview_polyline")
    private Polyline lines;


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

    // public List<String> getLeg() {
    //     return leg;
    // }

    // public void setLeg(List<String> leg) {
    //     this.leg = leg;
    // }

    public Polyline getLines() {
        return lines;
    }

    public void setLines(Polyline lines) {
        this.lines = lines;
    }

    

   

    
}
