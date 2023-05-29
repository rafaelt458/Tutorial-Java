package com.laboratorio.java066;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class EditarPersona extends javax.swing.JFrame {
    private ListaPersonas ventana;
    private Connection conn;
    private int idPersona;  // 0- Creación, otro valor - Edición
    
    public EditarPersona() {
        initComponents();
                
        MaskFormatter formatoFecha = null;
        MaskFormatter formatoNumero = null;
        
        try {
           formatoFecha = new MaskFormatter("##/##/####");
           formatoFecha.setPlaceholderCharacter('_');
           formatoNumero = new MaskFormatter("##");
           formatoNumero.setPlaceholderCharacter(' ');
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar el formulario de personas",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        formatoFecha.install(tFechaNac);
        tFechaNac.setColumns(10);
        formatoNumero.install(tExperiencia);
        tExperiencia.setColumns(2);
    }
    
    public void iniciarVariables(ListaPersonas ventana, Connection conn) {
        this.ventana = ventana;
        this.conn = conn;
    }
    
    private boolean cargarDatosPersona() {
        Statement statement;
        ResultSet rs;
        String str;
        Date fechaTemp;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {
            statement = conn.createStatement();
            str = "select nombres, apellidos, fechanac, experiencia from personas where idpersonas = " + idPersona;
            rs = statement.executeQuery(str);
            if (rs.next()) {
                tNombres.setText(rs.getString(1));
                tApellidos.setText(rs.getString(2));
                fechaTemp = rs.getDate(3);
                LocalDate fechaNac = fechaTemp.toLocalDate();
                str = fechaNac.format(formatoFecha);
                tFechaNac.setText(str);
                str = Integer.toString(rs.getInt(4));
                tExperiencia.setText(str);
            } else {
                System.out.println("Error: persona no encontrada");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public void iniciarFormulario(int idPersona) {
        this.idPersona = idPersona;
        
        if (idPersona == 0) {
            tNombres.setText("");
            tApellidos.setText("");
            tFechaNac.setText("");
            tExperiencia.setText("");
            bGuardar.setEnabled(false);
        } else {
           if (!cargarDatosPersona()) {
               JOptionPane.showMessageDialog(null, "Se ha presentado un error al intentar cargar los datos de la persona a modificar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
           }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tNombres = new javax.swing.JTextField();
        tApellidos = new javax.swing.JTextField();
        tFechaNac = new javax.swing.JFormattedTextField();
        tExperiencia = new javax.swing.JFormattedTextField();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edición de los datos de una persona");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Nombres");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Fecha de nacimiento");

        jLabel4.setText("Años de experiencia");

        tNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNombresKeyTyped(evt);
            }
        });

        tApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tApellidosKeyTyped(evt);
            }
        });

        tFechaNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFechaNacKeyTyped(evt);
            }
        });

        tExperiencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tExperienciaKeyTyped(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tApellidos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        ventana.activarControles();
        setVisible(false);
    }//GEN-LAST:event_bCancelarActionPerformed

    private boolean crearPersona(String nombres, String apellidos, LocalDate fechaNac, int experiencia) {
        PreparedStatement ps;
        
        try {
            // Iniciar la transacción
            conn.setAutoCommit(false);
            
            ps = conn.prepareStatement("insert into personas (nombres, apellidos, fechanac, experiencia) values (?, ?, ?, ?)");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setDate(3, Date.valueOf(fechaNac));
            ps.setInt(4, experiencia);
            ps.execute();
            
            // Confirmar transacción
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            // Revertir la transacción
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                System.out.println(ex2.getMessage());
            }
            return false;
        }
        
        return true;
    }
    
    private boolean editarPersona(String nombres, String apellidos, LocalDate fechaNac, int experiencia) {
        PreparedStatement ps;
        
        try {
            // Iniciar la transacción
            conn.setAutoCommit(false);
            
            ps = conn.prepareStatement("update personas set nombres = ?, apellidos = ?, fechanac = ?, experiencia = ? where idpersonas = ?");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setDate(3, Date.valueOf(fechaNac));
            ps.setInt(4, experiencia);
            ps.setInt(5, idPersona);
            ps.execute();
            
            // Confirmar transacción
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            // Revertir la transacción
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                System.out.println(ex2.getMessage());
            }
            return false;
        }
        
        return true;
    }
    
    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        String nombres, apellidos, str;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac;
        int experiencia;
        
        nombres = tNombres.getText();
        apellidos = tApellidos.getText();
        str = tFechaNac.getText();
        try {
            fechaNac = LocalDate.parse(str, formatoFecha);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, introducir una fecha válida antes de guardar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        str = tExperiencia.getText().trim();
        experiencia = Integer.parseInt(str);
        
        if (idPersona == 0) {
            if (!crearPersona(nombres, apellidos, fechaNac, experiencia)) {
                JOptionPane.showMessageDialog(null, "Error al intentar crear la persona",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            if (!editarPersona(nombres, apellidos, fechaNac, experiencia)) {
                JOptionPane.showMessageDialog(null, "Error al intentar modificar la persona",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        ventana.activarControles();
        setVisible(false);
    }//GEN-LAST:event_bGuardarActionPerformed

    private boolean validarDatos() {
        if (tNombres.getText().isEmpty()) {
            return false;
        }
        if (tApellidos.getText().isEmpty()) {
            return false;
        }

        String str = tFechaNac.getText();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate fechaNac = LocalDate.parse(str, formatoFecha);
        } catch (Exception ex) {
            return false;
        }
        
        if (tExperiencia.getText().isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    private void tNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNombresKeyTyped
        bGuardar.setEnabled(validarDatos());
    }//GEN-LAST:event_tNombresKeyTyped

    private void tApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tApellidosKeyTyped
        bGuardar.setEnabled(validarDatos());
    }//GEN-LAST:event_tApellidosKeyTyped

    private void tFechaNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFechaNacKeyTyped
        bGuardar.setEnabled(validarDatos());
    }//GEN-LAST:event_tFechaNacKeyTyped

    private void tExperienciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tExperienciaKeyTyped
        bGuardar.setEnabled(validarDatos());
    }//GEN-LAST:event_tExperienciaKeyTyped

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tApellidos;
    private javax.swing.JFormattedTextField tExperiencia;
    private javax.swing.JFormattedTextField tFechaNac;
    private javax.swing.JTextField tNombres;
    // End of variables declaration//GEN-END:variables
}
