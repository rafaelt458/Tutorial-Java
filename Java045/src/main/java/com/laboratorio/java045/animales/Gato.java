package com.laboratorio.java045.animales;

public class Gato extends Animal {

    protected String color;

    public Gato(String n, int e, String c) {
        super("Gato", n, e);
        this.color = c;
    }

    public void cazar() {
        System.out.println(nombre + " de " + edad + " años, está cazando.");
    }
    
    @Override
    public void sonido() {
        System.out.println("El gato maulla.");
    }
}