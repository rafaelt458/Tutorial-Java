package com.laboratorio.java141.modelo;

import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private Integer codigo;
    private String nombre;
    private LocalDate fechaNac;
    private Integer experiencia;
    private Double salario;
    
    public Integer getEdad() {
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }
}