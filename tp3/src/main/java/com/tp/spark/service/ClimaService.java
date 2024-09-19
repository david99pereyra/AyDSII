package com.tp.spark.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.tp.spark.model.Clima;

public class ClimaService {
    private static final String API_KEY = "1dc6ff4b34fe2993cee8e3a2fa6db448";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final Gson gson = new Gson();
    private static final HttpClient client = HttpClient.newHttpClient();

    public static Clima getClima(String ciudad) throws Exception {
        String encodeCuidad = URLEncoder.encode(ciudad, StandardCharsets.UTF_8.toString());
        String url = BASE_URL + "?q=" + encodeCuidad + "&appid=" + API_KEY + "&units=metric";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al consumir la API del Clima: " + response.statusCode());
        }

        return gson.fromJson(response.body(), Clima.class);
    }
}
