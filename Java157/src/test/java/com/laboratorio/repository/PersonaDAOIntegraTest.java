package com.laboratorio.repository;

import com.laboratorio.java157.config.PersonaConfig;
import com.laboratorio.java157.dao.PersonaDAO;
import com.laboratorio.java157.dao.PersonaDAOImpl;
import com.laboratorio.java157.model.Persona;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonaDAOIntegraTest {
    private static PersonaDAO personaDAO;
    
    @BeforeEach
    public void initTest() {
        PersonaConfig config = PersonaConfig.getInstance();
        String url = config.getProperty("url");
        String user = config.getProperty("user");
        String password = config.getProperty("password");
        String table = "personas";
        personaDAO = new PersonaDAOImpl(url, user, password, table);
    }
    
    @Test
    public void testFindById() throws SQLException {
        int codigoAbuscar = 1;
        
        Persona persona = personaDAO.findById(codigoAbuscar).get();
        
        assertEquals(codigoAbuscar, persona.getCodigo());
    }
    
    @Test
    public void testFindAll() throws SQLException {
        int valorEsperado = 14;
        
        List<Persona> personas = personaDAO.findAll();
        
        assertEquals(valorEsperado, personas.size());
    }
    
    @Test
    public void testCount() throws SQLException {
        long valorEsperado = 14;
        
        long resultado = personaDAO.count();
        
        assertEquals(valorEsperado, resultado);
    }
}