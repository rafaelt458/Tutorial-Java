package com.laboratorio.java099.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrankfurterAPI {
    Logger logger = LogManager.getLogger(FrankfurterAPI.class);
    private final String URL;

    public FrankfurterAPI(String URL) {
        this.URL = URL;
    }
    
    public String ejecutar(FrankfurterAPIEnum operacion) {
        String URI;
        
        switch (operacion) {
            case LATEST:
            default:
                    URI = URL + "/latest";
                    break;
            case CURRENCIES:
                    URI = URL + "/currencies";
                    break;
        }
        
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(URI);
            
            // Hacer la llamada al API
            String jsonStr = target.request(MediaType.APPLICATION_JSON).get(String.class);
            logger.info("[API] Llamada realizada correctamente [" + operacion + "]");
            
            return jsonStr;
        } catch (Exception ex) {
            logger.error("Error al procesar la petición: " + ex.getMessage());
            return null;
        }
    }
}