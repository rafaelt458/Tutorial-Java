package com.laboratorio.java088;

import java.util.Objects;

public class Persona {
    String Nombre;
    String Apellido;
    short edad;
    String NroDocumento;

    public Persona(String Nombre, String Apellido, short edad, String NroDocumento) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.edad = edad;
        this.NroDocumento = NroDocumento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", edad=" + edad + ", NroDcumento=" + NroDocumento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.NroDocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.NroDocumento, other.NroDocumento);
    }
}