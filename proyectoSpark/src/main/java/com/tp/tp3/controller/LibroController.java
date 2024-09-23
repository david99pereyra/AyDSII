package com.tp.tp3.controller;

import com.google.gson.Gson;
import com.tp.tp3.model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import spark.Request;
import spark.Response;
import spark.Route;

public class LibroController {

    private List<Libro> libros = new ArrayList<>();
    private Gson gson = new Gson();
    private int idCounter = 0;

    public Route agregarLibro = (Request req, Response res) -> {
        res.type("application/json");
        String nombre = req.queryParams("nombre");
        String autor = req.queryParams("autor");

        if (nombre == null || autor == null) {
            res.status(400);
            return "Faltan parametros 'nombre' o 'autor'";
        }

        Libro libro = new Libro(idCounter++, nombre, autor);
        libros.add(libro);

        res.status(200);
        return gson.toJson(libro);
    };

    public Route obtenerLibro = (Request req, Response res) -> {
        Integer id = Integer.parseInt(req.params(":id"));
        Optional<Libro> libro = libros.stream().filter(u -> u.getId() == id).findFirst();

        if (req.params("id").isEmpty()) {
            return "Error, es necesario ingresar un id";
        }

        if (libro.isPresent()) {
            return gson.toJson(libro.get());
        } else {
            res.status(404);
            return "User not found";
        }
    };
}
