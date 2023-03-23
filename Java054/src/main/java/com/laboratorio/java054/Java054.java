package com.laboratorio.java054;

import java.util.Scanner;

public class Java054 {

    // Devuelve el nombre de una persona
    public static String leerNombre(int pos) {
        String nombre;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la persona " + pos + ": ");
        nombre = teclado.nextLine();

        return nombre.trim();
    }

    // Devuelve la edad de una persona o -1 en caso de error
    public static int leerEdad(int pos) {
        int edad;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la edad de la persona " + pos + ": ");
        try {
            edad = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Error. La edad debe ser un número.");
            return -1;
        }

        return edad;
    }

    public static void mostrarListado(String nombres[], int edades[]) {
        int i;

        System.out.println("");
        System.out.println("");
        System.out.println("***********************************");
        System.out.println("Listado de personas (nombre / edad)");
        System.out.println("***********************************");
        for (i = 0; i < nombres.length; i++) {
            System.out.println(i + 1 + "- " + nombres[i] + " de " + edades[i] + " años.");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int nPerson, i;
        String nombres[];
        int edades[];
        double acum = 0, promedio;

        // Captura del número de personas.
        System.out.print("Indique el número de personas del grupo: ");
        try {
            nPerson = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Error. El valor debe ser un número.");
            return;
        }

        // Inicialización de vectores
        nombres = new String[nPerson];
        edades = new int[nPerson];

        // Captura de los datos de las personas
        for (i = 0; i < nPerson; i++) {
            do {
                nombres[i] = leerNombre(i + 1);
                if (nombres[i].length() == 0) {
                    System.out.println("Error. El nombre no puede estar vacío.");
                }
            } while (nombres[i].length() == 0);

            do {
                edades[i] = leerEdad(i + 1);
            } while (edades[i] == -1);

            acum += edades[i];
        }

        // Calcular el promedio de edades
        promedio = acum / nPerson;

        // Mostrar el listado de personas
        mostrarListado(nombres, edades);

        // Mostrar el promedio
        System.out.println("El promedio del grupo es: " + promedio);
    }
}
