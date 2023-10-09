package com.laboratorio.java099.eventos;

import com.laboratorio.java099.peticion.PeticionAPI;
import java.util.EventObject;

public class EventoAPI extends EventObject {
    private PeticionAPI peticion;
    
    public EventoAPI(Object source, PeticionAPI peticion) {
        super(source);
        this.peticion = peticion;
    }

    public PeticionAPI getPeticion() {
        return peticion;
    }
}