<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de bienvenida</title>
    </head>
    <body>
        <% 
            String nombre = request.getParameter("nombre");
            String ciudad = request.getParameter("ciudad");
            String preferencia = request.getParameter("preferencia");
            if (preferencia == null) {
                preferencia = "No";
            }
            session.setAttribute("usuario", nombre);
            session.setAttribute("ciudad", ciudad);
            
            Cookie nombreUsuario = new Cookie("bienvenida.nombre", nombre);
            nombreUsuario.setMaxAge(7*24*60*60);
            response.addCookie(nombreUsuario);
            
            Cookie ciudadUsuario = new Cookie("bienvenida.ciudad", ciudad);
            ciudadUsuario.setMaxAge(7*24*60*60);
            response.addCookie(ciudadUsuario);
            
            Cookie preferenciaUsuario = new Cookie("bienvenida.preferencia", preferencia);
            preferenciaUsuario.setMaxAge(7*24*60*60);
            response.addCookie(preferenciaUsuario);
        %>
        <h1>Bienvenida</h1>
        <p>Se ha conectado <%= nombre %> de la ciudad <%= ciudad %></p>
        <p>El usuario quiere recordar la información: <%= preferencia %></p>
        <p><a href="informacion.jsp">Información adicional</a></p>
        <p><a href="index_get.jsp">Volver a la página principal</a></p>
    </body>
</html>