package com.laboratorio.persistence.repository;

import com.laboratorio.core.model.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonaRepository {
    private final String url;
    private final String user;
    private final String password;

    public PersonaRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public Persona findById(int id) {
        String sql = """
                     SELECT id,
                            nombres,
                            apellidos,
                            fecha_nac,
                            experiencia
                        FROM    personas
                        WHERE id = ?
                     """;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Persona(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getObject("fecha_nac", LocalDate.class),
                            rs.getInt("experiencia")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error consultando en la base de datos", e);
        }

        return null;
    }
}