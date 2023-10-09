package com.laboratorio.java099.eventos;

import com.laboratorio.java099.api.FrankfurterAPI;
import com.laboratorio.java099.peticion.PeticionAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListaPeticiones implements Runnable {
    Logger logger = LogManager.getLogger(ListaPeticiones.class);
    private volatile boolean seguir;
    private final FrankfurterAPI frankfurterAPI;
    private final List<PeticionAPI> peticiones;
    private final List listeners;

    public ListaPeticiones() {
        seguir = true;
        frankfurterAPI = new FrankfurterAPI("https://api.frankfurter.app/");
        peticiones = new ArrayList<>();
        listeners = new ArrayList();
    }
    
    public synchronized void detener() {
        seguir = false;
    }
    
    public synchronized void add(PeticionAPI peticion) {
        peticiones.add(peticion);
        logger.info("[HILO] Se ha agregado la petición Id: " + peticion.getId());
    }
    
    public int getListSize() {
        return peticiones.size();
    }
    
    // Agregar la lista de eventos a manejar
    public void addEventListener(EventosAPIListener listener) {
        listeners.add(listener);
    }
    
    private void generarEventoLatest(PeticionAPI peticion) {
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            logger.info("[HILO] Lanzar el evento LATEST de la petición Id: " + peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this, peticion);
            (listener).procesarEventoLatest(eventoAPI);
        }
    }
    
    private void procesarPeticionLatest(PeticionAPI peticion) {
        String respuesta = frankfurterAPI.ejecutar(peticion.getOperacion());
        if (respuesta == null) {
            peticion.setRespuesta("Error al procesar la petición LATEST con Id: " + peticion.getId());
        } else {
            peticion.setRespuesta(respuesta);
        }
        generarEventoLatest(peticion);
        logger.info("[HILO] Se ha procesado la petición LATEST con Id: " + peticion.getId());
    }
    
    private void generarEventoCurrencies(PeticionAPI peticion) {
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            logger.info("[HILO] Lanzar el evento CURRENCIES de la petición Id: " + peticion.getId());
            EventosAPIListener listener = (EventosAPIListener)li.next();
            EventoAPI eventoAPI = new EventoAPI(this, peticion);
            (listener).procesarEventoCurrencies(eventoAPI);
        }
    }
    
    private void procesarPeticionCurrencies(PeticionAPI peticion) {
        String respuesta = frankfurterAPI.ejecutar(peticion.getOperacion());
        if (respuesta == null) {
            peticion.setRespuesta("Error al procesar la petición CURRENCIES con Id: " + peticion.getId());
        } else {
            peticion.setRespuesta(respuesta);
        }
        generarEventoCurrencies(peticion);
        logger.info("[HILO] Se ha procesado la petición CURRENCIES con Id: " + peticion.getId());
    }

    @Override
    public void run() {
        PeticionAPI peticion;
        
        do {
            if (!peticiones.isEmpty()) {
                peticion = peticiones.get(0);
                switch (peticion.getOperacion()) {
                    case LATEST:
                    default:
                        procesarPeticionLatest(peticion);
                        break;
                    case CURRENCIES:
                        procesarPeticionCurrencies(peticion);
                        break;
                }
                peticiones.remove(0);
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                logger.error("Error: " + ex.getMessage());
            }
        } while (seguir);
    }
}