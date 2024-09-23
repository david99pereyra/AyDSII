package com.tp.tp3.controller;

import com.google.gson.Gson;
import com.tp.tp3.model.Clima;
import com.tp.tp3.service.ClimaService;

import spark.Request;
import spark.Response;
import spark.Route;

public class ClimaController {

    private Gson gson = new Gson();

    public Route getClima = (Request req, Response res) -> {
        String ciudad = req.params("ciudad");
        try {
            ClimaService climaService = new ClimaService();
            Clima clima = new Clima();
            clima = climaService.getClima(ciudad);

            res.type("application/json");

            String result = "{" +
                    "\"name\": \"" + clima.getName() + "\"," +
                    "\"temp\": " + clima.getMain().getTemp() + "," +
                    "\"humidity\": " + clima.getMain().getHumidity() + "," +
                    "\"wind_speed\": " + clima.getWind().getSpeed() +
                    "}";
            return result;
        } catch (Exception e) {
            res.status(500);
            return gson.toJson("Error al obtener el clima: " + e.getMessage());
        }
    };

}
