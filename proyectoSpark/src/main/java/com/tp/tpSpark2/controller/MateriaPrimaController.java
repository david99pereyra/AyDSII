package com.tp.tpSpark2.controller;

import com.google.gson.Gson;
import com.tp.tpSpark2.model.MateriaPrima;
import com.tp.tpSpark2.service.MateriaPrimaDAO;

import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaController {

    private MateriaPrimaDAO mpDAO = new MateriaPrimaDAO();
    private Gson gson = new Gson();
    public Route insert_MP = (Request req, Response res) -> {
        String nombre = req.queryParams("nombre");
        String fecha_vto = req.queryParams("fecha_vto");
        int stock = Integer.parseInt(req.queryParams("stock"));
        String unidad = req.queryParams("unidad");

        MateriaPrima mp = new MateriaPrima(nombre, fecha_vto, stock, unidad);

        if (mpDAO.insert_MP(mp)) {
            return gson.toJson(mp);

        } else {
            return "La informacion no ha sido ingresada con exito";
        }

    };
}
