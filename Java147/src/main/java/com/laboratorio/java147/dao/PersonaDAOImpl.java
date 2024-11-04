package com.laboratorio.java147.dao;

import com.laboratorio.java147.mapper.GenericRowMapper;
import com.laboratorio.java147.model.Persona;
import com.laboratorio.java147.repository.GenericJDBC;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonaDAOImpl implements PersonaDAO {
    private final String tableName;
    private final GenericJDBC<Persona> personaJDBC;
    private final GenericRowMapper<Persona> genericRowMapper;

    public PersonaDAOImpl(String url, String username, String password, String tableName) {
        this.tableName = tableName;
        this.personaJDBC = new GenericJDBC<>(url, username, password);
        this.genericRowMapper = new GenericRowMapper<>(Persona.class);
    }

    @Override
    public Optional<Persona> findById(int id) throws SQLException {
        Persona persona = this.personaJDBC.findById(this.tableName, "idpersonas", id, this.genericRowMapper);
        return Optional.ofNullable(persona);
    }

    @Override
    public List<Persona> findAll() throws SQLException {
        return this.personaJDBC.findAll(this.tableName, this.genericRowMapper);
    }

    @Override
    public long count() throws SQLException {
        return this.personaJDBC.countRecords(this.tableName);
    }

    @Override
    public int insert(Persona persona) throws SQLException {
        String query = "INSERT INTO personas (Nombres, Apellidos, FechaNac, Experiencia) values (?, ?, ?, ?)";
        return personaJDBC.insertRecord(query, persona.getNombres(), persona.getApellidos(),
                persona.getFechaNac(), persona.getExperiencia());
    }

    @Override
    public boolean update(Persona persona) throws SQLException {
        String query = "UPDATE personas SET Nombres = ?, Apellidos = ?, FechaNac = ?, Experiencia = ? WHERE idpersonas = ?";
        if (this.personaJDBC.updateRecord(query, persona.getNombres(), persona.getApellidos(), persona.getFechaNac(), persona.getExperiencia(), persona.getCodigo()) > 0) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean delete(Persona persona) throws SQLException {
        String query = "DELETE FROM personas WHERE idpersonas = ?";
        if (this.personaJDBC.deleteRecord(query, persona.getCodigo()) > 0) {
            return true;
        }
        
        return false;
    }
}