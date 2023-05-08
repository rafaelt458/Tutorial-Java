package com.laboratorio.java065;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private Configuracion  configuracion;
    private boolean isConfig;
    
    public ConexionMySQL() {
        configuracion = new Configuracion();
        isConfig = configuracion.recuperar();
    }
    
    public Connection conectarMySQL() {
        if (!isConfig) {
            System.out.println("Hay un problema de configuración de la base de datos");
            return null;
        }
        
        String url = "jdbc:mysql://" + configuracion.getHostname() + ":" + configuracion.getPort() + "/" + configuracion.getDatabase() + "?useSSL=false";
        Connection conn;
        
        try {
            Class.forName(configuracion.getDriver());
            conn = DriverManager.getConnection(url, configuracion.getUsername(), configuracion.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        return conn;
    }
    
    public void cerrarConexionMySQL(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        
        System.out.println("Se ha cerrado la conexión MySQL");
    }
}