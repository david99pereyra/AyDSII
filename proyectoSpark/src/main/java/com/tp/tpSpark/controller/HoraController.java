package com.tp.tpSpark.controller;

import com.tp.tpSpark.model.Hora;

import spark.Request;
import spark.Response;
import spark.Route;

public class HoraController {
    public Route segundoAHora = (Request req, Response res) -> {
        Hora h = new Hora();
        int segundos = Integer.parseInt(req.params(":segundo"));
        return h.segundosAHora(segundos);
    };
}
