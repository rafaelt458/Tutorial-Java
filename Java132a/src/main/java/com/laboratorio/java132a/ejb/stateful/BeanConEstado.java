package com.laboratorio.java132a.ejb.stateful;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class BeanConEstado implements BeanConEstadoRemote {
    private List<Integer> valores;
    
    @PostConstruct
    public void inicializar() {
        System.out.println("Inicializando el bean con estado: " + this.toString());
        
        this.valores = new ArrayList<>();
    }
        
    @Override
    public String agregar(Integer valor) {
        this.valores.add(valor);
        
        return "Agregado el valor " + valor;
    }
    
    @Override
    public List<Integer> getValores() {
        return this.valores;
    }
    
    @PreDestroy
    public void finalizar() {
        System.out.println("Finalizando el bean con estado: " + this.toString());
    }
}