package com.laboratorio.java097.eventos;

import com.laboratorio.java097.peticion.PeticionAPI;
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