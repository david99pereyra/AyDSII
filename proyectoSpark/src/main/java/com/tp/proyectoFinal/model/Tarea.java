package com.tp.proyectoFinal.model;

import lombok.Data;

@Data
public class Tarea {
    private int idTarea;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_finalizacion;
    private String prioridad;
    private Estado estado;
    private ProductoXPedido productoxpedido;

    public Tarea(String descripcion, String fecha_inicio, String fecha_finalizacion, String prioridad, Estado estado,
            ProductoXPedido productoxpedido) {
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.productoxpedido = productoxpedido;
    }

    public Tarea() {
    }

}
