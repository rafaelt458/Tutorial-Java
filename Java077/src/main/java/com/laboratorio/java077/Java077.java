package com.laboratorio.java077;

import java.util.concurrent.CountDownLatch;

public class Java077 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Cola cola = new Cola();
        LlegadaClientes llegada = new LlegadaClientes(cola, latch);
        Cajero cajero1 = new Cajero("Carlos", cola, latch, llegada);
        Cajero cajero2 = new Cajero("Luis", cola, latch, llegada);

        long tiempoInicial = System.currentTimeMillis();
        
        llegada.start();
        cajero1.start();
        cajero2.start();
        
        try {
            latch.await();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        long tiempoFinal = System.currentTimeMillis();
        
        System.out.println("Tiempo de ejecución: " + (tiempoFinal - tiempoInicial));
        System.out.println("Finaliza el programa");
    }
}