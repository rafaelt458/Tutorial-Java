package com.laboratorio.java079;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int puerto;
    private final ServerSocket serverSocket;

    public Servidor(int puerto) throws Exception {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto);
    }

    public int getPuerto() {
        return puerto;
    }
    
    public void startServer() throws Exception {
        Socket clientSocket  = new Socket();
        DataOutputStream salidaCliente;
        BufferedReader entradaCliente;
        String mensaje;
        
        System.out.println("Esperando un cliente");
        
        // Esperar una conexión con un cliente
        clientSocket = serverSocket.accept();
        
        System.out.println("Se ha conectado un cliente");
        
        // Se obtienen los flujos de entrada y salida al cliente
        salidaCliente = new DataOutputStream(clientSocket.getOutputStream());
        entradaCliente = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        // Se recibe el primer mensaje del cliente
        mensaje = entradaCliente.readLine();
        System.out.println("Mensaje cliente: " + mensaje);
        
        // Enviamos un mensaje al cliente
        salidaCliente.writeUTF("Conexión aceptada. Esperando instrucción\n");
        
        // Se ejecuta mientras haya mensajes del cliente
        while ((mensaje = entradaCliente.readLine()) != null) {
            System.out.println("Mensaje cliente: " + mensaje);
        }
        
        System.out.println("Fin de conexión del cliente.");
        
        salidaCliente.close();
        entradaCliente.close();
        clientSocket.close();
        serverSocket.close();
    }
}