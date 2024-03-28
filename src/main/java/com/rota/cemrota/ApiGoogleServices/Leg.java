package com.rota.cemrota.ApiGoogleServices;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Leg implements Serializable{
    @JsonProperty("distance")
    Distance distance;
    @JsonProperty("duration")
    Duration duration;
    @JsonProperty("end_location")
    Location end_location;
    @JsonProperty("end_address")
    String end_address;
    @JsonProperty("start_location")
    Location start_location;
    @JsonProperty("start_address")
    String start_address;
    @JsonProperty("steps")
    Step[] polyline;


    public Distance getDistance() {
      return distance;
    }
    public void setDistance(Distance distance) {
      this.distance = distance;
    }
    public Duration getDuration() {
      return duration;
    }
    public void setDuration(Duration duration) {
      this.duration = duration;
    }
    public Location getEnd_location() {
      return end_location;
    }
    public void setEnd_location(Location end_location) {
      this.end_location = end_location;
    }
    public String getEnd_address() {
      return end_address;
    }
    public void setEnd_address(String end_address) {
      this.end_address = end_address;
    }
    public Location getStart_location() {
      return start_location;
    }
    public void setStart_location(Location start_location) {
      this.start_location = start_location;
    }
    public String getStart_address() {
      return start_address;
    }
    public void setStart_address(String start_address) {
      this.start_address = start_address;
    }
    public Step[] getPolyline() {
      return polyline;
    }
    public void setPolyline(Step[] polyline) {
      this.polyline = polyline;
    }
    

   

}

