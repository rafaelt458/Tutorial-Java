package com.laboratorio.java056;

import java.util.Scanner;

public class Java056 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String valor;

        System.out.println("Dime el día de semana (LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO) : ");
        valor = entrada.next().toUpperCase();
        DiaDeLaSemana dia = DiaDeLaSemana.valueOf(DiaDeLaSemana.class, valor);

        switch (dia) {
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Buenos días!");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Buenos fin de semana!");
                break;
        }

        DiaSemana dia2 = DiaSemana.valueOf(DiaSemana.class, valor);

        System.out.println("Día de semana: " + dia2);
        System.out.println("Abreviatura: " + dia2.getAbrev());
    }
}