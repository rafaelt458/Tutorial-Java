package com.laboratorio.java122.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaDB {
    private Connection connection;

    public PersonaDB(Connection connection) {
        this.connection = connection;
    }
    
    public List<Persona> getPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        Persona persona;
        int codigo, experiencia;
        String nombres, apellidos;
        Date fechaNac;
        
        try {
            String query = "SELECT * FROM personas";
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                codigo = resultSet.getInt("idpersonas");
                nombres = resultSet.getString("nombres");
                apellidos = resultSet.getString("apellidos");
                fechaNac = resultSet.getDate("fechanac");
                experiencia = resultSet.getInt("experiencia");
                persona = new Persona(codigo, nombres, apellidos, fechaNac, experiencia);
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return personas;
    }
    
    public Persona buscar(int codigo) throws SQLException {
        Persona persona = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personas WHERE idpersonas = ?");
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setCodigo(codigo);
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setFechaNac(rs.getDate("fechanac"));
                persona.setExperiencia(rs.getInt("experiencia"));
            }
        } catch (SQLException e) {
            throw  e;
        }
        
        return persona;
    }
    
    public boolean insertar(String nombres, String apellidos, String fechaNac, String experiencia) throws Exception {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(fechaNac);
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            
            PreparedStatement ps = connection.prepareStatement("INSERT INTO personas(nombres, apellidos, fechanac, experiencia) VALUES (?, ?, ?, ?)");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setDate(3, fechaSQL);
            ps.setInt(4, Integer.parseInt(experiencia));
            
            int resultado = ps.executeUpdate();
            if (resultado == 0) {
                return false;
            }
        } catch (NumberFormatException | SQLException | ParseException e) {
            throw e;
        }
        
        return true;
    }
    
    public boolean editar(int codigo, String nombres, String apellidos, String fechaNac, String experiencia) throws Exception {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(fechaNac);
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            
            PreparedStatement ps = connection.prepareStatement("UPDATE personas SET nombres = ?, apellidos = ?, fechanac = ?, experiencia = ? WHERE idpersonas = ?");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setDate(3, fechaSQL);
            ps.setInt(4, Integer.parseInt(experiencia));
            ps.setInt(5, codigo);
            
            int resultado = ps.executeUpdate();
            if (resultado == 0) {
                return false;
            }
        } catch (NumberFormatException | SQLException | ParseException e) {
            throw e;
        }
        
        return true;
    }
    
    public boolean eliminar(int codigo) throws Exception {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM personas WHERE idpersonas = ?");
            ps.setInt(1, codigo);
            
            int resultado = ps.executeUpdate();
            if (resultado == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw e;
        }
        
        return true;
    }
    
    public String validar(String nombres, String apellidos, String fechaNac, String experiencia) {
        StringBuilder resultado = new StringBuilder("");
        
        if (nombres.isEmpty()) {
            resultado.append("<p>Los nombres no pueden estar vacíos.</p>");
        } else  {
            if (nombres.length() < 2) {
                resultado.append("<p>Los nombres deben tener al menos 2 caracteres.</p>");
            }
        }
        
        if (apellidos.isEmpty()) {
            resultado.append("<p>Los apellidos no pueden estar vacíos.</p>");
        } else  {
            if (nombres.length() < 2) {
                resultado.append("<p>Los apellidos deben tener al menos 2 caracteres.</p>");
            }
        }
        
        if (fechaNac.isEmpty()) {
            resultado.append("<p>La fecha de nacimiento no puede estar vacía.</p>");
        } else  {
            if (!fechaNac.matches("^(19|20)(((([02468][048])|([13579][26]))-02-29)|(\\d{2})-((02-((0[1-9])|1\\d|2[0-8]))|((((0[13456789])|1[012]))-((0[1-9])|((1|2)\\d)|30))|(((0[13578])|(1[02]))-31)))$")) {
                resultado.append("<p>La fecha tiene un formato incorrecto.</p>");
            }
        }
        
        if (experiencia.isEmpty()) {
            resultado.append("<p>La experiencia no puede estar vacía.</p>");
        } else  {
            if (!experiencia.matches("^[0-9]+$")) {
                resultado.append("<p>La experiencia debe ser un número.</p>");
            }
        }
        
        return resultado.toString();
    }
}