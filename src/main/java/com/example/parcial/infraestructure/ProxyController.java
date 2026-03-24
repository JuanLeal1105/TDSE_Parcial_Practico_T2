package com.example.parcial.infraestructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ProxyController {

    private static final String USER_AGENT = "Mozilla/5.0";

    @GetMapping("/proxy/sequence")
    public String getSequenceProxy(@RequestParam(value = "value") int value) {
        String service1 = System.getenv("MATH_SERVICE_1");
        String service2 = System.getenv("MATH_SERVICE_2");

        if (service1 == null) service1 = "http://localhost:8081";
        if (service2 == null) service2 = "http://localhost:8082";

        try {
            return sendGet(service1 + "/sequence?value=" + value);
        } catch (IOException e1) {
            System.out.println("Servicio 1 caído. Delegando al PASIVO (Servicio 2)...");
            try {
                return sendGet(service2 + "/sequence?value=" + value);
            } catch (IOException e2) {
                return "{\"error\": \"Falla crítica: Ambos servicios están caídos.\"}";
            }
        }
    }

    private String sendGet(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("HTTP Error: " + responseCode);
        }
    }
}