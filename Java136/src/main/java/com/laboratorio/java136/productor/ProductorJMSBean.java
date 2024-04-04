package com.laboratorio.java136.productor;

import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@LocalBean
public class ProductorJMSBean implements ProductorJMSBeanRemote {
    private static final Logger logger = LoggerFactory.getLogger(ProductorJMSBean.class);
    private InitialContext ic;
    private TopicConnectionFactory connectionFactory;
    private TopicConnection connection;
    private Topic topic;
    private TopicSession session;
    private TopicPublisher publisher;
    
    @PostConstruct
    public void inicializar() {
        String usuario = "laboratorio";
        String clave = "laboratorio";
        
        logger.info("Iniciando la aplicación!");
        
        // Propiedades para crear el contexto
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, usuario);
        env.put(Context.SECURITY_CREDENTIALS, clave);
        
        // Creación del contexto que nos permite crear referencias a los objetos registrados en el servcidor de aplicaciones
        try {
            this.ic = new InitialContext(env);
            logger.info("El contexto inicial ha sido creado");
        
            // Crear la TopicConnectionFactory
            this.connectionFactory = (TopicConnectionFactory)ic.lookup("jms/RemoteConnectionFactory");
            logger.info("La TopicConnectionFactory ha sido creada");
        
        
            // Crear el TopicConnection
            this.connection = connectionFactory.createTopicConnection(usuario, clave);
            logger.info("La TopicConnection ha sido creada");
        
            // Obtener el acceso al topic
            this.topic = (Topic)ic.lookup("jms/topic/tutorialtopic");
            logger.info("El topic ha sido obtenido!");
        
            this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            this.publisher = this.session.createPublisher(topic);
        
            // Iniciar el envío y recepción de mensajes
            connection.start();
        } catch (JMSException | NamingException e) {
            logger.error("Error al iniciar JMS: " + e.getMessage());
        }
    }
    
    public void enviarMensaje(Message message) throws Exception {
        this.publisher.publish(message);
    }

    public TopicSession getSession() {
        return session;
    }
    
    @Override
    public void enviarPersona(String personaJson)  {
        logger.info("Se han recibido datos de una persona remota");
        
        try {
            Message message = this.session.createTextMessage(personaJson);
            message.setStringProperty("TipoMensaje", "Persona");
            this.enviarMensaje(message);
        } catch (Exception e) {
            logger.error("Error al enviar los datos de la persona remota");
            logger.error("Error: " + e.getMessage());
        }
        
        logger.info("Los datos de la persona remota han sido enviados");
    }
    
    @PreDestroy
    public void finalizar() {
        logger.info("Finalización del proceso");
        
        try {
            this.connection.stop();
            this.publisher.close();
            this.session.close();
            this.connection.close();
            this.ic.close();
        } catch (JMSException | NamingException e) {
            logger.error("Error finalizando proceso");
        }
    }
}
