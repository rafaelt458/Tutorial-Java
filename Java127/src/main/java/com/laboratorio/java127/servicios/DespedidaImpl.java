package com.laboratorio.java127.servicios;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DespedidaImpl implements Despedida {

    @Override
    public String despedirse() {
        return "Adios amigos";
    }
}