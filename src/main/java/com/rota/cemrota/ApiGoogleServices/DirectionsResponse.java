package com.rota.cemrota.ApiGoogleServices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
// @JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponse {
    @JsonProperty("geocoded_waypoints")
    private List<Object> geocode;
    @JsonProperty("routes")
    private Routes[] routes;


    public List<Object> getGeocode() {
        return geocode;
    }
    public void setGeocode(List<Object> geocode) {
        this.geocode = geocode;
    }
    public Routes[] getRoutes() {
        return routes;
    }
    public void setRoutes(Routes[] routes) {
        this.routes = routes;
    }
    
    

   
}
