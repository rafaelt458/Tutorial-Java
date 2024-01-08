package com.laboratorio.java121;

import com.laboratorio.java119.ws.Persona;
import com.laboratorio.java119.ws.PersonaWebService;
import com.laboratorio.java119.ws.PersonaWebService_Service;
import com.laboratorio.java119.ws.Resultado;
import java.util.List;

public class TestWS {
    public static void main(String[]args) {
        PersonaWebService_Service service = new PersonaWebService_Service();
        PersonaWebService cliente = service.getPersonaWebServicePort();
        
        Resultado res = cliente.crearPersona("Sofia", "Castaño", "1979-07-25", 9);
        System.err.println("Resultado: " + res.getCodigo() + " - " + res.getMensaje());
        
        List<Persona> personas = cliente.listarPersonas();
        for (Persona p : personas) {
            System.out.println("");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Nombres: " + p.getNombres());
            System.out.println("Apellidos: " + p.getApellidos());
            System.out.println("Fecha nacimiento: " + p.getFechaNac());
            System.out.println("Experiencia: " + p.getExperiencia() + " años");
        }
    }
}