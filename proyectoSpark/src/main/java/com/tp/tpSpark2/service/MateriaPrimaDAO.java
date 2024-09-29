package com.tp.tpSpark2.service;

import java.util.List;

import org.sql2o.Connection;

import com.tp.tpSpark2.model.MateriaPrima;

public class MateriaPrimaDAO implements InterfaceMateriaPrimaDAO {

    @Override
    public List<MateriaPrima> selectAll() {
        String select = "SELECT * FROM MATERIA_PRIMA";
        List<MateriaPrima> res;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(select).executeAndFetch(MateriaPrima.class);
            return res;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }

    }

    @Override
    public MateriaPrima select_MP(String nombre) {
        String selectByName = "SELECT * FROM MATERIA_PRIMA WHERE nombre LIKE :nombre";
        MateriaPrima mp;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            mp = con.createQuery(selectByName)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(MateriaPrima.class);
            return mp;
        } catch (Exception e) {
            return null;
        }

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
    public boolean update_MP(MateriaPrima materiaPrima, String nombreMP) {
        String update = "UPDATE MATERIA_PRIMA SET nombre = :nombre, fecha_vto = :fecha_vto, stock = :stock, unidad = :unidad  WHERE nombre LIKE :nombreMP";
        
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            int result = con.createQuery(update)
                    .addParameter("nombre", materiaPrima.getNombre())
                    .addParameter("fecha_vto", materiaPrima.getFecha_vto())
                    .addParameter("stock", materiaPrima.getStock())
                    .addParameter("unidad", materiaPrima.getUnidad())
                    .addParameter("nombreMP", "%" + nombreMP + "%")
                    .executeUpdate()
                    .getResult();

            return result > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete_MP(String nombre) {

        String delete = "DELETE FROM MATERIA_PRIMA WHERE nombre LIKE :nombre";

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            int result = con.createQuery(delete)
                    .addParameter("nombre", "%" + nombre + "%")
                    .executeUpdate()
                    .getResult();
            return result > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
