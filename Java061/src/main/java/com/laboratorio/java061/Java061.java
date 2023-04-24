package com.laboratorio.java061;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java061 {
    public static void calcularEdad(int dia, int mes, int anno) {
        // Crear la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
        
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Calcular la edad
        Period edad = Period.between(fechaNacimiento, fechaActual);
        
        System.out.println("La persona tiene " + edad.getYears() + " años, " + edad.getMonths() + " meses y " + edad.getDays() + " días.");
        
        // Mostrar la fecha de nacimiento en el formato dd/mm/aaaa
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(formato));
    }
    
    public static void horaPais(String zonaHoraria) {
        ZoneId zoneId = ZoneId.of(zonaHoraria);
        ZonedDateTime fechaHoraPais = ZonedDateTime.now(zoneId);
        System.out.println("Fecha y hora en la zona horaria indicada: " + fechaHoraPais);
    }
    
    // De API nueva a API antigua
    public static void conversionAFechaAntigua() {
        ZoneId zonaHoraria = ZoneId.systemDefault();
        LocalDateTime fechaNueva = LocalDateTime.now(zonaHoraria);
        
        Date fechaAntigua = Date.from(fechaNueva.atZone(zonaHoraria).toInstant());
        
        System.out.println("Fecha antigua: " + fechaAntigua);
    }
    
    // De API antigua a API nuevaa
    public static void conversionAFechaNueva() {
        Date fechaAntigua = new Date();
        ZoneId zonaHoraria = ZoneId.systemDefault();
        Instant instant = fechaAntigua.toInstant();
        LocalDateTime fechaNueva = instant.atZone(zonaHoraria).toLocalDateTime();
        
        System.out.println("Fecha nueva: " + fechaNueva);
    }

    public static void main(String[] args) {
        calcularEdad(21, 2, 1992);
        
        horaPais("Asia/Tokyo");
        
        conversionAFechaAntigua();
        
        conversionAFechaNueva();
    }
}