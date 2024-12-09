package com.laboratorio.java152.dao;

import com.laboratorio.java152.model.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PersonaDAO {
    Optional<Persona> findById(int id) throws SQLException;

    List<Persona> findAll() throws SQLException;

    long count() throws SQLException;

    int insert(Persona persona) throws SQLException;

    boolean update(Persona persona) throws SQLException;

    boolean delete(Persona persona) throws SQLException;
}