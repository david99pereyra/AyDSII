
package com.tp.tp3.model;

public class Hora {

    public String segundosAHora(int segundo) {
        int horas = segundo / 3600; // 1 hora = 3600 segundos
        int minutos = (segundo % 3600) / 60; // 1 minuto = 60 segundos
        int segundos = segundo % 60;

        return horas + ":" + minutos + ":" + segundos;
    }
}