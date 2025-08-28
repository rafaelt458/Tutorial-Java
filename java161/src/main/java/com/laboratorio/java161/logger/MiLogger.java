package com.laboratorio.java161.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MiLogger implements AutoCloseable {
    private final FileWriter file;
    private final BufferedWriter writer;

    public MiLogger(String rutaFichero) throws IOException {
        this.file = new FileWriter(rutaFichero, true);
        this.writer = new BufferedWriter(this.file);
    }
    
    public void log(String mensaje) throws IOException {
        this.writer.write(mensaje);
        this.writer.newLine();
        this.writer.flush();
    }

    @Override
    public void close() throws Exception {
        if (this.writer != null) {
            this.writer.close();
        }
        if (this.file != null) {
            this.file.close();
        }
        System.out.println("Logger cerrado correctamente");
    }
}