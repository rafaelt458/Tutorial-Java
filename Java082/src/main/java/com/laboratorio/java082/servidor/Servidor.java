package com.laboratorio.java082.servidor;

import com.laboratorio.java082.ServidorChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread {
    private final ServidorChat ventana;
    private final int puerto;
    private final ServerSocket serverSocket;
    private boolean continuar;
    private int nClientes;
    private List<Participante> participantes;

    public Servidor(ServidorChat ventana, int puerto)  throws Exception {
        this.ventana = ventana;
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(puerto);
        this.continuar = true;
        this.nClientes = 0;
        this.participantes = new ArrayList<>();
    }
    
    public int getPuerto() {
        return puerto;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    
    public void agregarParticipante(Participante participante) {
        // Avisar a otros usuarios del nuevo participante
        String mensaje, mensajeNuevo;
        
        mensaje = "CONECTADO\t" + participante.getNombre() + "\t" + participante.getId() + "\n";
        for (Participante part : participantes) {
            part.getAtencionCliente().enviarMensaje(mensaje);
            mensajeNuevo = "CONECTADO\t" + part.getNombre() + "\t" + part.getId() + "\n";
            participante.getAtencionCliente().enviarMensaje(mensajeNuevo);
        }
        
        ventana.agregarEvento("Se ha conectado " + participante.getNombre());
        this.participantes.add(participante);
        
        ventana.refrescarLista();
    }
    
    public void quitarParticipante(Participante participante) {
        int i;
        Participante part;
        String mensaje = "DESCONECTADO\t" + participante.getId() + "\n";
        
        for (i = participantes.size()-1; i >= 0; i--) {
            part = participantes.get(i);
            if (part.getId() == participante.getId()) {
                ventana.agregarEvento("Se ha desconectado " + participante.getNombre());
                this.participantes.remove(i);
            } else {
                // Avisar al usuario que el participante ya no está disponible
                part.getAtencionCliente().enviarMensaje(mensaje);
            }
        }
        
        ventana.refrescarLista();
    }
    
    public void enviarMensaje(int id, String mensaje, String emisor) {
        for (Participante p : participantes) {
            if (p.getId() == id) {
                String comando = "MENSAJE\t" + emisor + " dice: " + mensaje + "\n";
                p.getAtencionCliente().enviarMensaje(comando);
                ventana.agregarEvento(emisor + " dice: " + mensaje);
                break;
            }
        }
    }
    
    @Override
    public void run() {
        Socket clientSocket;
        
        try {
            ventana.agregarEvento("Iniciado el servidor...");

            while (continuar) {
                // Esperar una conexión con un cliente
                clientSocket = serverSocket.accept();

                nClientes++;
                AtencionCliente cliente = new AtencionCliente(this, clientSocket, nClientes);
                cliente.start();
            }
            
        } catch (IOException ex) {
            if (continuar) {
                System.out.println("Se ha producido un error inesperado: " + ex.getMessage());
                ventana.cerrarAplicacion(1);
            }
            return;
        }
    }
    
    public void cerrar() {
        System.out.println("Cierre iniciado");
        
        continuar = false;
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Se ha producido un error inesperado al cerrar el socket: " + ex.getMessage());
            return;
        }
        
        System.out.println("Cierre finalizado");
    }
}