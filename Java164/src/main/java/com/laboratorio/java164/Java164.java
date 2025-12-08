package com.laboratorio.java164;

import com.laboratorio.java164.datos.Archivo;
import com.laboratorio.java164.repository.ArchivosLobManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java164 {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.1.71:5433/laboratorio";
        String user = "testuser";
        String password = "testuser";
        
        Archivo archivo = new Archivo("archivo.jpg", "C:\\Laboratorio\\datos\\archivo.jpg");
             
        Connection connection;
        ArchivosLobManager archivosLobManager;
        try {
            connection = DriverManager.getConnection(url, user, password);
            archivosLobManager = new ArchivosLobManager(connection);
        } catch (SQLException e) {
            System.out.println("Error estableciendo la conexión con la base de datos");
            return;
        }
        System.out.println("Establecida la conexión con la base de datos");
        
        try {
            archivosLobManager.insertarArchivoLob(archivo);
        } catch (IOException | SQLException e) {
            System.out.println("Ha ocurrido un error almacenando el archivo");
            return;
        }
        System.out.println("Se ha almacenado el archivo correctamente");
        
        try {
            Archivo archivoLeido = archivosLobManager.leerArchivoLob(1, "C:\\Laboratorio\\ficheros");
            System.out.println(String.format("El documento %s y se ha almacenando en la ruta: %s",
                    archivoLeido.nombre(), archivoLeido.rutaArchivo()).toCharArray());
        } catch (IOException | SQLException e) {
            System.out.println("Ha ocurrido un error recuperando el archivo");
            return;
        }
        
        try {
            archivosLobManager.eliminarArchivoLob(1);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error eliminadoº el archivo");
            return;
        }
        
        System.out.println("Se ha eliminado el archivo correctamente");
    }
}