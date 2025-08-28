package com.laboratorio.java161;

import com.laboratorio.java161.logger.MiLogger;
import java.io.BufferedReader;
import java.io.FileReader;

public class Java161 {

    public static void main(String[] args) {
        try (FileReader file = new FileReader("fichero.txt")) {
            try (BufferedReader reader = new BufferedReader(file)) {
                String linea;
                do {
                    linea = reader.readLine();
                    if (linea != null) {
                        System.out.println(linea);
                    }
                } while (linea != null);
            } catch (Exception e) {
                System.out.println("Error leyendo el fichero: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error abriendo el fichero: " + e.getMessage());
        }
        
        try (MiLogger logger = new MiLogger("log.txt")) {
            logger.log("Iniciando la aplicación");
            logger.log("Agregando otra línea");
            logger.log("Cerrando la aplicación");
            throw new RuntimeException("Simulando error");
        } catch (Exception e) {
            System.out.println("Error usando el Logger: " + e.getMessage());
        }
    }
}