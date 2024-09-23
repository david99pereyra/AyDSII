package com.tp.tpSpark.controller;

import com.tp.tpSpark.model.EsPrimo;

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
