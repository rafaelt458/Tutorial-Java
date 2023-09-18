package com.laboratorio.java096;

import com.laboratorio.java096.entidades.MensajeChatGPT;
import com.laboratorio.java096.entidades.RespuestaChatGPT;
import com.laboratorio.java096.entidades.TwitterMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient43Engine;

public class Java096 {
    public static String llamarChatGPT(String endpoint) {
        String URL = "https://api.openai.com/v1/";
        String URI = URL + endpoint;
        String prompt = "Eres un instructor de Java que hace tutoriales. Dime cual será tu próximo tutorial. Tu respuesta debe tener menos de 280 caracteres.";
        MensajeChatGPT mensajeChatGPT = new MensajeChatGPT("text-davinci-003", prompt, 500, 0.7, 1);
        
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
                return null;
            }
            
            String respuesta = response.readEntity(String.class);
            System.out.println("Respuesta: " + respuesta);
            
            // Procesar la respuesta y devolver texto
            RespuestaChatGPT respuestaChatGPT = new RespuestaChatGPT(respuesta);
            return respuestaChatGPT.getChoices().get(0).getText();
        } catch (Exception ex) {
            System.out.println("Error al procesar la solicitud: " + ex.getMessage());
            System.out.println("Causa: " + ex.getCause().getMessage());
            return null;
        }
    }
    
    public static void llamarApiTwitter(String endpoint, String texto) {
        String URL = "https://api.twitter.com/2/";
        String URI = URL + endpoint;
        TwitterMessage twitterMessage = new TwitterMessage(texto);
        
        try {
            // Creamos la conexión al API de Twitter
            RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
            HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            ApacheHttpClient43Engine engine = new ApacheHttpClient43Engine(httpClient);
            ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
                      
            //Client client = ClientBuilder.newClient();
            
            WebTarget target = client.target(URI);
            
            // Hacemos la llamada al API
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer a2FMM0ZWcmdkOURBUUtTUkIxUzdJLUdFM3Z2TWQwYTZtMURBVUNaMGRWZHBSOjE2OTI1NDc2MTgzMTI6MToxOmF0OjE")
                    .post(Entity.entity(twitterMessage, MediaType.APPLICATION_JSON), Response.class);
            
            if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
                System.out.println("Se ha producido un error con código: " + response.getStatus());
                String respuesta = response.readEntity(String.class);
                System.out.println("Respuesta: " + respuesta);
                return;
            }
            
            String respuesta = response.readEntity(String.class);
            System.out.println("Respuesta: " + respuesta);
            
        } catch (IllegalArgumentException | NullPointerException ex) {
            System.out.println("Error al llamar al API: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String texto = llamarChatGPT("completions");
        if (texto != null) {
            llamarApiTwitter("tweets", texto);
        }
    }
}
