package com.tp.tp3.controller;

import com.tp.tp3.model.Invertidor;

import spark.Request;
import spark.Response;
import spark.Route;

public class InvertirController {
    public Route invertir = (Request req, Response res) -> {
        Invertidor inv = new Invertidor();
        String cadena = req.params(":cadena");
        return cadena + " invertida " + inv.invertido(cadena);
    };
}
