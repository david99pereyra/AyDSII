package com.tp.tpSpark.model;

public class Invertidor {
    public String invertido(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }
}
