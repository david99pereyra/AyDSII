package com.tp.spark.model;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String nombre;
    private String email;

    public Usuario(){}

    public Usuario(int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
}
