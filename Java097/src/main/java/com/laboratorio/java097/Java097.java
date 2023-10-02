package com.laboratorio.java097;

import com.laboratorio.java097.eventos.ListaPeticiones;
import com.laboratorio.java097.peticion.PeticionCurrencies;
import com.laboratorio.java097.peticion.PeticionLatest;

public class Java097 {
    public static void main(String[] args) {
        ListaPeticiones peticiones = new ListaPeticiones();
        boolean seguir = true;
        PeticionLatest pl = new PeticionLatest(peticiones);
        PeticionCurrencies pc = new PeticionCurrencies(peticiones);
        
        Thread hilo = new Thread(peticiones);
        hilo.start();
        
        pl.add(1);
        pc.add(2);
        pl.add(3);
        pl.add(4);
        pc.add(5);
        pc.add(6);
        
        int ciclos = 0;
        do {
            if (peticiones.getListSize() <= 0) {
                seguir = false;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            
            ciclos++;
            System.out.println("[APP] Ciclo: " + ciclos);
        } while (seguir);
        
        peticiones.detener();
        try {
            System.out.println("[APP] Esperando finalización del hilo");
            hilo.join();
            System.out.println("[APP] Finalizando programa...");
        } catch (InterruptedException ex) {
        }
    }
}