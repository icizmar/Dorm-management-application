/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studentski.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import studentski.model.Racun;
import studentski.pomocno.Pomocno;

/**
 *
 * @author Ivan
 */
public class PojedinostiPlacenihRacuna extends javax.swing.JFrame {
    
    private Racun racun;
    private DateFormat df;
    private String datumIzdavanja;
    private String datumUplate;
    private NumberFormat nf;
    private DecimalFormat decf;

    /** Creates new form PojedinostiPlacenihRacuna */
    public PojedinostiPlacenihRacuna(Racun racun) {
        initComponents();
        this.racun = racun;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        nf=NumberFormat.getInstance(Pomocno.ZEMLJA);
        decf=(DecimalFormat) nf;
        decf.applyPattern(Pomocno.FORMAT_BROJA);
        df = new SimpleDateFormat("dd.MM.yyyy");
        datumIzdavanja = df.format(racun.getDatumIzdavanjaRacuna());
        try{
            datumUplate = df.format(racun.getDatumUplateRacuna());
        }catch(Exception e){
            datumUplate = "";
        }
        txtDatumIzdavanja.setText(datumIzdavanja);
        txtDatumUplate.setText(datumUplate);
        if(racun.isPlacen()){
            cmbPlacen.setSelectedIndex(0);
        }else{
            cmbPlacen.setSelectedIndex(1);
        }
        txtIznos.setText(decf.format(racun.getCijena() == null ? 0 : racun.getCijena()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDatumIzdavanja = new javax.swing.JTextField();
        cmbPlacen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDatumUplate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIznos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum izdavanja:");

        cmbPlacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Da", "Ne" }));

        jLabel2.setText("Plaćen:");

        jLabel3.setText("Datum uplate:");

        jLabel4.setText("Iznos:");

        txtIznos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("KN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDatumIzdavanja)
                    .addComponent(cmbPlacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtIznos, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtDatumUplate)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbPlacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtDatumUplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPlacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDatumIzdavanja;
    private javax.swing.JTextField txtDatumUplate;
    private javax.swing.JTextField txtIznos;
    // End of variables declaration//GEN-END:variables

}