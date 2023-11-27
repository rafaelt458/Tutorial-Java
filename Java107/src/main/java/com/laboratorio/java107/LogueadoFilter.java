package com.laboratorio.java107;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.do")
public class LogueadoFilter implements Filter {
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        log("He entrado al filtro LogueadoFilter");
        
        HttpServletRequest request = (HttpServletRequest)sr;
        String usuario = (String)request.getSession().getAttribute("usuario");
        
        log("Valor usuario: " + usuario);
        
        if ((usuario != null) && (!usuario.isEmpty())) {
            fc.doFilter(sr, sr1);
        } else {
            HttpServletResponse response = (HttpServletResponse)sr1;
            response.sendRedirect("index.jsp?error=Debe estar logueado para ver este contenido");
        }
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
