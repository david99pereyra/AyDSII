package com.tp.tpSpark2.controller;

import java.util.List;

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
        res.type("application/json");
        String nombre = req.queryParams("nombre");
        String fecha_vto = req.queryParams("fecha_vto");
        int stock = Integer.parseInt(req.queryParams("stock"));
        String unidad = req.queryParams("unidad");

        MateriaPrima mp = new MateriaPrima(nombre, fecha_vto, stock, unidad);
        boolean resp = mpDAO.insert_MP(mp);
        if (resp) {
            return gson.toJson(mp);
        } else {
            return "La informacion no ha sido ingresada con exito";
        }
    };

    public Route selectAll = (Request req, Response res) -> {
        res.type("application/json");
        try {
            MateriaPrimaDAO mp = new MateriaPrimaDAO();
            List<MateriaPrima> response = mp.selectAll();
            res.status(200);
            return gson.toJson(response);
        } catch (Exception e) {
            res.status(500);
            return gson.toJson("Error al intentar obtener toda la Materia Prima " + e.getMessage());
        }
    };

    public Route selectByName = (Request req, Response res) -> {
        res.type("application/json");
        String nombre = req.params(":nombre");
        try {
            MateriaPrimaDAO mp = new MateriaPrimaDAO();
            MateriaPrima response = mp.select_MP(nombre);
            res.status(200);
            return gson.toJson(response);
        } catch (Exception e) {
            res.status(500);
            return gson.toJson("Error al intentar obtener toda la Materia Prima " + e.getMessage());
        }
    };

    public Route update_MP = (Request req, Response res) -> {
        res.type("application/json");
        String nombreMP = req.params(":nombreMP");
        String nombre = req.queryParams("nombre");
        String fecha_vto = req.queryParams("fecha_vto");
        int stock = Integer.parseInt(req.queryParams("stock"));
        String unidad = req.queryParams("unidad");

        MateriaPrima mp = new MateriaPrima(nombre, fecha_vto, stock, unidad);
        
        if (mpDAO.update_MP(mp, nombreMP)) {
            return gson.toJson(mp);
        } else {
            return "No existe esa Materia Prima";
        }
    };

    public Route delete_MP = (Request req, Response res) -> {
        res.type("application/json");
        String nombreMP = req.params(":nombreMP");

        boolean resp = mpDAO.delete_MP(nombreMP);
        if (resp) {
            return gson.toJson("El producto " + nombreMP.toUpperCase() + " fue eliminado con exito");
        } else {
            return "No existe esa Materia Prima";
        }
    };

}
