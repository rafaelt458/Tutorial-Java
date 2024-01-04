package com.laboratorio.java119.ws;

import com.laboratorio.java119.entidad.Persona;
import com.laboratorio.java119.servicio.PersonaDB;
import com.laboratorio.java119.util.ConnectionPoolManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "PersonaWebService")
public class PersonaWebService {
    private Connection connection;
    private PersonaDB personaDB;
    
    public PersonaWebService() {
        try {
            connection = ConnectionPoolManager.getConnection();
            personaDB = new PersonaDB(connection);
        } catch (SQLException e) {
            connection = null;
            personaDB = null;
        }
    }

    @WebMethod(operationName = "ListarPersonas")
    public List<Persona> listarPersonas() {
        if (personaDB == null) {
            return new ArrayList<>();
        }
        
        try {
            return personaDB.getPersonas();
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
    
    @WebMethod(operationName = "CrearPersona")
    public Resultado crearPersona(
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "fechaNac") String fechaNac,
            @WebParam(name = "experiencia") int experiencia) {
        
        if (personaDB == null) {
            return new Resultado(-1, "No hay conexión a la base datos");
        }
        
        String validaciones = personaDB.validar(nombres, apellidos, fechaNac, String.valueOf(experiencia));
        if (!validaciones.isEmpty()) {
            return new Resultado(-2, validaciones);
        }
        
        try {
            if (!personaDB.insertar(nombres, apellidos, fechaNac, String.valueOf(experiencia))) {
                return new Resultado(0, "Se ha presentado un error al insertar la persona");
            }
        } catch (Exception e) {
            return new Resultado(-3, "Se ha presentado un error desconocido al insertar la persona");
        }
        
        return new Resultado(1, "Se ha insertado la persona correctamente");
    }
}
