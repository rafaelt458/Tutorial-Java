package com.laboratorio.java090;

public class Java090 {

    public static void main(String[] args) {
        Persona persona1, persona2;
        
        persona1 = new Persona("Pedro", "Lopez", 25, "Madrid", true);
        persona2 = new Persona("Juan", "Cardillo", 32, "Valencia", true);
        
        System.out.println("Persona 1: " + persona1.toString());
        System.out.println("Persona 2: " + persona2.toString());
        
        System.out.println("Datos persona 1: " + persona1.nombre() + " - " + persona1.apellido() + " - " + persona1.ciudad());
        
        if (persona1.equals(persona2)) {
            System.out.println("Se trata de la misma persona");
        } else {
            System.out.println("Son personas diferentes");
        }
        
        System.out.println("Nombre completo persona 1: " + persona1.nombreCompleto());
        
        Persona persona3 = new Persona("María", "Castaño", 41, "Barcelona");
        System.out.println("Persona 3: " + persona3.toString());
    }
}
