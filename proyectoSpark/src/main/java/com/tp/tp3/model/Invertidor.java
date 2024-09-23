package com.tp.tp3.model;

public class Invertidor {
    public String invertido(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }
}
