package com.laboratorio.java159;

import com.laboratorio.java159.model.Persona1;
import com.laboratorio.java159.model.Persona2;
import java.time.LocalDate;

public class Java159 {

    public static void main(String[] args) {
        Persona1 persona1 = new Persona1.Builder("Jorge", "Camargo", "jorge@mail.com")
                .setFechaNacimiento(LocalDate.of(1995, 7, 8))
                .setTelefono("655744456")
                .build();
        
        System.out.println("Persona 1: " + persona1.toString());
        
        Persona2 persona2 = Persona2.builder()
                .nombre("Oscar")
                .apellido("Quintero")
                .email("oscar@mail.com")
                .direccion("Madrid")
                .build();
        
        System.out.println("Persona 2: " + persona2.toString());
    }
}