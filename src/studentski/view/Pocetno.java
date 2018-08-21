/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.view;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import studentski.controller.Obrada;
import studentski.controller.ObradaStudent;
import studentski.model.Student;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class Pocetno extends javax.swing.JFrame {

    private Obrada<Student> obrada;
    private ObradaStudent obradaStudent;
    /**
     * Creates new form Pocetno
     */
    public Pocetno() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        obrada = new Obrada();
        obradaStudent = new ObradaStudent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInicijalnoPunjenje = new javax.swing.JButton();
        btnPokreniAplikaciju = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInicijalnoPunjenje.setText("Inicijalno punjenje nakon natjecaja");
        btnInicijalnoPunjenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicijalnoPunjenjeActionPerformed(evt);
            }
        });

        btnPokreniAplikaciju.setText("Pokreni aplikaciju");
        btnPokreniAplikaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniAplikacijuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPokreniAplikaciju, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicijalnoPunjenje, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnPokreniAplikaciju, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnInicijalnoPunjenje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniAplikacijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniAplikacijuActionPerformed
        new Izbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPokreniAplikacijuActionPerformed

    private void btnInicijalnoPunjenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicijalnoPunjenjeActionPerformed
        if(obradaStudent.imaLiStudenataUDomu()){
            JOptionPane.showMessageDialog(getRootPane(), "U Dom su već uneseni studenti nakon natječaja!");
            return;
        }
        URL url = null;
        Gson gson = new Gson();
        InputStreamReader reader = null;
        JsonElement json = null;
        try {
            url = new URL("https://ivancizmar1.000webhostapp.com/api/student/read.php");
            reader = new InputStreamReader(url.openStream());
            json = gson.fromJson(reader, JsonElement.class);
        } catch (IOException ex) {
            Logger.getLogger(Pocetno.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Student> listOfStudents = gson.fromJson(json, new TypeToken<List<Student>>(){}.getType());  
        listOfStudents.forEach(x -> {
            obrada.save(x);
        });
        JOptionPane.showMessageDialog(getRootPane(), "Unjeli ste " + listOfStudents.size() + 
                " studenata u bazu!");
        new UpisivanjeStudenataUSobe().setVisible(true);
    }//GEN-LAST:event_btnInicijalnoPunjenjeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicijalnoPunjenje;
    private javax.swing.JButton btnPokreniAplikaciju;
    // End of variables declaration//GEN-END:variables
}
