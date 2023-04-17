package com.laboratorio.java058;

/**
 *
 * @author Rafael
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String identificacion;

    public Persona(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
    }
    
    public void escribir() {
        System.out.println("Persona: " + nombre + " " + apellido + " - " + identificacion);
    }
}