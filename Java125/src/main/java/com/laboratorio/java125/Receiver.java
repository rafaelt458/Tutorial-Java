package com.laboratorio.java125;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laboratorio.java125.modelo.Persona;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Receiver implements MessageListener {
    private final int id;
    private final QueueSession session;
    private final QueueReceiver receiver;

    public Receiver(int id, QueueConnection connection, Queue queue) throws Exception {
        this.id = id;
        this.session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        this.receiver = this.session.createReceiver(queue);
        this.receiver.setMessageListener(this);
    }

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            System.out.println("El receptor " + this.id + " recibió el mensaje: " + message.getJMSMessageID());
            String tipoMensaje = message.getJMSType();
            switch (tipoMensaje) {
                case "Persona":
                    tratarPersona(message.getText(), message.getJMSTimestamp(), message.getStringProperty("Personaliza"));
                    break;
                case "Mensaje":
                default:
                    tratarMensaje(message.getText());
                    break;
            }
        } catch (JsonProcessingException | JMSException e) {
            System.out.println("Error al tratar un mensaje del receptor " + id);
        }
    }
    
    private void tratarMensaje(String mensaje) {
        System.out.printf("El receptor %d recibe el mensaje: %s\n", id, mensaje);
    }
    
    private void tratarPersona(String personaStr, long creacion, String otherInfo) throws JsonProcessingException {
        System.out.println("Persona JSON: " + personaStr);
        ObjectMapper objectMapper = new ObjectMapper();
        Persona persona = objectMapper.readValue(personaStr, Persona.class);
        System.out.printf("El receptor %d recibe la persona: %s\n", id, persona.toString());
        long tiempo = System.currentTimeMillis() - creacion;
        System.out.println("El mensaje se procesó en " + tiempo + " milisegundos.");
        System.out.println("Información adicional: " + otherInfo);
    }
    
    public void cerrar() throws Exception {
        receiver.close();
        session.close();
    }
}