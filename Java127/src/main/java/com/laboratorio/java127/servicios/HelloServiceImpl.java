package com.laboratorio.java127.servicios;

import com.laboratorio.java127.calificadores.HelloService1Qualifier;
import com.laboratorio.java127.rest.HelloWS;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Dependent
//@ApplicationScoped
//@RequestScoped
@SessionScoped
// @Named("HelloServiceImpl")
@HelloService1Qualifier
public class HelloServiceImpl implements Serializable, HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    
    public HelloServiceImpl() {
    }
    
    @PostConstruct
    public void iniciar() {
        logger.info("Creando el bean HelloServiceImpl: " + this.toString());
    }
    
    @PreDestroy
    public void finalizar() {
        logger.info("Destruyendo el bean HelloServiceImpl: " + this.toString());
    }
    
    @Override
    public String saludar() {
        logger.info("Entrando a la función saludar() de HelloServiceImpl");
        return "Hello world desde HelloServiceImpl";
    }
}