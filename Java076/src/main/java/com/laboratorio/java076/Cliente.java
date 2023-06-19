package com.laboratorio.java076;

public class Cliente {
    private int numero;
    private int tiempoAtencion;

    public Cliente(int numero) {
        this.numero = numero;
        this.tiempoAtencion = (int)(Math.random() * 10 + 1);
    }

    public int getNumero() {
        return numero;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}