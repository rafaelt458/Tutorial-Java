package com.laboratorio.java048.animales;

public class Gato extends Animal implements Mascota, Felino {
    protected String color;

    public Gato(String n, int e, String c) {
        super("Gato", n, e);
        this.color = c;
    }

    public void cazar() {
        System.out.println(nombre + " de " + edad + " años, está cazando.");
    }

    @Override
    public void comportamiento() {
        System.out.println("Soy un gato y me comporto como una mascota");
    }

    @Override
    public void claseDeAnimal() {
        System.out.println("Soy un gato y soy un felino");
    }
}