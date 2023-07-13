package com.laboratorio.java079;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    private final String host;
    private final int puerto;
    private final Socket conexion;

    public Cliente(String host, int puerto) throws Exception {
        this.host = host;
        this.puerto = puerto;
        conexion = new Socket(host, puerto);
    }

    public String getHost() {
        return host;
    }

    public int getPuerto() {
        return puerto;
    }
    
    public void startClient() throws Exception {
        DataOutputStream salidaServidor;
        BufferedReader entradaServidor;
        String mensaje;
        
        // Se obtienen los flujos de entrada y salida al servidor
        salidaServidor = new DataOutputStream(conexion.getOutputStream());
        entradaServidor = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        
        // Se envía mensaje al servidor
        salidaServidor.writeUTF("Iniciando transmisión al servidor\n");
        
        // Se recibe mensaje del servidor
        mensaje = entradaServidor.readLine();
        System.out.println("Mensaje servidor: " + mensaje);
        
        // Se envía mensaje al servidor
        salidaServidor.writeUTF("Instrucción a ejecutar en el servidor\n");
        
        entradaServidor.close();
        salidaServidor.close();
        conexion.close();
    }
}