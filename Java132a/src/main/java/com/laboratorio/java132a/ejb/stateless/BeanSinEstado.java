package com.laboratorio.java132a.ejb.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BeanSinEstado {
    private int valor;
    
    @PostConstruct
    public void inicializacion() {
        this.valor = 0;
        System.out.println("Se ha creado el bean sin estado: " + this.toString());
    }
    
    public String incrementar() throws Exception {
        this.valor++;
        String str = "Mi valor actual es: " + this.valor;
        
        Thread.sleep(2000);
        
        return str;
    }
    
    @PreDestroy
    public void liberacion() {
        System.out.println("Se ha destruido el bean sin estado: " + this.toString());
    }
}