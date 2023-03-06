package com.laboratorio.java052;

public class Java052 {

    public static void main(String[] args) {
        double resultado;
        
        resultado = Calculadora.suma(2, 3);
        System.out.println("Resultado de la suma: " + resultado);
        
        resultado = Calculadora.resta(6, 4);
        System.out.println("Resultado de la resta: " + resultado);
        
        resultado = Calculadora.multiplicacion(5, 6);
        System.out.println("Resultado de la multiplicación: " + resultado);
        
        resultado = Calculadora.division(8, 4);
        System.out.println("Resultado de la división: " + resultado);
    }
}