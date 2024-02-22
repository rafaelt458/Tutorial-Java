package com.laboratorio.java127.servicios;

import com.laboratorio.java127.calificadores.HelloService2Qualifier;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
// @Named("HelloService2Impl")
@HelloService2Qualifier
public class HelloService2Impl implements  Serializable, HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService2Impl.class);
    
    public HelloService2Impl() {
    }
    
    @PostConstruct
    public void iniciar() {
        logger.info("Creando el bean HelloService2Impl: " + this.toString());
    }
    
    @PreDestroy
    public void finalizar() {
        logger.info("Destruyendo el bean HelloService2Impl: " + this.toString());
    }
    
    @Override
    public String saludar() {
        logger.info("Entrando a la función saludar() de HelloService2Impl");
        return "Reciban un cordial saludo desde HelloService2Impl";
    }
}