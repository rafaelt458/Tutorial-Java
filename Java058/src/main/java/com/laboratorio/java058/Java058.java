package com.laboratorio.java058;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class Java058 {

    public static void insertarMasivo(List lista, int nElem) {
        int i;
        Persona persona;
        String nombre, apellido, identificacion;
        long tiempo1, tiempo2, diferencia;

        tiempo1 = System.currentTimeMillis();

        for (i = 0; i < nElem; i++) {
            nombre = "nombre" + (i + 1);
            apellido = "apellido" + (i + 1);
            identificacion = "identificacion" + (i + 1);
            persona = new Persona(nombre, apellido, identificacion);
            lista.add(persona);
        }

        tiempo2 = System.currentTimeMillis();

        diferencia = tiempo2 - tiempo1;
        System.out.println("Tiempo insersión masiva: " + diferencia);
    }

    public static void consulta(List lista, int nElem) {
        long tiempo1, tiempo2, diferencia;

        tiempo1 = System.currentTimeMillis();

        Persona persona = (Persona) lista.get(nElem);
        persona.escribir();

        tiempo2 = System.currentTimeMillis();

        diferencia = tiempo2 - tiempo1;
        System.out.println("Tiempo consulta: " + diferencia);
    }

    public static void insertar(List lista, int nElem, Persona persona) {
        long tiempo1, tiempo2, diferencia;

        tiempo1 = System.currentTimeMillis();

        lista.add(nElem, persona);

        tiempo2 = System.currentTimeMillis();

        diferencia = tiempo2 - tiempo1;
        System.out.println("Tiempo insersión: " + diferencia);
    }

    public static void eliminar(List lista, int nElem) {
        long tiempo1, tiempo2, diferencia;

        tiempo1 = System.currentTimeMillis();

        lista.remove(nElem);

        tiempo2 = System.currentTimeMillis();

        diferencia = tiempo2 - tiempo1;
        System.out.println("Tiempo eliminación: " + diferencia);
    }

    public static void listado1(List lista) {
        Persona persona;

        for (int i = 0; i < lista.size(); i++) {
            persona = (Persona)lista.get(i);
            persona.escribir();
        }
    }
    
    public static void listado2(List<Persona> lista) {
        for (Persona persona : lista) {
            persona.escribir();
        }
    }
    
    public static void listado3(List<Persona> lista) {
        Iterator<Persona> iterator = lista.iterator();
        Persona persona;
        
        while (iterator.hasNext()) {
            persona = iterator.next();
            persona.escribir();
        }
        
    }

    public static void main(String[] args) {
        List<Persona> lista1 = new ArrayList<>(10);
        insertarMasivo(lista1, 10);

        /*        List<Persona> lista2 = new LinkedList<>();
        insertarMasivo(lista2, 1000000);
        
        consulta(lista1, 500000);
        consulta(lista2, 500000);
        
        Persona p1 = new Persona("n1", "a1", "i1");
        insertar(lista1, 500000, p1);
        Persona p2 = new Persona("n2", "a2", "i2");
        insertar(lista2, 500000, p2);
        
        eliminar(lista1, 500000);
        eliminar(lista2, 500000); */
        
        // listado1(lista1);
        // listado2(lista1);
        listado3(lista1);
    }
}