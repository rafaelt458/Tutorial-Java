package com.laboratorio.interfaces;

import com.laboratorio.interfaces.banco.AtencionTelefonica;
import com.laboratorio.interfaces.banco.CajeroAutomatico;
import com.laboratorio.interfaces.banco.Website;

public class Java047 {

    public static void main(String[] args) {
        CajeroAutomatico cajero;
        
        cajero = new CajeroAutomatico();
        cajero.consultarSaldo();
        cajero.ultimosMovimientos();
        cajero.transferirSaldo();

        AtencionTelefonica telefono;
         
        telefono = new AtencionTelefonica();
        telefono.consultarSaldo();
        telefono.ultimosMovimientos();
        telefono.transferirSaldo();
        
        Website web;
        
        web = new Website();
        web.consultarSaldo();
        web.ultimosMovimientos();
        web.transferirSaldo();
    }
}
