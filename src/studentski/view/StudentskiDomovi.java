/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import studentski.controller.Obrada;
import studentski.model.Paviljon;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class StudentskiDomovi extends javax.swing.JFrame {
    
    private Obrada<StudentskiDom> obrada;
    private Border obrub;

    /**
     * Creates new form StudentskiDomovi
     */
    public StudentskiDomovi() {
        initComponents();
        setPreferredSize(new Dimension(600, 400));
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        obrada = new Obrada<>();
        obrub = txtNaziv.getBorder();
        ucitajPodatke();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefonskiBroj = new javax.swing.JTextField();
        btnDodajNovi = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPaviljoni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel1.setText("Naziv");

        jLabel2.setText("Adresa");

        jLabel3.setText("Telefonski broj");

        btnDodajNovi.setText("Novi");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPaviljoni.setText("Paviljoni");
        btnPaviljoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaviljoniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(btnPaviljoni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(txtAdresa)
                        .addComponent(txtTelefonskiBroj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajNovi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodajNovi)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnPaviljoni)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        StudentskiDom odabraniDom = lista.getSelectedValue();
        if(odabraniDom == null){
            return;
        }
        txtNaziv.setText(odabraniDom.getNaziv());
        txtAdresa.setText(odabraniDom.getAdresa());
        txtTelefonskiBroj.setText(odabraniDom.getBrojTelefona());
    }//GEN-LAST:event_listaValueChanged

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed
        resetirajPogreske();
        if(!kontrola()){
            return;
        }
        StudentskiDom sd = new StudentskiDom();
        sd = napuniObjekt(sd);
        obrada.save(sd);
        ucitajPodatke();
    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        StudentskiDom sd = lista.getSelectedValue();
        if(sd == null){
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite studentski dom koji želite mjenjati!");
            return;
        }
        if(txtNaziv.getText().trim().length()==0){
            JOptionPane.showMessageDialog(getRootPane(), "Obavezno popunite naziv studentskog doma!");
            return;
        }
        resetirajPogreske();
        sd = napuniObjekt(sd);
        obrada.save(sd);
        ucitajPodatke();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        StudentskiDom sd = lista.getSelectedValue();
        if(sd == null){
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite studentski dom koji želite obrisati");
            return;
        }
        
        boolean mozeObrisati=true;
        
        for (Paviljon p : sd.getPaviljoni()) {
            if(!p.isObrisano()){
                mozeObrisati=false;
                break;
            }    
        }
        if(!mozeObrisati){
            JOptionPane.showMessageDialog(getRootPane(), "Studentski dom se ne može obrisati jer se u njemu nalaze paviljoni!");
            return;
        }
        obrada.delete(sd);
        ucitajPodatke();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPaviljoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaviljoniActionPerformed
        StudentskiDom studentskiDom = lista.getSelectedValue();
        if(studentskiDom == null){
            JOptionPane.showMessageDialog(getRootPane(), "Morate odabrati studentski dom u koji želite dodati paviljone");
            return;
        }
        new Paviljoni(studentskiDom).setVisible(true);
    }//GEN-LAST:event_btnPaviljoniActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPaviljoni;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<StudentskiDom> lista;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTelefonskiBroj;
    // End of variables declaration//GEN-END:variables

    private void ucitajPodatke() {
        DefaultListModel<StudentskiDom> m = new DefaultListModel<>();
        List<StudentskiDom> lista = HibernateUtil.getSession().createQuery(
                "from StudentskiDom a where a.obrisano = false ").list();
                
        for (StudentskiDom studentskiDom : lista) {
            m.addElement(studentskiDom);
        }
        this.lista.setModel(m);
    }

    private StudentskiDom napuniObjekt(StudentskiDom sd) {
        sd.setNaziv(txtNaziv.getText());
        sd.setAdresa(txtAdresa.getText());
        sd.setBrojTelefona(txtTelefonskiBroj.getText());
        return sd;
    }
    
    public void oznaciPogresku(JTextField polje){
        polje.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
        polje.requestFocus();
    }

    private boolean kontrola() {
        if(txtNaziv.getText().trim().length() == 0){
            oznaciPogresku(txtNaziv);
            return false;
        }
        if(txtAdresa.getText().trim().length() == 0){
            oznaciPogresku(txtAdresa);
            return false;
        }
        if(txtTelefonskiBroj.getText().trim().length() == 0){
            oznaciPogresku(txtTelefonskiBroj);
            return false;
        }
        return true;
    }

    private void resetirajPogreske() {
        txtNaziv.setBorder(obrub);
        txtAdresa.setBorder(obrub);
        txtTelefonskiBroj.setBorder(obrub);
    }
}
