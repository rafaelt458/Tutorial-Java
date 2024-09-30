package com.laboratorio.java146;

import com.google.gson.Gson;
import com.laboratorio.java146.modelo.Event;
import com.laboratorio.java146.modelo.Subscription;
import java.net.URI;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;


public class Java146 {
    private static final Logger log = LogManager.getLogger(Java146.class);
    private static Gson gson = new Gson();
    
    public static void main(String[] args) {
        try {
            URI uri = new URI("wss://mstdn.social/api/v1/streaming");
            String token = "<REEMPLAZAR CON EL TOKEN OBTENIDO>";
            
            Map<String, String> headers = Map.of("Authorization", "Bearer " + token);
            WebSocketClient client = new WebSocketClient(uri, headers) {
                @Override
                public void onOpen(ServerHandshake sh) {
                    log.info("Se ha abierto la conexión: " + sh.getHttpStatusMessage());
                    
                    Subscription subscription = new Subscription("subscribe", "public");
                    String json = gson.toJson(subscription);
                    log.info("Creando la subscripción: " + json);
                    send(json);
                }
                
                @Override
                public void onMessage(String mensaje) {
                    log.info("Se recibió el mensaje: " + mensaje);
                    
                    procesarMensaje(mensaje);
                }
                
                @Override
                public void onClose(int code, String reason, boolean remote) {
                    log.info("Se ha cerrado la conexión. Motivo: " + reason);
                }
                
                @Override
                public void onError(Exception ex) {
                    log.error(("Ha ocurrido el siguente error: " + ex.getMessage()));
                }
            };
            
            client.connect();
        } catch (Exception e) {
            log.error("Error procesando el Stream de Mastodon: " + e.getMessage());
        }
    }
    
    private static void procesarMensaje(String mensaje) {
        Event event = gson.fromJson(mensaje, Event.class);
        if (event.getEvent().equals("update")) {
            log.info("Procesar el payload: " + event.getPayload());
        }
    }
}
