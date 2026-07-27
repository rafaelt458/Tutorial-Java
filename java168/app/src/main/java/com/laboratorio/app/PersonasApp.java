package com.laboratorio.app;

import com.laboratorio.core.model.Persona;
import com.laboratorio.persistence.repository.PersonaRepository;

public class PersonasApp {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=laboratorio;encrypt=false";
        String user = "sa";
        String password = "1234";

        PersonaRepository repository = new PersonaRepository(url, user, password);

        Persona persona = repository.findById(1);

        System.out.println(persona != null ? persona.toString() : "No encontrado");
    }
}