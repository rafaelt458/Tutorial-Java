package com.laboratorio.java141.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Alumno {
    private String nombre;
    private Integer edad;
}