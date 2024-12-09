package com.laboratorio.repository;

import com.laboratorio.java152.config.PersonaConfig;
import com.laboratorio.java152.mapper.GenericRowMapper;
import com.laboratorio.java152.mapper.RowMapper;
import com.laboratorio.java152.model.Persona;
import com.laboratorio.java152.repository.GenericJDBC;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GenericJDBCTest {
    private static final Logger log = LogManager.getLogger(GenericJDBCTest.class);
    private GenericJDBC<Persona> genericJDBC;
    private RowMapper<Persona> rowMapper;
    private static int codigo;
    
    @BeforeEach
    public void initTest() {
        PersonaConfig config = PersonaConfig.getInstance();
        String url = config.getProperty("url");
        String user = config.getProperty("user");
        String password = config.getProperty("password");
        genericJDBC = new GenericJDBC<>(url, user, password);
        rowMapper = new GenericRowMapper<>(Persona.class);
    }
    
    @AfterEach
    public void closeTest() {
    }
    
    @Test
    @Order(1)
    public void testCountRecords() throws SQLException {
        long valorEsperado = 14;
        String table = "personas";
        
        long result = genericJDBC.countRecords(table);
        
        assertEquals(valorEsperado, result);
        assertTrue(result >= 0);
        assertInstanceOf(Long.class, result);
    }
    
    @Test
    @Order(2)
    public void testCountRecords_error() {
        String table = "personas_error";
        
        SQLException exception = assertThrows(SQLException.class, () -> {
            genericJDBC.countRecords(table);
        });
        
        log.info("Error: " + exception.getMessage());
    }
    
    @Test
    @Order(3)
    public void testFindById() throws SQLException {
        String nombreEsperado = "Angel";
        String apellidoEsperado = "Nieto";
        int experienciaEsperada = 9;
        String table = "personas";
        int codigoAbuscar = 1;
        
        Persona persona = genericJDBC.findById(table, "idpersonas", codigoAbuscar, rowMapper);
        log.info("Persona: " + persona.toString());
        
        assertEquals(nombreEsperado, persona.getNombres());
        assertEquals(apellidoEsperado, persona.getApellidos());
        assertEquals(experienciaEsperada, persona.getExperiencia());
    }
    
    @Test
    @Order(3)
    public void testFindByInexistingId() throws SQLException {
        String table = "personas";
        int codigoAbuscar = 0;
        
        Persona persona = genericJDBC.findById(table, "idpersonas", codigoAbuscar, rowMapper);
        
        assertTrue(persona == null);
    }
    
    @Test
    @Order(4)
    public void testFindAll() throws SQLException {
        long valorEsperado = 14;
        String table = "personas";
        
        List<Persona> personas = genericJDBC.findAll(table, rowMapper);
        for (Persona persona : personas) {
            log.info("Persona: " + persona.toString());
        }
        
        assertEquals(valorEsperado, personas.size());
    }
    
    @Test
    @Order(5)
    public void testInsertRecord() throws SQLException {
        String query = "INSERT INTO personas (Nombres, Apellidos, FechaNac, Experiencia) values (?, ?, ?, ?)";
        
        LocalDate date = LocalDate.of(1999, 8, 28);
        Date fechaNac = Date.valueOf(date);
        codigo = genericJDBC.insertRecord(query, "Raul", "Gavidia", fechaNac, 5);
        
        log.info("Se ha insertado la persona con código: " + codigo);
        
        assertTrue(codigo > 0);
    }
    
    @Test
    @Order(6)
    public void testUpdateRecord() throws SQLException {
        String query = "UPDATE personas SET Nombres = ?, Apellidos = ?, FechaNac = ?, Experiencia = ? WHERE idpersonas = ?";
        
        LocalDate date = LocalDate.of(1997, 9, 28);
        Date fechaNac = Date.valueOf(date);
        int result = genericJDBC.updateRecord(query, "Raul", "Gavidia", fechaNac, 6, codigo);
        
        log.info("Se ha modificado la persona con código: " + codigo);
        
        assertEquals(1, result);
    }
    
    @Test
    @Order(7)
    public void testDeleteRecord() throws SQLException {
        String query = "DELETE FROM personas WHERE idpersonas = ?";
        
        int result = genericJDBC.deleteRecord(query, codigo);
        
        log.info("Se ha eliminado la persona con código: " + codigo);
        
        assertEquals(1, result);
    }
}