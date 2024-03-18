package com.laboratorio.java132a.ejb;

import javax.ejb.Remote;

@Remote
public interface BeanForTestRemote {
    String remoteFunction();
}