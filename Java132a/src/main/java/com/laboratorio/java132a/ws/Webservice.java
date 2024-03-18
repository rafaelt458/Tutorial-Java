package com.laboratorio.java132a.ws;

import com.laboratorio.java132a.ejb.BeanForTestLocal;
import com.laboratorio.java132a.ejb.BeanForTestRemote;
import com.laboratorio.java132a.ejb.stateful.BeanConEstado;
import com.laboratorio.java132a.ejb.stateless.BeanSinEstado;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/test")
public class Webservice {
    @EJB
    private BeanForTestLocal beanLocal;
    
    @EJB
    private BeanForTestRemote beanRemote;
    
    @EJB
    private BeanSinEstado beanSinEstado;
    
    @EJB
    private BeanConEstado beanConEstado;
    
    @GET
    @Path("/local")
    public String ejecutarLocal() {
        return beanLocal.localFunction();
    }
    
    @GET
    @Path("/remote")
    public String ejecutarRemote() {
        return beanRemote.remoteFunction();
    }
    
    @GET
    @Path("/stateless")
    public String incrementar() throws Exception {
        return beanSinEstado.incrementar();
    }
    
    @GET
    @Path("{valor}")
    public String agregar(@PathParam("valor") String valor) {
        Integer valorInt = Integer.valueOf(valor);
        return beanConEstado.agregar(valorInt);
    }
    
    @GET
    public String getValores() {
        StringBuilder sb =  new StringBuilder();
        
        for (Integer valor : beanConEstado.getValores()) {
            if (sb.toString().length() > 0) {
                sb.append(" - ");
            }
            sb.append(String.valueOf(valor));
        }
        
        return sb.toString();
    }
}