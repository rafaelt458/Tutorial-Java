package com.laboratorio.core.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNac;
    private int experiencia;

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNac=" + fechaNac + ", experiencia=" + experiencia + '}';
    }
}