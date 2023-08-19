package com.laboratorio.java089;

import java.util.Optional;

public class Java089 {

    public static void main(String[] args) {
        Persona p1, p2, p3;
        ListaPersonas lista = new ListaPersonas();
        
        p1 = new Persona("Rafa", 50, "12345");
        p2 = new Persona("María", 41, "67895");
        p3 = new Persona("Juan", 35, "23456");
        
        lista.agregar(p1);
        lista.agregar(p2);
        lista.agregar(p3);
        
        Optional<Persona> resultado1 = lista.buscar("34567");
        if (resultado1.isPresent()) {
            Persona p = resultado1.get();
            System.out.println("Persona: " + p.toString());
        } else {
            System.out.println("(1) La persona buscada no existe");
        }
        
        Optional<Persona> resultado2 = lista.buscar("67895");
        if (resultado2.isEmpty()) {
            System.out.println("(2) La persona buscada no existe");
        } else {
            Persona p = resultado2.get();
            System.out.println("Persona: " + p.toString());
        }
    }
}