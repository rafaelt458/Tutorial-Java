package com.laboratorio.java_110.controlador;

import com.laboratorio.java_110.modelo.Alumno;
import com.laboratorio.java_110.modelo.AlumnoDB;
import com.laboratorio.java_110.persistencia.ConnectionPoolManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlumnoController", urlPatterns = {"/alumnos"})
public class AlumnoController extends HttpServlet {
    private static final Logger log = Logger.getLogger(AlumnoController.class.getName());
    private Connection connection = null;
    
    @Override
    public void init() {
        log.log(Level.INFO, "Obteniendo conexión a base de datos");
        try {
            connection = ConnectionPoolManager.getConnection();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error Obteniendo conexión a base de datos!");
            connection = null;
            return;
        }
        log.log(Level.INFO, "Conexión realizada!");
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AlumnoDB alumnoDB = new AlumnoDB();
        List<Alumno> lista = alumnoDB.obtenerAlumnos();
        
        request.setAttribute("alumnos", lista);
        if (connection != null) {
            request.setAttribute("conexion", "Conexión establecida!");
        } else {
            request.setAttribute("conexion", "Error de conexión de base datos");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAlumnos.jsp");
        dispatcher.forward(request, response);
    }
}
