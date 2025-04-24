package com.laboratorio.java158;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Java158 {

    public static void main(String[] args) {
        try {
            leerArchivo("archivo_inexistente.txt");
        } catch (IOException e) {
            System.out.println("Se produjo un error el leer el archivo: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa error: " + e.getCause().getMessage());
            }
        }
        
        String texto = null;
        try {
            imprimirLongitud(texto);
        } catch (NullPointerException e) {
            System.out.println("Se produjo en error: " + e.getMessage());
        }
        
        try {
            provocarStackOverflow(0);
        } catch (StackOverflowError e) {
            System.out.println("Se produjo un error crítico: " + e.getMessage());
        }
        
        System.out.println("Final del programa");
    }
    
    public static void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo));
        String linea = bufferedReader.readLine();
        System.out.println(linea);
        bufferedReader.close();
    }
    
    public static void imprimirLongitud(String texto) {
        System.out.println("La longitud del texto es: " + texto.length());
    }
    
    public static void provocarStackOverflow(int contador) {
        provocarStackOverflow(contador + 1);
    }
}
