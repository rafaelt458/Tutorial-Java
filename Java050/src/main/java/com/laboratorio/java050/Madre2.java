package com.laboratorio.java050;

public class Madre2 {
    String nombre;

    public Madre2(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public final void mostrar() {
        System.out.println("El nombre es: " + nombre);
    }
}