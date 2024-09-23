package com.tp.tpSpark.model;

import lombok.Data;

@Data
public class Libro {
    private int id;
    private String nombre;
    private String autor;

    public Libro(int id, String nombre, String autor){
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }
}
