package com.laboratorio.java099.peticion;

import com.laboratorio.java099.api.FrankfurterAPIEnum;
import com.laboratorio.java099.eventos.EventoAPI;
import com.laboratorio.java099.eventos.EventosAPIListener;
import com.laboratorio.java099.eventos.ListaPeticiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PeticionCurrencies {
    Logger logger = LogManager.getLogger(PeticionCurrencies.class);
    private final ListaPeticiones peticiones;
    
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            logger.info("[APP-CURRENCIES] No hacer nada");
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            logger.info("[APP-CURRENCIES] Manejo de un evento");
            logger.info("[APP-CURRENCIES] Respuesta de la petición Id " + evento.getPeticion().getId() + ": " + evento.getPeticion().getRespuesta());
        }
    };

    public PeticionCurrencies(ListaPeticiones peticiones) {
        this.peticiones = peticiones;
        this.peticiones.addEventListener(eventos);
    }
    
    public void add(int id) {
        PeticionAPI peticion = new PeticionAPI(id, FrankfurterAPIEnum.CURRENCIES);
        peticiones.add(peticion);
    }
}