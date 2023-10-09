package com.laboratorio.java099;

import com.laboratorio.java099.eventos.ListaPeticiones;
import com.laboratorio.java099.peticion.PeticionCurrencies;
import com.laboratorio.java099.peticion.PeticionLatest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Java099 {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Java099.class);
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
                logger.error("Error: " + ex.getMessage());
            }
            
            ciclos++;
            logger.info("[APP] Ciclo: " + ciclos);
        } while (seguir);
        
        peticiones.detener();
        try {
            logger.info("[APP] Esperando finalización del hilo");
            hilo.join();
            logger.info("[APP] Finalizando programa...");
        } catch (InterruptedException ex) {
            logger.error("Error: " + ex.getMessage());
        }
    }
}