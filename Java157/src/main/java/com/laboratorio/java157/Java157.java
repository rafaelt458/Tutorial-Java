package com.laboratorio.java157;

import com.laboratorio.java157.config.PersonaConfig;

public class Java157 {

    public static void main(String[] args) {
        PersonaConfig config = PersonaConfig.getInstance();
        System.out.println("Url: " + config.getProperty("url"));
        
        
        String user = PersonaConfig.getInstance().getProperty("user");
        System.out.println("User: " + user);
        
        
        String clave = PersonaConfig.getInstance().getProperty("password");
        System.out.println("Clave: " + clave);
        
        
        String table = PersonaConfig.getInstance().getProperty("table");
        System.out.println("Table: " + table);
    }
}