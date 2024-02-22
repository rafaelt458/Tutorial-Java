package com.laboratorio.java127.rest;

import com.laboratorio.java127.calificadores.HelloService1Qualifier;
import com.laboratorio.java127.calificadores.HelloService2Qualifier;
import com.laboratorio.java127.interceptor.InterceptorDeSaludo;
import com.laboratorio.java127.servicios.Despedida;
import com.laboratorio.java127.servicios.HelloService;
import com.laboratorio.java127.servicios.HelloServiceImpl;
import com.laboratorio.java127.utiles.SaludoPersonalizado;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
//@RequestScoped
//@Dependent
@Path("/hello")
// @Interceptors({InterceptorDeSaludo.class})
public class HelloWS {
    private static final Logger logger = LoggerFactory.getLogger(HelloWS.class);
    
   @Inject
   // @Named("HelloService2Impl")
    @HelloService2Qualifier
    private HelloService helloService;
    
    @Inject
    private SaludoPersonalizado saludoPersonalizado;
    
    @Inject
    @Any
    private Instance<HelloService> saludos;
    
    @Inject
    private Despedida despedida;
    
    /* @Inject
    public void setHelloService(HelloService helloService) {
        logger.info("Inyectando la dependencia de HelloService");
        this.helloService = helloService;
    } */

    public HelloWS() {
    }

    /* @Inject
    public HelloWS(HelloServiceImpl helloService) {
        logger.info("Inyectando la dependencia de HelloService");
        this.helloService = helloService;
    } */
    
    @GET
    @Interceptors({InterceptorDeSaludo.class})
    public String getHello() {
        // logger.info("Entrando al Webservice Hello");
        // return "Hello world";
        logger.info("Instancia WS: " + this.toString());
        logger.info("Instancia servicio: " + helloService.toString());
        return helloService.saludar();
    }
    
    @GET
    @Path("/saludos")
    public String getSaludos() {
        String str = "";
        
        for (HelloService helloService : saludos) {
            str += "<p>" + helloService.saludar() + "</p>";
        }
        
        return str;
    }
    
    @GET
    @Path("/produces")
    public String getSaludoPersonalizado() {
        return saludoPersonalizado.getMensaje();
    }
    
    @GET
    @Path("/despedida")
    public String cerrar() {
        return despedida.despedirse();
    }
}