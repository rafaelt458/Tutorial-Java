package com.laboratorio.java127.utiles;

import java.util.Date;
import javax.enterprise.inject.Produces;

public class ProductorDeSaludos {
    @Produces
    public SaludoPersonalizado crearSaludo() {
        String mensaje = obtenerMensajePersonalizado();
        return new SaludoPersonalizado(mensaje);
    }
    
    private String obtenerMensajePersonalizado() {
        return "Hola Laboratorio de Rafa. Hoy es: " + new Date();
    }
}