package com.tp.tp3.controller;

import com.tp.tp3.model.EsPar;

import spark.Request;
import spark.Response;
import spark.Route;

public class EsParController {
    public Route esPar = (Request req, Response res) -> {
        int numero = Integer.parseInt(req.params(":numero"));
        EsPar par = new EsPar();
        if (par.parcito(numero)) {
            return "Es par";
        }
        return "Es impar";
    };
}
