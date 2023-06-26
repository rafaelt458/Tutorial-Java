package com.laboratorio.java077;

public class Cliente {
    private int numero;
    private int tiempoAtencion;

    public Cliente(int numero) {
        this.numero = numero;
        this.tiempoAtencion = (int)(Math.random() * 5 + 1);
    }

    public int getNumero() {
        return numero;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}