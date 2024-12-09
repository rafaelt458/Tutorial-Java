package com.laboratorio.repository;

import com.laboratorio.java152.model.Persona;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class PersonaDataMock {
    public static List<Persona> personaListMock() {
        return List.of(
            new Persona(1, "Juan", "Mata", Date.valueOf(LocalDate.of(1999, 8, 28)), 2),
            new Persona(2, "María", "Blanco", Date.valueOf(LocalDate.of(1997, 5, 12)), 5),
            new Persona(3, "Olga", "Quijada", Date.valueOf(LocalDate.of(1995, 1, 11)), 8),
            new Persona(4, "Eduardo", "Ramos", Date.valueOf(LocalDate.of(2001, 3, 7)), 1));
    }
    
    public static Persona personaMock() {
        return new Persona(1, "Raul", "Gavidia", Date.valueOf(LocalDate.of(1999, 8, 28)), 5);
    }
}