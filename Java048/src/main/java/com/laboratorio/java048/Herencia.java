package com.laboratorio.java048;

import com.laboratorio.java048.animales.Animal;
import com.laboratorio.java048.animales.Gato;
import com.laboratorio.java048.animales.Perro;

public class Herencia {

    public static void main(String[] args) {
        Animal animal;
        
        animal = new Animal("Oso", "Gordo", 5);
        animal.comer();
        
        Perro perro;
        
        perro = new Perro("Ritintin", 3, "Pastor");
        perro.moverCola();
        perro.comportamiento();
        perro.claseDeAnimal();
        
        Gato gato;
        
        gato = new Gato("Capitán", 6, "Negro");
        gato.cazar();
        gato.comer();
        gato.comportamiento();
        gato.claseDeAnimal();
    }
}
