package com.tp.proyectoFinal.controller;

import com.google.gson.Gson;
import com.tp.proyectoFinal.dao.ProductoDAO;
import com.tp.proyectoFinal.model.Producto;

import java.util.*;

import spark.Request;
import spark.Response;
import spark.Route;

public class ProductoController {

    private static ProductoDAO prDAO = new ProductoDAO();
    private static Gson gson = new Gson();

    public static Route crear_producto = (Request req, Response res) -> {
        res.type("application/json");
        String nombre_producto = req.queryParams("nombre_producto");
        int precio = Integer.parseInt(req.queryParams("precio"));
        int cant_porciones = Integer.parseInt(req.queryParams("cant_porciones"));

        if (nombre_producto == null || req.queryParams("precio") == null || req.queryParams("cant_porciones") == null) {
            res.status(400);
            return gson.toJson("Todos los campos son obligatorios");
        }

        Producto producto = new Producto(nombre_producto, precio, cant_porciones);
        boolean resp = prDAO.crear_producto(producto);
        if (resp) {
            return gson.toJson(producto);
        } else {
            return gson.toJson("La informacion NO se ha cargado con exito");
        }
    };

    public static Route obtener_productos = (Request req, Response res) -> {
        res.type("application/json");
        try {
            List<Producto> productos = prDAO.obtenerTodos();
            res.status(200);
            return gson.toJson(productos);
        } catch (Exception e) {
            res.status(500);
            return gson.toJson("Error al obtener los productos, la concha de tu madre");
        }
    };

    public static Route productosPorNombre = (Request req, Response res) -> {
        res.type("application/json");
        String nombre = req.params(":nombre");
        System.out.println(nombre);
        try {
            List<Producto> productos = prDAO.productosPorNombre(nombre);
            res.status(200);
            return gson.toJson(productos);
        } catch (Exception e) {
            res.status(500);
            return gson.toJson("Error al obtener los productos, la concha de tu madre");
        }
    };
}
