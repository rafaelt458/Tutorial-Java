package com.laboratorio.java063;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Java063 {
    
    public static void mostrarCiudades(Connection conn) {
        Statement statement;
        ResultSet rs;
        int i = 0;
        
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("select * from city");
            
            while (rs.next()) {
                i++;
                System.out.println(i + "-) " + rs.getString("Name"));
            }
            
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        Connection connection;
        
        connection = conexionMySQL.conectarMySQL();
        if (connection != null) {
            System.out.println("La conexión con MySql ha sido establecida!");
            
            mostrarCiudades(connection);
            
            conexionMySQL.cerrarConexionMySQL(connection);
        } else {
            System.out.println("Error al establer la conexión con MySql!");
        }
    }
}