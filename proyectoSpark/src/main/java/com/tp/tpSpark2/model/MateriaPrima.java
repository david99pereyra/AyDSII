package com.tp.tpSpark2.model;

import lombok.Data;

@Data
public class MateriaPrima {
    private int id;
    private String nombre;
    private String fecha_vto;
    private int stock;
    private String unidad;

    public MateriaPrima(String nombre, String fecha_vto, int stock, String unidad) {
        this.nombre = nombre;
        this.fecha_vto = fecha_vto;
        this.stock = stock;
        this.unidad = unidad;
    }

    public MateriaPrima() {
    }

}
