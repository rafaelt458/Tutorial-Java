package com.laboratorio.java164.repository;

import com.laboratorio.java164.datos.Archivo;
import com.laboratorio.java164.datos.ArchivoLob;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.PGConnection;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

public class ArchivosLobManager {
    private static final int BUFFER_SIZE = 4096;
    
    private static final String INSERT_SQL = """
                                INSERT INTO archivos_lob
                                    (nombre, archivo_oid)
                                VALUES (?, ?)             
                                             """;
    
    private static final String SELECT_SQL = """
                                SELECT nombre, archivo_oid
                                    FROM archivos_lob
                                    WHERE id = ?
                                             """;
    
    private static final String DELETE_SQL = "DELETE FROM archivos_lob WHERE id = ?";
    
    private final Connection connection;

    public ArchivosLobManager(Connection connection) {
        this.connection = connection;
    }
    
    public void insertarArchivoLob(Archivo archivo) throws SQLException, IOException {
        this.connection.setAutoCommit(false);
        
        LargeObjectManager lom = this.connection.unwrap(PGConnection.class).getLargeObjectAPI();
        
        long oid = lom.createLO(LargeObjectManager.READWRITE);
        
        try (LargeObject largeObject = lom.open(oid, LargeObjectManager.WRITE)) {
            try (InputStream fis = new FileInputStream(archivo.rutaArchivo())) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) > 0) {
                    largeObject.write(buffer, 0, bytesRead);
                }
            }
        }
        
        try (PreparedStatement stmt = this.connection.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, archivo.nombre());
            stmt.setLong(2, oid);
            stmt.executeUpdate();
        }
        
        this.connection.commit();
    }
    
    private ArchivoLob loadArchivoLob(int id) throws SQLException {
        long oid;
        String nombre;
        try (PreparedStatement stmt = this.connection.prepareStatement(SELECT_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                nombre = rs.getString("nombre");
                oid = rs.getLong("archivo_oid");
            }
        }
        
        return new ArchivoLob(id, nombre, oid);
    }
    
    public Archivo leerArchivoLob(int id, String directorio) throws SQLException, IOException {
        this.connection.setAutoCommit(false);
        
        ArchivoLob archivoLob = this.loadArchivoLob(id);
        
        LargeObjectManager lom = this.connection.unwrap(PGConnection.class).getLargeObjectAPI();
        
        String rutaSalida = directorio + "\\" + archivoLob.nombre();
        try (LargeObject largeObject = lom.open(archivoLob.archivoOid(), LargeObjectManager.READ)) {
            try (OutputStream out = new FileOutputStream(rutaSalida)) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = largeObject.read(buffer, 0, BUFFER_SIZE)) > 0) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
        
        this.connection.commit();
        
        return new Archivo(archivoLob.nombre(), rutaSalida);
    }
    
    public void eliminarArchivoLob(int id) throws SQLException {
        this.connection.setAutoCommit(false);
        
        ArchivoLob archivoLob = this.loadArchivoLob(id);
        LargeObjectManager lom = this.connection.unwrap(PGConnection.class).getLargeObjectAPI();
        lom.unlink(archivoLob.archivoOid());
        
        try (PreparedStatement stmt = this.connection.prepareStatement(DELETE_SQL)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        
        this.connection.commit();
    }
}