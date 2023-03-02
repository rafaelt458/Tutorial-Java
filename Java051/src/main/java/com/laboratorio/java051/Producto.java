package com.laboratorio.java051;

public class Producto {
    public static int ultimoCodigo = 0;
    private int codigo;
    private String descripcion;
    private Double precio;

    public Producto(String descripcion, Double precio) {
        ultimoCodigo++;
        this.codigo = ultimoCodigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public void mostrar() {
        System.out.println("Código: " + codigo + " - Descripción: " + descripcion + " - Precio: " + precio);
    }
}