package com.laboratorio.java081;

import com.laboratorio.java081.servidor.Servidor;

/**
 *
 * @author Rafael
 */
public class MainServidor {

    public static void main(String[] args) {
        System.out.println("Iniciado el servidor");
        try {
            Servidor servidor = new Servidor(2468);
            servidor.startServer();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}