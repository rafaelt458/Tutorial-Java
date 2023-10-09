package com.laboratorio.java099.peticion;

import com.laboratorio.java099.api.FrankfurterAPIEnum;
import com.laboratorio.java099.eventos.EventoAPI;
import com.laboratorio.java099.eventos.EventosAPIListener;
import com.laboratorio.java099.eventos.ListaPeticiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PeticionLatest {
    Logger logger = LogManager.getLogger(PeticionLatest.class);
    private final ListaPeticiones peticiones;
    
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            logger.info("[APP-LATEST] Manejo de un evento");
            logger.info("[APP-LATEST] Respuesta de la petición Id " + evento.getPeticion().getId() + ": " + evento.getPeticion().getRespuesta());
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            logger.info("[APP-LATEST] No hacer nada");
        }
    };

    public PeticionLatest(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.addEventListener(eventos);
    }
    
    public void add(int id) {
        PeticionAPI peticion = new PeticionAPI(id, FrankfurterAPIEnum.LATEST);
        peticiones.add(peticion);
    }
}