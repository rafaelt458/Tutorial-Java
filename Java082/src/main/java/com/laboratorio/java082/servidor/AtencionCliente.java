package com.laboratorio.java082.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtencionCliente extends Thread {
    private final Servidor padre;
    private final Socket conexion;
    private final int nCliente;
    private DataOutputStream salidaCliente;
    private String nombre;

    public AtencionCliente(Servidor padre, Socket conexion, int nCliente) {
        this.padre = padre;
        this.conexion = conexion;
        this.nCliente = nCliente;
        this.salidaCliente = null;
    }
    
    public void enviarMensaje(String mensaje) {
        if (this.salidaCliente != null) {
            try {
                salidaCliente.writeUTF(mensaje);
            } catch (IOException ex) {
                System.out.println("Error enviando mensaje: " + ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        BufferedReader entradaCliente;
        Participante participante;
        String mensaje;

        try {
            // Se obtienen los flujos de entrada y salida al cliente
            salidaCliente = new DataOutputStream(conexion.getOutputStream());
            entradaCliente = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        
            // Se recibe el primer mensaje del cliente
            mensaje = entradaCliente.readLine();
            nombre = mensaje.substring(2, mensaje.length());
            participante = new Participante(nCliente, nombre, this);
            padre.agregarParticipante(participante);
        
            // Enviamos un mensaje al cliente
            salidaCliente.writeUTF("Conexión aceptada. Esperando instrucción\n");
        
            // Se ejecuta mientras haya mensajes del cliente
            while ((mensaje = entradaCliente.readLine()) != null) {
                procesarMensaje(mensaje.substring(2, mensaje.length()));
            }
        
            padre.quitarParticipante(participante);
        
            salidaCliente.close();
            entradaCliente.close();
            conexion.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void procesarMensaje(String mensaje) {
        int pos;
        String comando;
        
        pos = mensaje.indexOf('\t');
        if (pos < 0) {
            return;
        }
        
        comando = mensaje.substring(0, pos);
        if (comando.equalsIgnoreCase("MENSAJE")) {
            procesarComandoMensaje(mensaje);
        }
    }
    
    private void procesarComandoMensaje(String comando) {
        int pos1, pos2, id;
        String mensaje, str;
        
        pos1 = comando.indexOf('\t');
        pos2 = comando.indexOf('\t', pos1+1);
        str = comando.substring(pos1+1, pos2);
        id = Integer.parseInt(str);
        mensaje = comando.substring(pos2+1, comando.length());
        padre.enviarMensaje(id, mensaje, nombre);
    }
}