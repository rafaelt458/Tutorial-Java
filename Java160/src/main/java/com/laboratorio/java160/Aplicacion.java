package com.laboratorio.java160;

import com.laboratorio.java160.factory.GUIFactory;
import com.laboratorio.java160.factory.control.IButton;
import com.laboratorio.java160.factory.control.ITextbox;

public class Aplicacion {
    private final IButton button;
    private final ITextbox textbox;

    public Aplicacion(GUIFactory factory) {
        this.button = factory.createButton();
        this.textbox = factory.createTextbox();
    }
    
    public void paint() {
        this.button.paint();
        this.textbox.paint();
    }
}