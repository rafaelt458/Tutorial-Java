package com.laboratorio.java132a.ejb;

import javax.ejb.Local;

@Local
public interface BeanForTestLocal {
    String localFunction();
}