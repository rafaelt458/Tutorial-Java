package com.laboratorio.java072;

public class ListaGenerica<T> {
    private T[] elementos;
    private int indice;
    
    public ListaGenerica(int capacidad) {
        elementos = (T[]) new Object[capacidad];
        indice = 0;
    }
    
    public void agregar(T elemento) {
        if (indice < elementos.length) {
            elementos[indice] = elemento;
            indice++;
        } else {
            System.out.println("La lista está llena. No se pudo insertar el elemento.");
        }
    }
    
    public T obtener(int pos) {
        if (pos >= 0 && pos < indice) {
            return elementos[pos];
        } else {
            System.out.println("Posición inválida. El elemento indicado no existe.");
            return null;
        }
    }
    
    public int nElementosLista() {
        return indice;
    }
}
