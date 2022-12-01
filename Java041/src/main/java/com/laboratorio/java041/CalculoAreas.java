package com.laboratorio.java041;

import com.laboratorio.java041.calculos.AreaCuadrado;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class CalculoAreas {

    static char menuOpciones() {
        char opcion;
        Scanner teclado = new Scanner(System.in);

        System.out.println("");
        System.out.println("");
        System.out.println("****************");
        System.out.println("Menú de opciones");
        System.out.println("****************");
        System.out.println("(1) Calcular el área de un rectángulo");
        System.out.println("(2) Calcular el área de un triángulo");
        System.out.println("(3) Calcular el área de un cuadrado");
        System.out.println("(4) Fin del programa");
        System.out.println("");
        System.out.print("Indique su opción: ");

        opcion = teclado.next().charAt(0);

        return opcion;
    }

    public static void main(String[] args) {
        char opcion;

        do {
            opcion = menuOpciones();

            switch (opcion) {
                case '1':
                    AreaCuadrado areaCuadrado;
                    
                    areaCuadrado = new AreaCuadrado();
                    areaCuadrado.mostrar();
                    break;
                case '2':
                    System.out.println("Cálculo del área de un triángulo.");
                    break;
                case '3':
                    System.out.println("Cálculo del área de un cuadrado.");
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Error. Opción inexistente.");
                    break;
            }
        } while (opcion != '4');
    }
}
