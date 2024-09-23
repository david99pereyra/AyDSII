package com.tp.tp3.controller;

import spark.Route;

import com.tp.tp3.model.CelsiusFahrenheit;

import spark.Request;
import spark.Response;

public class CelsiusFahrenheitController {
    public Route convetir = (Request req, Response res) -> {
        CelsiusFahrenheit cf = new CelsiusFahrenheit();
        float celsius = (float) (Integer.parseInt(req.params(":celsius")));
        float faherenheit = cf.convertidor(celsius);
        return "Los grados Celsius " + celsius + " en Faherenheit son: " + faherenheit;

    };
}
