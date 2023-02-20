package com.laboratorio.java050;

public class Java050 {

    public static void main(String[] args) {
        Madre1 mad1;
        Hija1 hija1;
        Madre2 mad2;
        Hija2 hija2;
        
        mad1 = new Madre1("Valor 1");
        hija1 = new Hija1("Valor 2");
        
        mad2 = new Madre2("Valor 3");
        hija2 = new Hija2("Valor 4", "Valor 5");
        
        mad1.mostrar();
        hija1.mostrar();
        
        mad2.mostrar();
        hija2.mostrar(2);
    }
}