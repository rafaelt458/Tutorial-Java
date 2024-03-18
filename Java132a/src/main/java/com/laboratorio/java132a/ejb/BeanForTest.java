package com.laboratorio.java132a.ejb;

import javax.ejb.Stateless;

@Stateless
public class BeanForTest implements BeanForTestLocal, BeanForTestRemote {
    @Override
    public String localFunction() {
        return "Texto que proviene de la función local";
    }

    @Override
    public String remoteFunction() {
        return "Texto que proviene de la función remota";
    }   
}