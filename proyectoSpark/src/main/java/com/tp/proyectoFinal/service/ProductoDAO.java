package com.tp.proyectoFinal.service;

import org.sql2o.Connection;
import com.tp.proyectoFinal.model.Producto;
import java.util.*;

public class ProductoDAO {

    public boolean crear_producto(Producto producto) {
        String insertInto = "INSERT INTO PRODUCTO (nombre_producto, precio) VALUES (:nombre_producto, :precio)";

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertInto)
                    .addParameter("nombre_producto", producto.getNombre_producto())
                    .addParameter("precio", producto.getPrecio())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println("Error al ingresar Producto" + e.getMessage());
            return false;
        }
    }

    public List<Producto> obtenerTodos() {
        String query = "SELECT * FROM PRODUCTO";
        List<Producto> productos;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            productos = con.createQuery(query).executeAndFetch(Producto.class);
            return productos;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }

    public List<Producto> productosPorNombre(String nombre) {
        String query = "SELECT * FROM PRODUCTO WHERE nombre_producto LIKE :nombre";
        List<Producto> productos;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            productos = con.createQuery(query)
                    .addParameter("nombre", "%" + nombre + "%")
                    .executeAndFetch(Producto.class);
            return productos;
        } catch (Exception e) {
            return null;
        }
    }

}
