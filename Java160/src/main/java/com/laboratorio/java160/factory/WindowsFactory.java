package com.laboratorio.java160.factory;

import com.laboratorio.java160.factory.control.IButton;
import com.laboratorio.java160.factory.control.ITextbox;
import com.laboratorio.java160.factory.control.WindowsButton;
import com.laboratorio.java160.factory.control.WindowsTextbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ITextbox createTextbox() {
        return new WindowsTextbox();
    }
}