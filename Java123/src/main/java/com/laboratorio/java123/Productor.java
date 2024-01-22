package com.laboratorio.java123;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

/**
 *
 * @author Rafael
 */
public class Productor implements Runnable {
    private final TopicSession session;
    private final TopicPublisher publisher;
    
    public Productor(TopicConnection connection, Topic topic) throws Exception {
        this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        this.publisher = this.session.createPublisher(topic);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Message message = this.session.createTextMessage(String.format("Mensaje número %02d", i+1));
                this.publisher.publish(message);
                Thread.sleep(1000);
            }
        } catch (InterruptedException | JMSException e) {
            System.out.println("Error al publicar un mensaje!");
        }
    }
    
    public void cerrar() throws Exception {
        publisher.close();
        session.close();
    }
}