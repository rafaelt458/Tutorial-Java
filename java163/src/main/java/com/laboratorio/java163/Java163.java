package com.laboratorio.java163;

import com.laboratorio.java163.datos.Documento;
import com.laboratorio.java163.repository.DocumentManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java163 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/laboratorio";
        String user = "testuser";
        String password = "testuser";
        
        Documento documento = new Documento(
                "Documento de prueba",
                "C:\\Laboratorio\\datos\\contenido.txt",
                "C:\\Laboratorio\\datos\\archivo.jpg");
        
        Connection connection;
        DocumentManager documentManager;
        try {
            connection = DriverManager.getConnection(url, user, password);
            documentManager = new DocumentManager(connection);
        } catch (SQLException e) {
            System.out.println("Error estableciendo la conexión con la base de datos");
            return;
        }
        System.out.println("Establecida la conexión con la base de datos");
        
        try {
            documentManager.addDocument(documento);
        } catch (IOException | SQLException e) {
            System.out.println("Ha ocurrido un error almacenando el documento");
            return;
        }
        System.out.println("Se ha almacenado el documento correctamente");
        
        try {
            Documento docLeido = documentManager.loadDocument(1,
                    "C:\\Laboratorio\\datos\\contenido2.txt",
                    "C:\\Laboratorio\\datos\\archivo2.jpg");
            System.out.println("Título del documento: " + docLeido.titulo());
        } catch (IOException | SQLException e) {
            System.out.println("Ha ocurrido un error recuperando el documento");
            return;
        }
        System.out.println("Se ha recuperado el documento correctamente");
    }
}
