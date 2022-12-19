package com.laboratorio.java043;

import com.laboratorio.java043.animales.Animal;
import com.laboratorio.java043.animales.Gato;
import com.laboratorio.java043.animales.Perro;

public class Herencia {

    public static void main(String[] args) {
        Animal animal;
        
        animal = new Animal("Oso", "Gordo", 5);
        animal.comer();
        
        Perro perro;
        
        perro = new Perro("Ritintin", 3, "Pastor");
        perro.moverCola();
        
        Gato gato;
        
        gato = new Gato("Capitán", 6, "Negro");
        gato.cazar();
        gato.comer();
    }
}
