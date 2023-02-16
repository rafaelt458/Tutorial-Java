package com.laboratorio.java049;

public class Jugador {
    private final String nombre;
    private int nivel;

    public Jugador(String nombre) {
        this.nombre = nombre;
        nivel = 1;
    }

    public Jugador(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void mostrarJugador() {
        System.out.println("El jugador " + nombre + " está en el nivel " + nivel);
    }
}