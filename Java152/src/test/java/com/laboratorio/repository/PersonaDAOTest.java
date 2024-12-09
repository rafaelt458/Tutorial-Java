package com.laboratorio.repository;

import com.laboratorio.java152.dao.PersonaDAO;
import com.laboratorio.java152.dao.PersonaDAOImpl;
import com.laboratorio.java152.mapper.RowMapper;
import com.laboratorio.java152.model.Persona;
import com.laboratorio.java152.repository.GenericJDBC;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class PersonaDAOTest {
    @Mock
    private GenericJDBC genericJDBC;
    
    private PersonaDAO personaDAO;
    
    @BeforeEach
    public void initTest() {
        MockitoAnnotations.openMocks(this);
        String table = "personas";
        personaDAO = new PersonaDAOImpl(table, genericJDBC);
    }
    
    @Test
    public void testCount() throws SQLException {
        when(this.genericJDBC.countRecords(anyString()))
                .thenReturn(4L);
        long valorEsperado = 4L;
        
        long resultado = personaDAO.count();
        
        assertEquals(valorEsperado, resultado);
        verify(this.genericJDBC).countRecords(anyString());
    }
    
    @Test
    public void testFindById() throws SQLException {
        when (this.genericJDBC.findById(anyString(), anyString(), anyInt(), any(RowMapper.class)))
                .thenReturn(PersonaDataMock.personaMock());
        int codigoAbuscar = 1;
        
        Persona persona = personaDAO.findById(codigoAbuscar).get();
        
        assertEquals(codigoAbuscar, persona.getCodigo());
        assertEquals("Raul", persona.getNombres());
        verify(this.genericJDBC).findById(anyString(), anyString(), anyInt(), any(RowMapper.class));
    }
    
    @Test
    public void testFindAll() throws SQLException {
        when (this.genericJDBC.findAll(anyString(), any(RowMapper.class)))
                .thenReturn(PersonaDataMock.personaListMock());
        int valorEsperado = 4;
        
        List<Persona> personas = personaDAO.findAll();
        
        assertEquals(valorEsperado, personas.size());
        verify(this.genericJDBC).findAll(anyString(), any(RowMapper.class));
    }
    
    @Test
    public void testInsert() throws SQLException {
        when (this.genericJDBC.insertRecord(anyString(), anyString(), anyString(), any(Date.class), anyInt()))
                .thenReturn(5);
        
        int valorEsperado = 5;
        
        Persona persona = PersonaDataMock.personaMock();
        int resultado = personaDAO.insert(persona);
        
        assertEquals(valorEsperado, resultado);
        verify(this.genericJDBC).insertRecord(anyString(), anyString(), anyString(), any(Date.class), anyInt());
    }
    
    @Test
    public void testUpdate() throws SQLException {
        Persona persona = PersonaDataMock.personaMock();
        this.personaDAO.update(persona);
        
        verify(this.genericJDBC).updateRecord(anyString(), anyString(), anyString(), any(Date.class), anyInt(), anyInt());
    }
    
    @Test
    public void testDelete() throws SQLException {
        Persona persona = PersonaDataMock.personaMock();
        this.personaDAO.delete(persona);
        
        verify(this.genericJDBC).deleteRecord(anyString(), anyInt());
    }
}