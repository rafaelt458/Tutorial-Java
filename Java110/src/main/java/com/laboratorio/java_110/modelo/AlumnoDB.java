package com.laboratorio.java_110.modelo;

import java.util.List;

public class AlumnoDB {
    public List<Alumno> obtenerAlumnos() {
        return List.of(
                new Alumno("Pedro", "Pérez", 12),
                new Alumno("Olga", "Castillo", 11),
                new Alumno("Jorge", "Martínez", 12),
                new Alumno("María", "Hernández", 13)
        );
    }
}