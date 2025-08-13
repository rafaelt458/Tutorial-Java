package com.laboratorio.java160.factory;

import com.laboratorio.java160.factory.control.IButton;
import com.laboratorio.java160.factory.control.ITextbox;

public interface GUIFactory {
    IButton createButton();
    ITextbox createTextbox();
}