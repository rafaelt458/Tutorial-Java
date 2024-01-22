package com.laboratorio.java123;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Java123 {

    public static void main(String[] args) {
        String usuario = "laboratorio";
        String clave = "laboratorio";
        
        System.out.println("Iniciando la aplicación!");
        
        // Propiedades para crear el contexto
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, usuario);
        env.put(Context.SECURITY_CREDENTIALS, clave);
        
        // Creación del contexto que nos permite crear referencias a los objetos registrados en el servcidor de aplicaciones
        InitialContext ic;
        try {
            ic = new InitialContext(env);
        } catch (NamingException e) {
            System.out.println("Error al crear el contexto inicial");
            return;
        }
        System.out.println("El contexto inicial ha sido creado");
        
        // Crear la TopicConnectionFactory
        TopicConnectionFactory connectionFactory;
        try {
            connectionFactory = (TopicConnectionFactory)ic.lookup("jms/RemoteConnectionFactory");
        } catch (NamingException e) {
            System.out.println("Error al crear al TopicConnectionFactory");
            return;
        }
        System.out.println("La TopicConnectionFactory ha sido creada");
        
        
        // Crear el TopicConnection
        TopicConnection connection;
        try {
            connection = connectionFactory.createTopicConnection(usuario, clave);
        } catch (JMSException e) {
            System.out.println("Error al crear al TopicConnection");
            return;
        }
        System.out.println("La TopicConnection ha sido creada");
        
        // Obtener el acceso al topic
        Topic topic;
        try {
            topic = (Topic)ic.lookup("jms/topic/tutorialtopic");
        } catch (NamingException e) {
            System.out.println("Error al obtener al Topic");
            return;
        }
        System.out.println("El topic ha sido obtenido!");
        
        
        Productor productor = null;
        Consumidor consumidor1 = null;
        Consumidor consumidor2 = null;
        Consumidor consumidor3 = null;
        
        // Iniciar el envío y recepción de mensajes
        try {
            connection.start();
            productor = new Productor(connection, topic);
            consumidor1 = new Consumidor(1, connection, topic);
            consumidor2 = new Consumidor(2, connection, topic);
            consumidor3 = new Consumidor(3, connection, topic);
            
            System.out.println("Objetos del test creados!");

            Thread hilo = new Thread(productor);
            hilo.start();
            
            hilo.join();
            
        } catch (Exception e) {
            System.out.println("Se produjo un error durante la ejecución");
        }
        
        System.out.println("Finalización del proceso");
        
        try {
            connection.stop();
            if (productor != null) {
                productor.cerrar();
            }
            if (consumidor1 != null) {
                consumidor1.cerrar();
            }
            if (consumidor2 != null) {
                consumidor2.cerrar();
            }
            if (consumidor3 != null) {
                consumidor3.cerrar();
            }
            connection.close();
            ic.close();
        } catch (Exception e) {
            System.out.println("Error finalizando proceso");
        }
    }
}
