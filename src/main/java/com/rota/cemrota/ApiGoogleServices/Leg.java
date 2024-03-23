package com.rota.cemrota.ApiGoogleServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public record Leg(
    Distance distance,
    Duration duration,
    Location end_location,
    String end_address,
    Location start_location,
    String start_address,
    PolylineDTO polyline
) {}

