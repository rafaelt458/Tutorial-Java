package com.laboratorio.java060;

import java.util.HashSet;

public class Java060 {

    public static void main(String[] args) {
        HashSet<String> nombres = new HashSet<>();
        
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("María");
        nombres.add("Juan");
        
        System.out.println(nombres);
        
        nombres.remove("Pedro");
        nombres.remove("Luis");
        
        System.out.println(nombres);
        
        if (nombres.contains("Juan")) {
            System.out.println("El nombre Juan existe.");
        } else {
            System.out.println("El nombre Juan no existe.");
        }
        
        if (nombres.contains("Luis")) {
            System.out.println("El nombre Luis existe.");
        } else {
            System.out.println("El nombre Luis no existe.");
        }
    }
}