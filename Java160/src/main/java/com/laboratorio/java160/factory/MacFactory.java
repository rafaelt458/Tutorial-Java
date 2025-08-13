package com.laboratorio.java160.factory;

import com.laboratorio.java160.factory.control.IButton;
import com.laboratorio.java160.factory.control.ITextbox;
import com.laboratorio.java160.factory.control.MacButton;
import com.laboratorio.java160.factory.control.MacTextbox;

public class MacFactory implements GUIFactory {
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextbox createTextbox() {
        return new MacTextbox();
    }
}