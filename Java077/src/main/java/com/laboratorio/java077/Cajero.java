package com.laboratorio.java077;

import java.util.concurrent.CountDownLatch;

public class Cajero extends Thread {
    private final String nombre;
    private final Cola cola;
    private final CountDownLatch latch;
    private final LlegadaClientes llegada;

    public Cajero(String nombre, Cola cola, CountDownLatch latch, LlegadaClientes llegada) {
        this.nombre = nombre;
        this.cola = cola;
        this.latch = latch;
        this.llegada = llegada;
    }
    
    @Override
    public void run() {
        cola.esperarApertura(nombre);
        
        while (!cola.vacia()) {
            Cliente cliente = cola.eliminarCliente();
            System.out.println("El cajero " + this.nombre + " está atendiendo al cliente: " + cliente.getNumero());
            try {
                Thread.sleep(cliente.getTiempoAtencion() * 1000);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            System.out.println("Ha finalizado la atención del cliente: " + cliente.getNumero() + ". Ha demorado " + cliente.getTiempoAtencion() + " segundos.");
        }
        
        llegada.detener();
        
        // Avisa que el hilo ha terminado
        latch.countDown();
    }
}