package com.laboratorio.java147.model;

import com.laboratorio.java147.mapper.ColumnJDBC;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {
    @ColumnJDBC(name = "idpersonas")
    private int codigo;
    
    @ColumnJDBC(name = "Nombres")
    private String nombres;
    
    @ColumnJDBC(name = "Apellidos")
    private String apellidos;
    
    @ColumnJDBC(name = "FechaNac")
    private Date fechaNac;
    
    @ColumnJDBC(name = "Experiencia")
    private int experiencia;

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNac=" + fechaNac + ", experiencia=" + experiencia + '}';
    }
}