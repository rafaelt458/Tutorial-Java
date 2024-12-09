package com.laboratorio.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

public class CustomOrderer implements MethodOrderer {

    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors()
                .sort((m1, m2) -> {
                    return m2.getDisplayName().compareTo(m1.getDisplayName());
                });
    }    
}
