package com.tp.proyectoFinal.dao;

import java.util.List;

import org.sql2o.Connection;

import com.tp.proyectoFinal.connection.Sql2oDAO;
import com.tp.proyectoFinal.interfaces.ItareasDAO;
import com.tp.proyectoFinal.model.Tarea;
import com.tp.proyectoFinal.model.TareaDetalle;

public class TareasDAO implements ItareasDAO {

    @Override
    public boolean crear_tarea(Tarea tarea) {

        String query = "INSERT INTO tarea (descripcion, fecha_inicio, fecha_finalizacion, prioridad, id_Estado, id_productoxpedido) VALUES (:descripcion, :fecha_inicio, :fecha_finalizacion, :prioridad, :id_Estado, :id_productoxpedido)";

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(query).bind(tarea)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear tarea" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<TareaDetalle> obtener_tareas() {
        String query = """
                    SELECT
                        c.nombre_cliente AS cliente,
                        pd.nombre_producto AS producto,
                        t.descripcion, t.fecha_inicio, t.fecha_finalizacion, t.prioridad,
                        e.descripcion_estado AS estado
                    FROM
                        tarea t
                    INNER JOIN productoxpedido pp ON t.id_productoxpedido = pp.id_productoxpedido
                    INNER JOIN pedido p ON pp.id_Pedido = p.id_Pedido
                    INNER JOIN cliente c ON c.id_Cliente = p.id_Cliente
                    INNER JOIN producto pd ON pd.id_Producto = pp.id_Producto
                    INNER JOIN estado e ON e.id_Estado = t.id_Estado
                """;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            return con.createQuery(query).executeAndFetch(TareaDetalle.class);
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
