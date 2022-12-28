package com.laboratorio.java044;

import com.laboratorio.java044.animales.Animal;
import com.laboratorio.java044.animales.Gato;
import com.laboratorio.java044.animales.Perro;

public class Polimorfismo {

    public static void main(String[] args) {
        Animal animal;
        
        animal = new Animal("Oso", "Gordo", 5);
        System.out.println("Con la clase animal.");
        animal.sonido();
        System.out.println("");
        
        Animal perro;
        
        perro = new Perro("Ritintin", 3, "Pastor");
        System.out.println("Con la clase perro.");
        perro.sonido();
        System.out.println("");

        Animal gato;
        
        gato = new Gato("Capitán", 6, "Negro");
        System.out.println("Con la clase gato.");
        gato.sonido();
    }
}
