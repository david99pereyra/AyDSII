package com.tp.proyectoFinal.model;

import lombok.Data;

@Data
public class TareaDetalle {
    private String descripcion;
    private String fecha_inicio;
    private String fecha_finalizacion;
    private String prioridad;
    private String estado;
    private String cliente;
    private String producto;

    public TareaDetalle(String descripcion, String fecha_inicio, String fecha_finalizacion,
            String prioridad, String estado, String cliente, String producto) {
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.cliente = cliente;
        this.producto = producto;
    }

    public TareaDetalle() {
    }
}
