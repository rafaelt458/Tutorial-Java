package com.laboratorio.java076;

import java.util.List;

public class Cajero2 implements Runnable {
    private final String nombre;
    private final List<Cliente> cola;

    public Cajero2(String nombre, List<Cliente> cola) {
        this.nombre = nombre;
        this.cola = cola;
    }
    
    @Override
    public void run() {
        while (!cola.isEmpty()) {
            Cliente cliente = cola.remove(0);
            System.out.println("El cajero " + this.nombre + " está atendiendo al cliente: " + cliente.getNumero());
            try {
                Thread.sleep(cliente.getTiempoAtencion() * 1000);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            System.out.println("Ha finalizado la atención del cliente: " + cliente.getNumero() + ". Ha demorado " + cliente.getTiempoAtencion() + " segundos.");
        }
    }    
}