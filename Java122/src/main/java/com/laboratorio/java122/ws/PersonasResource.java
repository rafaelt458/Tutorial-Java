package com.laboratorio.java122.ws;

import com.laboratorio.java122.modelo.Persona;
import com.laboratorio.java122.modelo.PersonaDB;
import com.laboratorio.java122.util.ConnectionPoolManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("personas")
@RequestScoped
public class PersonasResource {
    @Context
    private UriInfo context;
    
    private Connection connection;
    private PersonaDB personaDB;

    public PersonasResource() {
        try {
            connection = ConnectionPoolManager.getConnection();
            personaDB = new PersonaDB(connection);
        } catch (SQLException e) {
            connection = null;
            personaDB = null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("guardar")
    public Persona guardarPersona(Persona persona) {
        if (personaDB == null) {
            return new Persona();
        }
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto = sdf.format(persona.getFechaNac());
            String experiencia = String.valueOf(persona.getExperiencia());
            if (!personaDB.insertar(persona.getNombres(), persona.getApellidos(), fechaTexto, experiencia)) {
                return new Persona();
            }
        } catch (Exception ex) {
            return new Persona();
        }
        
        return persona;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar/{id}")
    public Persona buscarPersona(@PathParam("id") int id) {
        if (personaDB == null) {
            return new Persona();
        }
        
        Persona persona;
        
        try {
            persona = personaDB.buscar(id);
            if (persona == null) {
                return new Persona();
            }
        } catch (SQLException e) {
            return new Persona();
        }
        
        return persona;
    }
}
