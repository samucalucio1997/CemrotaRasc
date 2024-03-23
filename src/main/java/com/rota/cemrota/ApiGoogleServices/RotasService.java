package com.rota.cemrota.ApiGoogleServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.JsonObject;
import com.google.maps.model.LatLng;

import reactor.core.publisher.Flux;

@Service
public class RotasService {

    // @Value("${chave}")
    // private String chave;
   
   public Flux<Object> PegarRotaPadrao(String origem, String destino){
      try {
        JsonObject obj = new JsonObject();
        obj.get("routes");
        Flux<DirectionsResponse> resp = WebClient.builder().baseUrl("https://maps.googleapis.com/maps/api/directions/json?origin="+origem+"&destination="+destino+"&key=AIzaSyDW7WsDOA3tMKkx8d9cxmGiw_PPk9Er-Q4")
       .build().get().retrieve().bodyToFlux(DirectionsResponse.class);
        DirectionsResponse rotas = resp.blockFirst();
        Routes routes = rotas.routes().get(0);
        // String encode = routes.leg()
        // for (Routes routes2 : routes) {
        //     System.out.println(routes2.leg().start_address() + " e " + routes2.leg().end_address());
        // }
        return null;
      } catch (Exception e) {
        throw e;
      }
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
