package com.rota.cemrota.ApiGoogleServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Distance(
 String text,
 int value
) {

}
