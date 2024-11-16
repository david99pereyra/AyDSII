package com.tp.proyectoFinal.model;

import lombok.Data;

@Data
public class TareaDetalle {
    private int idTarea;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_finalizacion;
    private String prioridad;
    private int id_Estado;
    private int id_productoxpedido;
    private String cliente;
    private String producto;

    public TareaDetalle(int idTarea, String descripcion, String fecha_inicio, String fecha_finalizacion, String prioridad, int id_Estado, int id_productoxpedido, String cliente, String producto) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.prioridad = prioridad;
        this.id_Estado = id_Estado;
        this.id_productoxpedido = id_productoxpedido;
        this.cliente = cliente;
        this.producto = producto;
    }

    public TareaDetalle() {
    }
}
