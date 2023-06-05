package com.laboratorio.java073;

public class Java073 {

    public static void main(String[] args) {
        String str;
        
        str = "Hola";
        str += " desde" + " el";
        str += " Laboratorio" + " de Rafa";
        
        System.out.println(str);
        
        StringBuilder strBuilder = new StringBuilder();
        
        strBuilder.append("Hola").append(" desde");
        strBuilder.append(" el").append(" Laboratorio").append(" de Rafa");
        
        System.out.println(strBuilder.toString());
        
        int i;
        
        long inicio = System.nanoTime();
        StringBuilder strBuilder2 = new StringBuilder();
        for (i=0; i<1000; i++) {
            strBuilder2.append(i);
        }
        long fin = System.nanoTime();
        double diferencia1 = fin - inicio;
        System.out.println("Tiempo con StringBuilder: " + (fin - inicio));
        
        
        inicio = System.nanoTime();
        String str2 = "";
        for (i=0; i<1000; i++) {
            str2 += i;
        }
        fin = System.nanoTime();
        double diferencia2 = fin - inicio;
        System.out.println("Tiempo con String: " + (fin - inicio));
        
        System.out.println("Proporción: " + (diferencia2/diferencia1));
    }
}