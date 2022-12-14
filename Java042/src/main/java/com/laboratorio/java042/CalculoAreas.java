package com.laboratorio.java042;

import com.laboratorio.java042.calculos.AreaCuadrado;
import com.laboratorio.java042.calculos.AreaRectangulo;
import com.laboratorio.java042.calculos.AreaTriangulo;
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

    static double obtenerDato(String nombreDato) {
        double dato;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese " + nombreDato + ": ");
        try {
            dato = teclado.nextDouble();
        } catch (Exception e) {
            System.out.println("Error. El valor debe ser numérico.");
            return 0;
        }

        return dato;
    }

    public static void main(String[] args) {
        char opcion;
        double base, altura;

        do {
            opcion = menuOpciones();

            switch (opcion) {
                case '3':
                    double lado;
                    AreaCuadrado areaCuadrado;

                    lado = obtenerDato("la longitud de unlado del cuadrado");
                    if (lado != 0) {
                        areaCuadrado = new AreaCuadrado();
                        areaCuadrado.setLado(lado);
                        areaCuadrado.mostrar();
                    }
                    break;
                case '2':
                    AreaTriangulo areaTriangulo;
                    
                    base = obtenerDato("la longitud de la base del triángulo");
                    if (base != 0) {
                        altura = obtenerDato("la longitud de la altura del triángulo");
                        if (altura != 0) {
                            areaTriangulo = new AreaTriangulo();
                            areaTriangulo.setBase(base);
                            areaTriangulo.setAltura(altura);
                            areaTriangulo.mostrar();
                        }
                    }
                    break;
                case '1':
                    AreaRectangulo areaRectangulo;
                    
                    base = obtenerDato("la longitud de la base del rectángulo");
                    if (base != 0) {
                        altura = obtenerDato("la longitud de la altura del rectángulo");
                        if (altura != 0) {
                            areaRectangulo = new AreaRectangulo();
                            areaRectangulo.setBase(base);
                            areaRectangulo.setAltura(altura);
                            areaRectangulo.mostrar();
                        }
                    }
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
