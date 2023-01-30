package com.laboratorio.java048.animales;

public class Animal {
    protected String tipo;
    protected String nombre;
    protected int edad;

    public Animal(String t, String n, int e) {
        this.tipo = t;
        this.nombre = n;
        this.edad = e;
    }

    public void comer() {
        System.out.println(nombre + " de " + edad + " años, está comiendo.");
    }

    public void caminar() {
        System.out.println(nombre + " de " + edad + " años, está caminando.");
    }

    public void dormir() {
        System.out.println(nombre + " de " + edad + " años, está durmiendo.");
    }
}