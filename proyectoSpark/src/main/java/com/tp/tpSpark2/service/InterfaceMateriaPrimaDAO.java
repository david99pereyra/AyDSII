package com.tp.tpSpark2.service;

import java.util.List;

import com.tp.tpSpark2.model.MateriaPrima;

public interface InterfaceMateriaPrimaDAO {

    public List<MateriaPrima> selectAll();

    public MateriaPrima select_MP(int id);

    public boolean insert_MP(MateriaPrima materiaPrima);

    public boolean update_MP(MateriaPrima materiaPrima);

    public boolean delete_MP(MateriaPrima materiaPrima);

}