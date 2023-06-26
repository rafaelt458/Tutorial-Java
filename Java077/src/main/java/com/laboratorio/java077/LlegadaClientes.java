package com.laboratorio.java077;

import java.util.concurrent.CountDownLatch;

public class LlegadaClientes extends Thread {
    private final Cola cola;
    private final CountDownLatch latch;
    private volatile boolean finalizar;
    private int numCliente;

    public LlegadaClientes(Cola cola, CountDownLatch latch) {
        this.cola = cola;
        this.latch = latch;
        this.finalizar = false;
        this.numCliente = 0;
    }
    
    @Override
    public void run() {
        int tiempoLlegada;
        Cliente cliente;
        
        while (!finalizar) {
            tiempoLlegada = (int)(Math.random() * 5 + 1);
            try {
                Thread.sleep(tiempoLlegada * 1000);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            numCliente++;
            System.out.println("Llegó el cliente " + numCliente + " después de " + tiempoLlegada + " segundos.");
            cliente = new Cliente(numCliente);
            cola.agregarCliente(cliente);
        }
        
        // Avisa que el hilo ha terminado
        latch.countDown();
    }
    
    public synchronized void detener() {
        if (!finalizar) {
            System.out.println("Se cierra la tienda.");
            finalizar = true;
        } else {
            System.out.println("La tienda ya está cerrada.");
        }
    }
}