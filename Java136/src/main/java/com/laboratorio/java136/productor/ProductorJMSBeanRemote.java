package com.laboratorio.java136.productor;

import javax.ejb.Remote;

@Remote
public interface ProductorJMSBeanRemote {
    void enviarPersona(String personaJson);
}