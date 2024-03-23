package com.rota.cemrota.ApiGoogleServices;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DirectionsResponse(
     List<Routes> routes
    //  List<GeocodedWaypoint> geocoded_waypoints
) {

}
