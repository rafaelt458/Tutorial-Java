package com.laboratorio.java140.modelo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
// @Getter @Setter
// @RequiredArgsConstructor
// @ToString
// @EqualsAndHashCode
@Data
@Slf4j
public class PersonaLombok {
    private int codigo;
    private String nombre;
    private LocalDate fechaNac;
    private int experiencia;
    private double salario;
    
    public void test(String text) {
        log.info("Texto: " + text);
        log.error(text);
        log.warn(text);
    }
}
