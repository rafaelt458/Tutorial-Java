package com.laboratorio.java132b;

import com.laboratorio.java132a.ejb.BeanForTestRemote;
import com.laboratorio.java132a.ejb.stateful.BeanConEstado;
import com.laboratorio.java132a.ejb.stateful.BeanConEstadoRemote;
import java.util.Properties;
import java.util.Random;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Java132b {
    public static Integer aleatorio(int max) {
        Random r = new Random(System.currentTimeMillis());
        Integer valor = r.nextInt(max) + 1;
        System.out.println("Valor generado: " + valor);
        
        return valor;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciado la aplicación cliente");
        
        String usuario = "laboratorio";
        String clave = "laboratorio";
        
        // Propiedades para crear el contexto
        Properties entorno = new Properties();
        entorno.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        entorno.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        entorno.put(Context.SECURITY_PRINCIPAL, usuario);
        entorno.put(Context.SECURITY_CREDENTIALS, clave);
        
        // Crear el contexto
        InitialContext ic = new InitialContext(entorno);
        
        System.out.println("El contexto inicial ha sido creado");
        
        String URI = "ejb:/Java132a-1.0-SNAPSHOT/BeanForTest!com.laboratorio.java132a.ejb.BeanForTestRemote";
        
        BeanForTestRemote beanRemoto = (BeanForTestRemote)ic.lookup(URI);
        System.out.println("Llamada remota: " + beanRemoto.remoteFunction());
        
        URI = "ejb:/Java132a-1.0-SNAPSHOT/BeanConEstado!com.laboratorio.java132a.ejb.stateful.BeanConEstadoRemote?stateful";
        BeanConEstadoRemote beanConEstado = (BeanConEstadoRemote)ic.lookup(URI);
        
        for (int i = 0; i < 10; i++) {
            beanConEstado.agregar(aleatorio(20));
        }
        
        System.out.println("Valores: " + beanConEstado.getValores());
    }
}
