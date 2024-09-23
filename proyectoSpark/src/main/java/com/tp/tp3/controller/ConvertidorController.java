package com.tp.tp3.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.tp.tp3.model.Convertidor;
import com.tp.tp3.model.RespuestaConvertidor;

import spark.*;

public class ConvertidorController {

    private Gson gson = new Gson();
    private HttpClient client = HttpClient.newHttpClient();

    public Route getCotizacion = (Request req, Response res) -> {
        String monto = req.params(":monto");
        String tipo = req.params(":tipo");
        int montoInt = Integer.parseInt(monto);
        double compra;
        double venta;

        if (montoInt < 0) {
            return "El monto no puede ser negativo.";
        }

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dolarapi.com/v1/dolares/oficial"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get cotizacion" + response.statusCode());
        }

        Convertidor dolarApi = gson.fromJson(response.body(), Convertidor.class);

        try {
            compra = Double.parseDouble(dolarApi.getCompra());
            venta = Double.parseDouble(dolarApi.getVenta());
        } catch (NumberFormatException e) {
            res.status(500);
            return gson.toJson(new RespuestaConvertidor(tipo, montoInt, 0, "Error al convertir el monto."));
        }

        double resultado;
        String mensaje;
        if (tipo.equals("dolar")) {
            resultado = montoInt * venta;
            mensaje = "Los " + monto + " dólares son " + resultado + " pesos.";
        } else {
            resultado = montoInt / compra;
            mensaje = "Los " + monto + " pesos son " + resultado + " dólares.";
        }

        res.type("application/json");
        return gson.toJson(new RespuestaConvertidor(tipo, montoInt, resultado, mensaje));

    };

}
