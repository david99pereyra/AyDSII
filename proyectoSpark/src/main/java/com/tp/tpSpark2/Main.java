package com.tp.tpSpark2;

import com.tp.tpSpark2.controller.MateriaPrimaController;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        port(1234);
        MateriaPrimaController mp = new MateriaPrimaController();

        post("/materiaPrima", mp.insert_MP);

        get("/materiaPrima", mp.selectAll);

        get("/materiaPrima/:nombre", mp.selectByName);

        put("/materiaPrima/:nombreMP", mp.update_MP);

        delete("/materiaPrima/:nombreMP", mp.delete_MP);

    }

}
