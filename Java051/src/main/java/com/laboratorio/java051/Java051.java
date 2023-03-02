package com.laboratorio.java051;

public class Java051 {

    public static void main(String[] args) {
        Producto p1, p2, p3;
        
        p1 = new Producto("Tenedor", 1.25);
        p2 = new Producto("Cuchillo", 1.45);
        p3 = new Producto("Cuchara", 1.15);
       
        p1.mostrar();
        p2.mostrar();
        p3.mostrar();
        
        System.out.println("Último código usado: " + Producto.ultimoCodigo);
    }
}
