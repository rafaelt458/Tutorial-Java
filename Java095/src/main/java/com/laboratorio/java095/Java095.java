package com.laboratorio.java095;

import com.laboratorio.java095.entidades.TwitterMessage;
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

public class Java095 {
    public static void llamarApiTwitter(String endpoint) {
        String URL = "https://api.twitter.com/2/";
        String URI = URL + endpoint;
        TwitterMessage twitterMessage = new TwitterMessage("Este es un tweet escrito desde mi aplicación Java095");
        
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
                    .header(HttpHeaders.AUTHORIZATION, "Bearer dGJvemFpYkJYTENKOEZ5bkZuczBUTGtRcXBuX3hIZDROZ09IVWRsVFZUdkZJOjE2OTI1MjIwMzM0Nzg6MToxOmF0OjE")
                    .post(Entity.entity(twitterMessage, MediaType.APPLICATION_JSON), Response.class);
            
            if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
                System.out.println("Se ha producido un error con código: " + response.getStatus());
                return;
            }
            
            String respuesta = response.readEntity(String.class);
            System.out.println("Respuesta: " + respuesta);
            
        } catch (Exception ex) {
            System.out.println("Error al llamar al API: " + ex.getMessage());
        }
    }
   
    public static void main(String[] args) {
        llamarApiTwitter("tweets");
    }
}