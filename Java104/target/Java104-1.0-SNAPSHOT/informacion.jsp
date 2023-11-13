<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de bienvenida</title>
    </head>
    <body>
        <% 
            String usuario = (String)session.getAttribute("usuario");
            String ciudad = (String)session.getAttribute("ciudad");
        %>
        <h1>Información adicional</h1>
        <p>Información del navegador: <%= request.getHeader("User-Agent") %></p>
        <p>Información del idioma: <%= request.getLocale() %> </p>
        <p>Información del usuario: <% out.println(usuario); %> </p>
        <p>Información de lugar de conexión: <% out.println(ciudad); %> </p>
        <p><a href="index_get.jsp">Volver a la página principal</a></p>
    </body>
</html>
