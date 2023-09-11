package com.laboratorio.java094;

import com.laboratorio.java094.entidades.MensajeChatGPT;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Java094 {
    public static void llamarChatGPT(String endpoint) {
        String URL = "https://api.openai.com/v1/";
        String URI = URL + endpoint;
        String prompt = "Eres un instructor de Java que hace tutoriales. ¿Cuál será tu próximo tutorial?";
        MensajeChatGPT mensajeChatGPT = new MensajeChatGPT("text-davinci-003", prompt, 1000, 0.7, 5);
        
        try {
            // Creamos la conexión al API
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URI);
            
            // Hacer la llamada al servicio
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer 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")
                    .post(Entity.entity(mensajeChatGPT, MediaType.APPLICATION_JSON), Response.class);
            
            // Comprobar la respuesta de ChatGPT
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                System.out.println("Se ha presentado un error con código: " + response.getStatus());
                return;
            }
            
            String respuesta = response.readEntity(String.class);
            System.out.println("Respuesta: " + respuesta);
        } catch (Exception ex) {
            System.out.println("Error al procesar la solicitud: " + ex.getMessage());
            System.out.println("Causa: " + ex.getCause().getMessage());
        }
    }

    public static void main(String[] args) {
        llamarChatGPT("completions");
    }
}