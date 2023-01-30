package com.laboratorio.java048.animales;

public class Perro extends Animal implements Mascota, Canino {
    protected String raza;

    public Perro(String n, int e, String r) {
        super("Perro", n, e);
        this.raza = r;
    }

    public void moverCola() {
        System.out.println(nombre + " de " + edad + " años, está moviendo la cola.");
    }

    @Override
    public void comportamiento() {
        System.out.println("Soy un perro y me comporto como una mascota");
    }

    @Override
    public void claseDeAnimal() {
        System.out.println("Soy un perro y soy un canino");
    }
}