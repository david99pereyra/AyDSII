package com.tp.tp3.controller;

import com.google.gson.Gson;
import com.tp.tp3.model.Chiste;
import com.tp.tp3.service.ChisteService;

import spark.Request;
import spark.Response;
import spark.Route;

public class ChisteController {

    private Gson gson = new Gson();

    public Route getChiste = (Request req, Response res) -> {
        Chiste chiste = ChisteService.obtenerChiste();
        res.type("application/json");
        return gson.toJson(chiste);
    };
}
