package com.laboratorio.java145;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Java145 {
    private static Logger log = LogManager.getLogger(Java145.class);
    private static String lastEvent;

    public static void main(String[] args) {
        CloseableHttpClient httpClient;
        String url = "https://mstdn.social/api/v1/streaming/public";
        String access_token = "<REEMPLAZAR CON EL TOKEN OBTENIDO>";
        
        try {
            httpClient = HttpClients.createDefault();
            
            List<NameValuePair> queryParameters = new ArrayList<>();
            queryParameters.add(new BasicNameValuePair("only_media", "false"));
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameters(queryParameters);
            
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("Authorization", "Bearer " + access_token);
            get.setHeader("Content-Type", "application/json");
            
            CloseableHttpResponse response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() != 200) {
                httpClient.close();
                log.error("Error en la respuesta HTTP. Código: " + response.getStatusLine().getStatusCode());
                System.exit(-1);
            }
            
            log.info("Se estableció la conexión con el Stream correctamente");
            
            String inputLine;
            byte[] bytes;
            String utf8EncodedString;
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((inputLine = reader.readLine()) != null) {
                if (inputLine.trim().length() > 0) {
                    bytes = inputLine.trim().getBytes(StandardCharsets.UTF_8);
                    utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
                    
                    procesarMensaje(utf8EncodedString);
                }
            }
            
            log.info("Finalizando la aplicación");
            
            reader.close();
            httpClient.close();
        } catch (Exception e) {
            log.error("Hubo un error procesando el stream: " + e.getMessage());
        }
    }
    
    private static void procesarMensaje(String mensaje) {
        log.info("Se recibió el mensaje: " + mensaje);
        
        if (mensaje.startsWith("event")) {
            lastEvent = mensaje;
        } else {
            if (mensaje.startsWith("data")) {
                if (lastEvent.contains("update")) {
                    log.info("Se ha publicado un nuevo estado");
                }
            }
        }
    }
}
