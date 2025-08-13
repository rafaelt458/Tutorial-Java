package com.laboratorio.java160.factory.control;

public class MacTextbox implements ITextbox {
    @Override
    public void paint() {
        System.out.println("Textbox dibujado al estilo Mac");
    }
}
