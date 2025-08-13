package com.laboratorio.java160;

import com.laboratorio.java160.factory.GUIFactory;
import com.laboratorio.java160.factory.MacFactory;
import com.laboratorio.java160.factory.OSEnum;
import com.laboratorio.java160.factory.WindowsFactory;

public class Java160 {

    public static void main(String[] args) throws Exception {
        OSEnum os = OSEnum.MACOS;
        GUIFactory factory;
        
        switch (os) {
            case WINDOWS:
                factory = new WindowsFactory();
                break;
            case MACOS:
                factory = new MacFactory();
                break;
            default:
                throw new Exception("El sistema operativo no está implementado");
        }
        
        Aplicacion aplicacion = new Aplicacion(factory);
        aplicacion.paint();
    }
}