package com.laboratorio.java127.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterceptorDeSaludo {
    private static final Logger logger = LoggerFactory.getLogger(InterceptorDeSaludo.class);
    
    @AroundInvoke
    private Object inspeccionar(InvocationContext context) throws Exception {
        logger.info("*** INTERCEPTOR *** Llamada desde el método: {}", context.getMethod().toString());
        
        // Lógica del interceptor
        
        return context.proceed();
        // return null;
    }
}