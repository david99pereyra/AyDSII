package com.tp.proyectoFinal.model;

import lombok.Data;

@Data
public class Producto {
    private int id_Producto;
    private String nombre_producto;
    private float precio_vta;
    private int cant_porciones;
    private String descripcion;

    public Producto(String nombre_producto, float precio_vta, int cant_porciones, String descripcion) {
        this.nombre_producto = nombre_producto;
        this.precio_vta = precio_vta;
        this.cant_porciones = cant_porciones;
        this.descripcion = descripcion;
    }

    public Producto() {
    }
}
