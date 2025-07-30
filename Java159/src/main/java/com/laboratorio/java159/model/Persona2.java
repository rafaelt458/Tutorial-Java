package com.laboratorio.java159.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter @Builder @ToString
public class Persona2 {
    @NonNull private String nombre;
    @NonNull private String apellido;
    @NonNull private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
}