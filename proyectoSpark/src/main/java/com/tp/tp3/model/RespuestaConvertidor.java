package com.tp.spark.model;

import lombok.Data;

@Data
public class RespuestaConvertidor {

    private String tipo;
    private double monto;
    private double resultado;
    private String mensaje;

    public RespuestaConvertidor(String tipo, double monto, double resultado, String mensaje) {
        this.tipo = tipo;
        this.monto = monto;
        this.resultado = resultado;
        this.mensaje = mensaje;
    }
}
