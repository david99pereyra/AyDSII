package com.tp.proyectoFinal;

import static spark.Spark.*;

import com.tp.proyectoFinal.controller.ProductoController;

public class Main {

    public static void main(String[] args) {
        port(1234);

        post("/producto", ProductoController.crear_producto);
        get("/producto", ProductoController.obtener_productos);
        get("/producto/:nombre", ProductoController.productosPorNombre);
    }

}
