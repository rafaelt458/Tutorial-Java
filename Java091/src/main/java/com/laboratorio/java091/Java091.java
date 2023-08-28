package com.laboratorio.java091;

import java.util.TreeSet;

public class Java091 {

    public static void main(String[] args) {
        TreeSet<String> arbol1 = new TreeSet<>();
        
        arbol1.add("uno");
        arbol1.add("dos");
        arbol1.add("tres");
        
        for (String str : arbol1) {
            System.out.println("Contenido: " + str);
        }
        
        TreeSet<Persona> arbol2 = new TreeSet<>();
        Persona p1 = new Persona(1, "43567", "Pepito");
        Persona p2 = new Persona(2, "35675", "Juan");
        Persona p3 = new Persona(3, "13597", "Luis");
        
        arbol2.add(p1);
        arbol2.add(p2);
        arbol2.add(p3);
        
        System.out.println("");
        for (Persona p : arbol2) {
            System.out.println(p.toString());
        }
        
        ComparadorPersona comparadorPersona = new ComparadorPersona();
        TreeSet<Persona> arbol3 = new TreeSet<>(comparadorPersona);
        arbol3.add(p1);
        arbol3.add(p2);
        arbol3.add(p3);
        
        System.out.println("");
        for (Persona p : arbol3) {
            System.out.println(p.toString());
        }
    }
}