package com.laboratorio.java159.model;

import java.time.LocalDate;

public class Persona1 {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;

    public Persona1(Builder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.direccion = builder.direccion;
    }

    @Override
    public String toString() {
        return "Persona1{" + "nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }
    
    public static class Builder {
        private final String nombre;
        private final String apellido;
        private final String email;
        private String telefono;
        private LocalDate fechaNacimiento;
        private String direccion;

        public Builder(String nombre, String apellido, String email) {
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre el obligatorio");
            }
            if (apellido == null || apellido.isBlank()) {
                throw new IllegalArgumentException("El apellido el obligatorio");
            }
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("El email el obligatorio");
            }
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        
        public Persona1 build() {
            return new Persona1(this);
        }
    }
}