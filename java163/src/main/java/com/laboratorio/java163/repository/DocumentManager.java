package com.laboratorio.java163.repository;

import com.laboratorio.java163.datos.Documento;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentManager {
    private static final String INSERT_SQL = """
                                             INSERT INTO documentos
                                                (titulo, contenido, archivo)
                                             VALUES
                                                (?, ?, ?)
                                             """;
    
    private static final String SELECT_SQL = """
                                             SELECT titulo, contenido, archivo
                                                FROM    documentos
                                                WHERE   id = ?
                                             """;
    
    private static final String DELETE_SQL = """
                                             DELETE
                                                FROM    documentos
                                                WHERE   id = ?
                                             """;
    
    private final Connection connection;

    public DocumentManager(Connection connection) {
        this.connection = connection;
    }
   
    public void addDocument(Documento documento) throws SQLException, IOException {
        try (PreparedStatement stmt = this.connection.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, documento.titulo());
            
            String contenido = Files.readString(Paths.get(documento.contenidoPath()));
            stmt.setString(2, contenido);
            
            byte[] bytesArchivo = Files.readAllBytes(Paths.get(documento.archivoPath()));
            stmt.setBytes(3, bytesArchivo);
            
            stmt.executeUpdate();
        }
    }
    
    public Documento loadDocument(int id, String contenidoPath, String archivoPath) throws SQLException, IOException {
        try (PreparedStatement stmt = this.connection.prepareStatement(SELECT_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String titulo = rs.getString("titulo");
                    
                    String contenido = rs.getString("contenido");
                    Files.write(Paths.get(contenidoPath), contenido.getBytes());
                    
                    byte[] bytesArchivo = rs.getBytes("archivo");
                    Files.write(Path.of(archivoPath), bytesArchivo);
                    
                    return new Documento(titulo, contenidoPath, archivoPath);
                }
                
                return null;
            }
        }
    }
    
    public void deleteDocument(int id) throws SQLException {
        try (PreparedStatement stmt = this.connection.prepareStatement(DELETE_SQL)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}