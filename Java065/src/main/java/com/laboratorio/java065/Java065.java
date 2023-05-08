package com.laboratorio.java065;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java065 {
    
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
    
    public static void insertarCiudades(Connection conn, String pais, String nomCiudad1, String nomCiudad2) {
        PreparedStatement ps;
        
        try {
            // Iniciar la transacción
            conn.setAutoCommit(false);
            
            ps = conn.prepareStatement("insert into city (Name, CountryCode, District) values (?, ?, ?)");
            ps.setString(1, nomCiudad1);
            ps.setString(2, pais);
            ps.setString(3, "distrito1");
            ps.execute();
            
            ps = conn.prepareStatement("insert into city2 (Name, CountryCode, District) values (?, ?, ?)");
            ps.setString(1, nomCiudad2);
            ps.setString(2, pais);
            ps.setString(3, "distrito1");
            ps.execute();
            
            // Confirmar la transacción
            conn.commit();
            
        } catch(SQLException ex) {
            try {
                // Revertir la transacción
                conn.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex.getMessage());
            }
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        Connection connection;
        
        connection = conexionMySQL.conectarMySQL();
        if (connection != null) {
            System.out.println("La conexión con MySql ha sido establecida!");
            
            insertarCiudades(connection, "ESP", "Ciudad3", "Ciudad4");
            
            mostrarCiudades(connection);
            
            conexionMySQL.cerrarConexionMySQL(connection);
        } else {
            System.out.println("Error al establer la conexión con MySql!");
        }
    }
}