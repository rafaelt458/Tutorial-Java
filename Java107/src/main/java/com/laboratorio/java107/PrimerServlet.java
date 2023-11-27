package com.laboratorio.java107;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PrimerServlet", urlPatterns = {"/PrimerServlet"})
public class PrimerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mi primer Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mi primer Servlet</h1>");
            out.println("<h2>Contexto del Servlet: " + request.getContextPath() + "</h2>");
            out.println("<h2>Idioma del usuario: " + request.getLocale() + "</h2>");
            out.println("<h2>Tipo de navegador: " + request.getHeader("User-Agent")+ "</h2>");
            out.println("<h2>La fecha de hoy es: " + new Date() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}