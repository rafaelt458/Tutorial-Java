package com.laboratorio.java132a.ejb.stateful;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface BeanConEstadoRemote {
    String agregar(Integer valor);
    List<Integer> getValores();
}