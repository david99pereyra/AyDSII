package com.tp.tp3.controller;

import com.tp.tp3.model.EsPrimo;

import spark.Request;
import spark.Response;
import spark.Route;

public class EsPrimoController {
    public Route primo = (Request req, Response res) -> {
        int numero = Integer.parseInt(req.params(":numero"));
        EsPrimo primo = new EsPrimo();
        if (!primo.primazo(numero)) {
            return "El numero no es primo";
        }
        return "El numero es primo";
    };
}
