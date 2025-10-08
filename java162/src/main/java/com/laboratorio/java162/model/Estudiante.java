package com.laboratorio.java162.model;

public class Estudiante extends Persona {
    public Estudiante(String nombre) {
        String nombreEstudiante = "Est. " + nombre;
        super(nombreEstudiante);
    }
}