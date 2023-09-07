package com.laboratorio.java093;

import com.laboratorio.java093.entity.Change;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Java093 {

    public static void main(String[] args) {
        try {
            // Creamos la conexión al API
            Client client = ClientBuilder.newClient();

            // Contruir la URI del servicio
            String URL = "https://api.frankfurter.app/";
            String endpoint = "latest";
            WebTarget target = client.target(URL + endpoint);

            // Hacer la llamada
            String jsonStr = target.request(MediaType.APPLICATION_JSON).get(String.class);
            System.out.println("Respuesta: " + jsonStr);
            
            // Creamos la entidad a partir de la respuesta
            Change change = new Change(jsonStr);
            System.out.println("Entidad: " + change.toString());
        } catch (Exception ex) {
            System.out.println("Se ha presentado un error al hacer la llamada: " + ex.getMessage());
        }
    }
}