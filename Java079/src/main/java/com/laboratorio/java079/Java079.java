package com.laboratorio.java079;

/**
 *
 * @author Rafael
 */
public class Java079 {

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