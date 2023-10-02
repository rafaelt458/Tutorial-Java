package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class FrankfurterAPI {
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
            
            return jsonStr;
        } catch (Exception ex) {
            System.out.println("Error al procesar la petición: " + ex.getMessage());
            return null;
        }
    }
}