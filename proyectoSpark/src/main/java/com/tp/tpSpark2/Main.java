package com.tp.tpSpark2;

import com.tp.tpSpark2.controller.MateriaPrimaController;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        port(1234);

        post("/materiaPrima", MateriaPrimaController.insert_MP);

        get("/materiaPrima", MateriaPrimaController.selectAll);

        get("/materiaPrima/:nombre", MateriaPrimaController.selectByName);

        put("/materiaPrima/:nombreMP", MateriaPrimaController.update_MP);

        delete("/materiaPrima/:nombreMP", MateriaPrimaController.delete_MP);

    }

}
