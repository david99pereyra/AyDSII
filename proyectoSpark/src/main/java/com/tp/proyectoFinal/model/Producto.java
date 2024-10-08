package com.tp.proyectoFinal.model;

import lombok.Data;

@Data
public class Producto {
    private int id_Producto;
    private String nombre_producto;
    private float precio;

    public Producto(String nombre_producto, float precio) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
    }

    public Producto() {
    }
}
