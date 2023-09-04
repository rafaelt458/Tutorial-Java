package com.laboratorio.java092;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Java092 {

    public static void main(String[] args) {
        try {
            // Realizar la petición
            URL url = new URL("https://api.frankfurter.app/latest");
            HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();
            
            // Comprobar si la respuesta es correcta
            int respuesta = conexion.getResponseCode();
            if (respuesta != 200) {
                // Si no es correcta, mostramos mensaje de error
                System.out.println("Ha ocurrido el error " + respuesta + " procesando la petición.");
                return;
            }
            
            // Si es correcta, mostramos la respuesta
            StringBuilder respuestaStr = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                respuestaStr.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println("Respuesta: ");
            System.out.println(respuestaStr);            
        } catch (IOException ex) {
            System.out.println("Error inesperado al procesar la petición: " + ex.getMessage());
        }
    }
}