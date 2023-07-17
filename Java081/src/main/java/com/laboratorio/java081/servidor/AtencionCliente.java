package com.laboratorio.java081.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread {

    private final Socket conexion;
    private final int nCliente;

    public AtencionCliente(Socket conexion, int nCliente) {
        this.conexion = conexion;
        this.nCliente = nCliente;
    }

    @Override
    public void run() {
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;

        try {
            // Se obtienen los flujos de entrada y salida al cliente
            salidaCliente = new DataOutputStream(conexion.getOutputStream());
            entradaCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        
            // Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            System.out.println("Mensaje cliente " + nCliente + ": " + mensaje);
        
            // Enviamos un mensaje al cliente
            salidaCliente.writeUTF("Conexión aceptada. Esperando instrucción\n");
        
            // Se ejecuta mientras haya mensajes del cliente
            while ((mensaje = entradaCliente.readLine()) != null) {
                System.out.println("Mensaje cliente " + nCliente + ": " + mensaje);
            }
        
            System.out.println("Fin de conexión del cliente " + nCliente);
        
            salidaCliente.close();
            entradaCliente.close();
            conexion.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}