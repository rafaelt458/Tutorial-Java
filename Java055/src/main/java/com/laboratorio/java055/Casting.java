package com.laboratorio.java055;

import com.laboratorio.java055.animales.Animal;
import com.laboratorio.java055.animales.Gato;
import com.laboratorio.java055.animales.Perro;

public class Casting {

    public static void main(String[] args) {
        Animal animal[] = new Animal[5];
        
        animal[0] = new Animal("Caballo", "Relámpago", 5);
        animal[1] = new Perro("Ritintin", 3, "Pastor");
        animal[2] = new Gato("Capitán", 6, "Negro");
        animal[3] = new Animal("Vaca", "Lola", 7);
        animal[4] = new Animal("Conejo", "Orejón", 2);
        
        
        animal[0].comer();
        
        Perro perro = (Perro)animal[1];
        perro.moverCola();
        
        Gato gato = (Gato)animal[2];
        gato.cazar();
        gato.comer();
    }
}