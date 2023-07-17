package com.laboratorio.java081.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final int puerto;
    private final ServerSocket serverSocket;
    private final boolean continuar;
    private int nClientes;

    public Servidor(int puerto) throws Exception {
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar = true;
        this.nClientes = 0;
    }

    public int getPuerto() {
        return puerto;
    }
    
    public void startServer() throws Exception {
        Socket clientSocket;
        
        while (continuar) {
            System.out.println("Esperando un nuevo cliente");

            // Esperar una conexión con un cliente
            clientSocket = serverSocket.accept();

            nClientes++;
            System.out.println("Se ha conectado el cliente " + nClientes);
            AtencionCliente cliente = new AtencionCliente(clientSocket, nClientes);
            cliente.start();
        }
        
        serverSocket.close();
    }
}