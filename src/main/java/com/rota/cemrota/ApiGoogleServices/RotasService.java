package com.rota.cemrota.ApiGoogleServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.maps.model.LatLng;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RotasService {

    // @Value("${chave}")
    // private String chave;
   
   public void PegarRotaPadrao(String origem, String destino) throws Exception{
    Mono<JSONObject> directionsMono = WebClient.create()
    .get()
    .uri("https://maps.googleapis.com/maps/api/directions/json?origin=" + origem + "&destination=" + destino + "&key=")
    .accept(MediaType.APPLICATION_JSON)
    .retrieve()
    .bodyToMono(Map.class) // Supondo que a resposta seja um Map
    .map(response -> {
      try {
        return new JSONObject(new ObjectMapper().writeValueAsString(response));
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return null;
    });


   directionsMono.subscribe(jsonObject -> {
    try {
        // Acesse o array "routes"
        JSONArray routes = jsonObject.getJSONArray("routes");

        // Verifique se há rotas
        if (routes.length() > 0) {
            // Acesse o primeiro objeto de rota no array
            JSONObject firstRoute = routes.getJSONObject(0);
            JSONObject location = firstRoute.optJSONObject("end_location"); // Use optJSONObject para lidar com possíveis ausências
            
            if (location != null) {
                double latitude = location.getDouble("lat");
                double longitude = location.getDouble("lng");
                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
                // ... processe latitude e longitude ...
            } else {
                System.out.println("Localização final não encontrada na rota");
            }
            

        } else {
            System.out.println("Nenhuma rota encontrada no JSON");
        }
    } catch (Exception e) {
        // Tratar exceções de análise
        e.printStackTrace();
    }
});
    // System.out.println(js);
   }


   public static List<LatLng> decode(String encodedPolyline) {
        List<LatLng> poly = new ArrayList<>();
        int index = 0;
        int len = encodedPolyline.length();
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng(((double) lat / 1E5), ((double) lng / 1E5));
            poly.add(p);
        }
        return poly;
    }


}
