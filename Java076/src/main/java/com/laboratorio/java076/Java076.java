package com.laboratorio.java076;

import java.util.ArrayList;
import java.util.List;

public class Java076 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1);
        Cliente cliente2 = new Cliente(2);
        List<Cliente> cola = new ArrayList<>();
        Cajero1 cajero1 = new Cajero1("Carlos", cola);
        Cajero2 cajero2 = new Cajero2("Luis", cola);

        // long tiempoInicial = System.currentTimeMillis();
        
        cola.add(cliente1);
        cola.add(cliente2);
        cajero1.start();
        cajero2.run();
        
        // long tiempoFinal = System.currentTimeMillis();
        
        // System.out.println("Tiempo de ejecución: " + (tiempoFinal - tiempoInicial));
        System.out.println("Finaliza el programa");
    }
}