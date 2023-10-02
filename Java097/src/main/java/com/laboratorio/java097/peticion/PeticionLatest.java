package com.laboratorio.java097.peticion;

import api.FrankfurterAPIEnum;
import com.laboratorio.java097.eventos.EventoAPI;
import com.laboratorio.java097.eventos.EventosAPIListener;
import com.laboratorio.java097.eventos.ListaPeticiones;

public class PeticionLatest {
    private final ListaPeticiones peticiones;
    
    private final EventosAPIListener eventos = new EventosAPIListener() {
        @Override
        public void procesarEventoLatest(EventoAPI evento) {
            System.out.println("[APP-LATEST] Manejo de un evento");
            System.out.println("[APP-LATEST] Respuesta de la petición Id " + evento.getPeticion().getId() + ": " + evento.getPeticion().getRespuesta());
        }

        @Override
        public void procesarEventoCurrencies(EventoAPI evento) {
            System.out.println("[APP-LATEST] No hacer nada");
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