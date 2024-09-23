package com.tp.tpSpark2.service;

import java.util.List;

import org.sql2o.Connection;

import com.tp.tpSpark2.model.MateriaPrima;

public class MateriaPrimaDAO implements InterfaceMateriaPrimaDAO {

    @Override
    public List<MateriaPrima> selectAll() {
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    public MateriaPrima select_MP(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'select_MP'");
    }

    @Override
    public boolean insert_MP(MateriaPrima materiaPrima) {
        String insertInto = "INSERT INTO MATERIA_PRIMA (nombre, fecha_vto, stock, unidad) VALUES (:nombre, :fecha_vto, :stock, :unidad)";

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertInto)
                    .addParameter("nombre", materiaPrima.getNombre())
                    .addParameter("fecha_vto", materiaPrima.getFecha_vto())
                    .addParameter("stock", materiaPrima.getStock())
                    .addParameter("unidad", materiaPrima.getUnidad())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println("Error al ingresar materia prima" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update_MP(MateriaPrima materiaPrima) {
        throw new UnsupportedOperationException("Unimplemented method 'update_MP'");
    }

    @Override
    public boolean delete_MP(MateriaPrima materiaPrima) {
        throw new UnsupportedOperationException("Unimplemented method 'delete_MP'");
    }

}
