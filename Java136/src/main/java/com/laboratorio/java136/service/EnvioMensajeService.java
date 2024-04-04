package com.laboratorio.java136.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laboratorio.java136.modelo.Persona;
import com.laboratorio.java136.productor.ProductorJMSBean;
import javax.ejb.EJB;
import javax.jms.Message;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("mensaje")
public class EnvioMensajeService {
    private static final Logger logger = LoggerFactory.getLogger(EnvioMensajeService.class);
    
    @EJB
    private ProductorJMSBean productor;
    
    @GET
    public String enviarMensaje() {
        logger.info("Enviando un mensaje");
        try {
            Message message = productor.getSession().createTextMessage("Mensaje de prueba");
            message.setStringProperty("TipoMensaje", "Prueba");
            productor.enviarMensaje(message);
        } catch (Exception e) {
            logger.error("Error enviando mensaje: " + e.getMessage());
        }
        
        return "Mensaje enviado";
    }
    
    @POST
    @Path("/persona")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona crearPersona(Persona persona) {
        logger.info("Creando una nueva persona");
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(persona);
            Message message = productor.getSession().createTextMessage(jsonString);
            message.setStringProperty("TipoMensaje", "Persona");
            productor.enviarMensaje(message);
        } catch (Exception e) {
            logger.error("Error creando persona: " + e.getMessage());
            return null;
        }
        
        return persona;
    }
}