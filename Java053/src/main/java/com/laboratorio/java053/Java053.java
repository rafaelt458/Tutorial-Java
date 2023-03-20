package com.laboratorio.java053;

public class Java053 {

    public static void main(String[] args) {
        double res1, res2, res3, res4, res5, res6, angulo = 45, radianes;
        
        System.out.println("Valor de PI: " + Math.PI);
        System.out.println("Valor de e: " + Math.E);
        
        res1 = Math.log(Math.E);
        System.out.println("El resultado de la operación de logaritmo natural es: " + res1);
        
        res2 = Math.log10(100);
        System.out.println("El resultado de la operación de logaritmo base 10 es: " + res2);
        
        res3 = Math.sqrt(4);
        System.out.println("El resultado de la operación raíz cuadrada es: " + res3);
        
        radianes = Math.toRadians(angulo);
        
        res4 = Math.sin(radianes);
        System.out.println("El resultado de la operación seno es: " + res4);
        
        res5 = Math.cos(radianes);
        System.out.println("El resultado de la operación coseno es: " + res5);
        
        res6 = Math.tan(radianes);
        System.out.println("El resultado de la operación tangente es: " + res6);
    }
}