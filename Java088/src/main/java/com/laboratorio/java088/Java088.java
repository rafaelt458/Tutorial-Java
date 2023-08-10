package com.laboratorio.java088;

import java.util.HashSet;

public class Java088 {

    public static void main(String[] args) {
        HashSet<Persona> personas = new HashSet<>();
        Persona persona1 = new Persona("Juan", "Perez", (short)16, "1234");
        System.out.println("HashCode: " + persona1.hashCode());
        Persona persona2 = new Persona("María", "Valero", (short)26, "6784");
        System.out.println("HashCode: " + persona2.hashCode());
        Persona persona3 = new Persona("José", "Martinez", (short)34, "1487");
        System.out.println("HashCode: " + persona3.hashCode());
        Persona persona4 = new Persona("Juan", "Perez", (short)16, "1234");
        System.out.println("HashCode: " + persona4.hashCode());
        System.out.println("");
        
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        
        for (Persona p : personas) {
            System.out.println(p);
            System.out.println("HashCode: " + p.hashCode());
        }
    }
}