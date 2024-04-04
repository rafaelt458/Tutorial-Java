package com.laboratorio.java136.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laboratorio.java136.modelo.Persona;
import com.laboratorio.java136.productor.ProductorJMSBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.jms.Message;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "PersonasController", urlPatterns = {"/PersonasController"})
public class PersonasController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(PersonasController.class);
    
    @EJB
    private ProductorJMSBean productorEJB;
    
    @Override
    public void init() {
        logger.info("Iniciando servlet!");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        logger.info("Se recibieron los datos de una persona");
        
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fechaNac = request.getParameter("fechaNac");
        String experiencia = request.getParameter("experiencia");
        
        enviarDatosPersona(nombres, apellidos, fechaNac, experiencia);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void enviarDatosPersona(String nombres, String apellidos, String fechaNac, String experiencia) {
        logger.info("Procesando los datos de la persona");
        
        Date fecha;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            fecha = formato.parse(fechaNac);
        } catch (ParseException e) {
            fecha = new Date();
        }
        
        int annos;
        
        try {
            annos = Integer.parseInt(experiencia);
        } catch (NumberFormatException e) {
            annos = 0;
        }
        
        Persona persona = new Persona(0, nombres, apellidos, fecha, annos);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(persona);
            Message message = productorEJB.getSession().createTextMessage(jsonString);
            message.setStringProperty("TipoMensaje", "Persona");
            productorEJB.enviarMensaje(message);
        } catch (Exception e) {
            logger.error("Error al enviar los datos de la persona");
            return;
        }
        
        logger.info("Se han enviado los datos de la persona existosamente");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
