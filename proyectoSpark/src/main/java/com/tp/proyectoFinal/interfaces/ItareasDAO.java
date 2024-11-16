package com.tp.proyectoFinal.interfaces;

import com.tp.proyectoFinal.model.Tarea;
import com.tp.proyectoFinal.model.TareaDetalle;

import java.util.List;

public interface ItareasDAO {

    public boolean crear_tarea(Tarea tarea);

    public List<TareaDetalle> obtener_tareas();

}