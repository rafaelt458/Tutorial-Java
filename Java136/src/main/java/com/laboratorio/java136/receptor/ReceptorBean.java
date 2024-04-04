package com.laboratorio.java136.receptor;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "TutorialTopic")
})
public class ReceptorBean implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(ReceptorBean.class);
    
    @PostConstruct
    public void inicializar() {
        logger.info("Se construyó el MDB del Topic TutorialTopic");
    }

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            
            String tipo = message.getStringProperty("TipoMensaje");
            logger.info("Se recibió mensaje de tipo:  " + tipo);
            
            switch (tipo) {
                case "Prueba":
                    logger.info("Mensaje recibido: " + message.getText());
                    break;
                case "Persona":
                    logger.info("Persona recibida: " + message.getText());
                    break;
                default:
                    logger.warn("Mensaje no soportado.");
                    break;
            }
        } catch (JMSException e) {
            logger.error("Error procesando mensaje: " + e.getMessage());
        }
    }
}