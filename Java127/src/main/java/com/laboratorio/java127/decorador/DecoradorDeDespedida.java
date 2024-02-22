package com.laboratorio.java127.decorador;

import com.laboratorio.java127.servicios.Despedida;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Decorator
public class DecoradorDeDespedida implements Despedida {
    private static final Logger logger = LoggerFactory.getLogger(DecoradorDeDespedida.class);
    
    @Inject
    @Delegate
    private Despedida service;

    @Override
    public String despedirse() {
        String despedidaOriginal = service.despedirse();
        logger.info("*** DECORADOR *** Despedida original: " + despedidaOriginal);
        return "<p><b>" + despedidaOriginal + "!</b></p><p>Nueva línea agregada por el decorador</p>";
    }   
}