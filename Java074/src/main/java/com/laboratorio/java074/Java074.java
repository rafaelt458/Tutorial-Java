package com.laboratorio.java074;

import java.util.HashMap;
import java.util.Map;

public class Java074 {

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();

        params.put("usuario", "Laboratorio de Rafa");
        params.put("idioma", "Español");
        params.put("modo", "modo oscuro");

        procesarParametros(params);
    }

    public static void procesarParametros(Map<String, String> params) {
        if (params.containsKey("usuario")) {
            String usuario = params.get("usuario");
            System.out.println("Usuario: " + usuario);
        }

        if (params.containsKey("idioma")) {
            String idioma = params.get("idioma");
            System.out.println("Idioma: " + idioma);
        }

        if (params.containsKey("modo")) {
            String modo = params.get("modo");
            System.out.println("Modo: " + modo);
        }

        if (params.containsKey("password")) {
            String password = params.get("password");
            System.out.println("Password: " + password);
        }
    }
}
