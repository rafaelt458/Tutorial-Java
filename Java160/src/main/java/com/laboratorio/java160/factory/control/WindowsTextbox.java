package com.laboratorio.java160.factory.control;

public class WindowsTextbox implements ITextbox {
    @Override
    public void paint() {
        System.out.println("Textbox dibujado al estilo Windows");
    }
}