package com.laboratorio.java160.factory.control;

public class MacButton implements IButton {
    @Override
    public void paint() {
        System.out.println("Botón dibujado al estilo Mac");
    }   
}