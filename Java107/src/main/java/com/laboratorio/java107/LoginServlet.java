package com.laboratorio.java107;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");        
        if ((usuario == null) || (usuario.isEmpty())) {
            response.sendRedirect("index.jsp?error=Debe suministrar un nombre de usuario!");
        }
        
        String clave = request.getParameter("clave");
        if (clave.equals("1234")) {
            request.getSession().setAttribute("usuario", usuario);
            request.setAttribute("rol", "Operador");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sistema.jsp");
            dispatcher.forward(request, response);
        } else {
            if (clave.equals("12345")) {
                request.setAttribute("rol", "Administrador");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sistema.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("index.jsp?error=Nombre de usuario o clave incorrecta!");
            }
        }
    }
}