package com.rota.cemrota.ApiGoogleServices;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
// @JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponse implements Serializable{
    @JsonProperty("geocoded_waypoints")
    private List<Object> geocode;
    @JsonProperty("routes")
    private List<Routes> routes;
    @JsonProperty("status")
    private String status;


    public List<Object> getGeocode() {
        return geocode;
    }
    public void setGeocode(List<Object> geocode) {
        this.geocode = geocode;
    }
    public List<Routes> getRoutes() {
        return routes;
    }
    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    

   
}
