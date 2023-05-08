package com.laboratorio.java065;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private String driver;
    private String database;
    private String hostname;
    private String port;
    private String username;
    private String password;
    
    public Configuracion() {
    }
    
    public boolean recuperar() {
        Properties config = new Properties();
        
        try {
            FileInputStream fis = new FileInputStream("configuracion.properties");
            config.load(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        driver = config.getProperty("driver", "com.mysql.cj.jdbc.Driver");
        database = config.getProperty("database", "world");
        hostname = config.getProperty("hostname", "localhost");
        port = config.getProperty("port", "3306");
        username = config.getProperty("username", "root");
        password = config.getProperty("password", "1234");
        
        return true;
    }

    public String getDriver() {
        return driver;
    }

    public String getDatabase() {
        return database;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}