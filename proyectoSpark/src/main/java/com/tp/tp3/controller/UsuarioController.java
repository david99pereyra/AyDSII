package com.tp.tp3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.tp.tp3.model.Usuario;

import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();
    private Gson gson = new Gson();
    private int idCounter = 0;

    public Route crearUsuario = (Request req, Response res) -> {
        res.type("application/json");
        String nombre = req.queryParams("nombre");
        String email = req.queryParams("email");

        if (nombre == null || email == null) {
            res.status(400);
            return "Faltan parametros 'nombre' o 'email'";
        }

        Usuario usuario = new Usuario(idCounter++, nombre, email);
        usuarios.add(usuario);
        res.status(200);
        return gson.toJson(usuario);
    };

    public Route obtenerUsuario = (Request req, Response res) -> {
        Integer id = Integer.parseInt(req.params(":id"));
        Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getId() == id).findFirst();

        if (req.params("id").isEmpty()) {
            return "Error, es necesario ingresar un id";
        }

        if (usuario.isPresent()) {
            return gson.toJson(usuario.get());
        } else {
            res.status(404);
            return "User not found";
        }
    };

    public Route obtenerUsuarios = (Request req, Response res) -> {
        if (usuarios.isEmpty()) {
            res.status(500);
            return "No hay usuarios registrados";
        }
        return gson.toJson(usuarios);
    };

    public Route actualizarUsuario = (Request req, Response res) -> {
        int id = Integer.parseInt(req.queryParams("id"));
        String nombre = req.queryParams("nombre");
        String email = req.queryParams("email");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.get(i).setNombre(nombre);
                usuarios.get(i).setEmail(email);
                return gson.toJson(usuarios.get(i));
            }
        }
        res.status(404);
        return "User not found";
    };

    public Route eliminarUsuario = (Request req, Response res) -> {
        String nombre = req.queryParams("nombre");
        Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getNombre().equals(nombre)).findFirst();

        if (nombre == null) {
            return "Error, es necesario ingresar un nombre";
        }

        if (usuario.isPresent()) {
            usuarios.remove(usuario.get());

            res.status(200);
            return "Usuario " + nombre + " eliminado";
        } else {
            res.status(404);
            return "User not found";
        }
    };

}
