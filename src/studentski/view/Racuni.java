/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import studentski.controller.Obrada;
import studentski.controller.ObradaRacun;
import studentski.controller.ObradaStudent;
import studentski.controller.ObradaStudentskiDom;
import studentski.model.Racun;
import studentski.model.Student;
import studentski.model.StudentskiDom;

/**
 *
 * @author Ivan
 */
public class Racuni extends javax.swing.JFrame {
    
    private String odabraniMjesec;
    private Date pocetakMjeseca;
    private Date krajMjeseca;
    private SimpleDateFormat format;
    private Date pMjeseca;
    private Date kMjeseca;
    private List<Student> listaStudentaSNeplacenimRacunom;
    private List<Student> listaStudentaBezRacuna;
    private Obrada<Racun> obrada;
    private ObradaRacun obradaRacun; 
    private ObradaStudent obradaStudent;
    private ObradaStudentskiDom obradaStudentskiDom;
    private List<Student> listaStudenataSPlacenim;
    private StudentskiDom studentskiDom;
    
    /**
     * Creates new form Racuni
     */
    public Racuni() {
        initComponents();
        cmbStudentskiDom.addActionListener((ActionEvent e) -> {
        });
        cmbMjesec.addActionListener((ActionEvent e) -> {
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        format = new SimpleDateFormat("yyyy-MM-dd");
        obrada = new Obrada<>();
        obradaStudent = new ObradaStudent();
        obradaRacun = new ObradaRacun();
        obradaStudentskiDom = new ObradaStudentskiDom();
        studentskiDom = new StudentskiDom();
        napuniDomove();
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
        listaNeplacenih = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBez = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMjesec = new javax.swing.JComboBox<>();
        btnIzdajRacune = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPojedinostNeplacenihiRacuna = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPlacenih = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnUplataIzvrsena = new javax.swing.JButton();
        btnPojedinostiPlacenihRacuna = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbStudentskiDom = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listaNeplacenih);

        jScrollPane2.setViewportView(listaBez);

        jLabel1.setText("Studenti s neplaćenim računom:");

        jLabel2.setText("Studenti bez računa:");

        cmbMjesec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sijecanj", "Veljaca", "Ozujak", "Travanj", "Svibanj", "Lipanj", "Srpanj", "Kolovoz", "Rujan", "Listopad", "Studeni", "Prosinac" }));
        cmbMjesec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMjesecActionPerformed(evt);
            }
        });

        btnIzdajRacune.setText("Izdaj račune");
        btnIzdajRacune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzdajRacuneActionPerformed(evt);
            }
        });

        jLabel3.setText("Odaberi mjesec:");

        btnPojedinostNeplacenihiRacuna.setText("Pojedinosti računa");
        btnPojedinostNeplacenihiRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPojedinostNeplacenihiRacunaActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listaPlacenih);

        jLabel4.setText("Studenti s plaćenim računom:");

        btnUplataIzvrsena.setText("Uplata izvršena");
        btnUplataIzvrsena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUplataIzvrsenaActionPerformed(evt);
            }
        });

        btnPojedinostiPlacenihRacuna.setText("Pojedinosti računa");
        btnPojedinostiPlacenihRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPojedinostiPlacenihRacunaActionPerformed(evt);
            }
        });

        jLabel5.setText("Odaberi studentski dom:");

        cmbStudentskiDom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudentskiDomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbStudentskiDom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIzdajRacune, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPojedinostNeplacenihiRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUplataIzvrsena, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMjesec, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPojedinostiPlacenihRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStudentskiDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(cmbMjesec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPojedinostiPlacenihRacuna)
                    .addComponent(btnPojedinostNeplacenihiRacuna)
                    .addComponent(btnIzdajRacune))
                .addGap(18, 18, 18)
                .addComponent(btnUplataIzvrsena)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMjesecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMjesecActionPerformed
        odabirDatuma(); 
        if(pMjeseca == null || kMjeseca == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali mjesec za pregled računa");
            return;
        }
        popuniListeStudenata();
    }//GEN-LAST:event_cmbMjesecActionPerformed

    private void btnIzdajRacuneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzdajRacuneActionPerformed
        Date trenutniDatum = new Date();
        if(pMjeseca == null || kMjeseca == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali mjesec za pregled računa");
            return;
        }
        if(listaStudentaBezRacuna.isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(), "Svi studenti imaju izdan račun za " + odabraniMjesec);
            return;
        }
        boolean provjeraDatuma = isDateInBetweenIncludingEndPoints(pocetakMjeseca, krajMjeseca, trenutniDatum);
        if(!provjeraDatuma){
            JOptionPane.showMessageDialog(getRootPane(), "Odabrani mjesec nije trenutni mjesec "
                    + "te se za njega ne mogu izdati računi");
            return;
        }
        Racun r;
        for (Student student : listaStudentaBezRacuna) {
            r = new Racun();
            r.setDatumIzdavanjaRacuna(new Date());
            r.setPlacen(false);
            r.setStudent(student);
            obrada.save(r);
        }
        JOptionPane.showMessageDialog(getRootPane(), "Unjeli ste racune studentima za " + odabraniMjesec);
        popuniListeStudenata();
    }//GEN-LAST:event_btnIzdajRacuneActionPerformed

    private void btnPojedinostNeplacenihiRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPojedinostNeplacenihiRacunaActionPerformed
        Student student = listaNeplacenih.getSelectedValue();
        if (student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali sudenta za pregled racuna");
            return;
        }
        if(listaStudentaSNeplacenimRacunom.isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(), "Nema studenata s izdanim računom!");
            return;
        }
        if(pMjeseca == null || kMjeseca == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali mjesec za pregled računa");
            return;
        }
        Racun r = obradaRacun.getRacunZaPojedinosti(student, pMjeseca, kMjeseca);
        new PojedinostiRacuna(r).setVisible(true);
    }//GEN-LAST:event_btnPojedinostNeplacenihiRacunaActionPerformed

    private void btnUplataIzvrsenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUplataIzvrsenaActionPerformed
        Date trenutniDatum = new Date();
        Student student = listaNeplacenih.getSelectedValue();
        boolean provjeraDatuma = isDateInBetweenIncludingEndPoints(pocetakMjeseca, krajMjeseca, trenutniDatum);
        if(!provjeraDatuma){
            JOptionPane.showMessageDialog(getRootPane(), "Odabrani mjesec nije trenutni mjesec "
                    + "te se za njega ne mogu izdati računi");
            return;
        }
        if(student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali studenta koji je izvršio uplatu računa");
            return;
        }
        List<Racun> listaRacuna = obradaRacun.getListaRacuna(student, pMjeseca, kMjeseca);
        for (Racun racun : listaRacuna) {
            racun.setPlacen(true);
            racun.setDatumUplateRacuna(new Date());
            racun.setCijena(500);
            obrada.save(racun);
        }
        JOptionPane.showMessageDialog(getRootPane(), "Student " + student + " platio je račun za " + odabraniMjesec);
        DefaultListModel<Student> model = new DefaultListModel<>();
        model.addElement(student);
        popuniListeStudenata();
    }//GEN-LAST:event_btnUplataIzvrsenaActionPerformed

    private void btnPojedinostiPlacenihRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPojedinostiPlacenihRacunaActionPerformed
        Student student = listaPlacenih.getSelectedValue();
        if (student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali sudenta za pregled racuna");
            return;
        }
        if(listaStudenataSPlacenim.isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(), "Nema studenata koji su platili račun za " + odabraniMjesec);
            return;
        }
        if(pMjeseca == null || kMjeseca == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali mjesec za pregled računa");
            return;
        }
        Racun r = obradaRacun.getRacunZaPojedinosti(student, pMjeseca, kMjeseca);
        new PojedinostiRacuna(r).setVisible(true);
    }//GEN-LAST:event_btnPojedinostiPlacenihRacunaActionPerformed

    private void cmbStudentskiDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudentskiDomActionPerformed
        studentskiDom = (StudentskiDom) cmbStudentskiDom.getSelectedItem();
        if(studentskiDom == null){
            JOptionPane.showMessageDialog(getRootPane(), "Odaberite studentski dom za pregled računa");
            return;
        }
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue()-1;
        cmbMjesec.setSelectedIndex(month);
    }//GEN-LAST:event_cmbStudentskiDomActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzdajRacune;
    private javax.swing.JButton btnPojedinostNeplacenihiRacuna;
    private javax.swing.JButton btnPojedinostiPlacenihRacuna;
    private javax.swing.JButton btnUplataIzvrsena;
    private javax.swing.JComboBox<String> cmbMjesec;
    private javax.swing.JComboBox<String> cmbStudentskiDom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Student> listaBez;
    private javax.swing.JList<Student> listaNeplacenih;
    private javax.swing.JList<Student> listaPlacenih;
    // End of variables declaration//GEN-END:variables

    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }

    private void odabirDatuma() {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(new Date());
        gc.set(Calendar.MONTH, cmbMjesec.getSelectedIndex());
        gc.set(Calendar.DAY_OF_MONTH, 1);
        pocetakMjeseca=gc.getTime();
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.DAY_OF_MONTH, -1);
        krajMjeseca = gc.getTime();
        String pM = format.format(pocetakMjeseca);
        String kM = format.format(krajMjeseca);
        try {
            pMjeseca = format.parse(pM);
            kMjeseca = format.parse(kM);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(getRootPane(), "Ne može prebaciti string u Date");
            return;
        }
        odabraniMjesec = (String)cmbMjesec.getSelectedItem();
    }

    private void popuniListeStudenata() {
        studentskiDom = (StudentskiDom) cmbStudentskiDom.getSelectedItem();
        DefaultListModel<Student> modelBez = new DefaultListModel<>();
        DefaultListModel<Student> modelNeplacenih = new DefaultListModel<>();
        DefaultListModel<Student> modelPlacenih = new DefaultListModel<>();
        List<Racun> listaRacunaUOdabranomMjesecu = obradaRacun.getListaSvihPlacenihUOdabranomMjesecuIDomu(studentskiDom, pMjeseca, kMjeseca);  
        listaStudentaBezRacuna = obradaStudent.getSviStudentiBezRacuna(studentskiDom, pMjeseca, kMjeseca);
        listaStudentaSNeplacenimRacunom = new ArrayList<>();
        listaStudenataSPlacenim = new ArrayList<>();
        listaRacunaUOdabranomMjesecu.forEach(element -> {
            if(!element.isPlacen()){
                listaStudentaSNeplacenimRacunom.add(element.getStudent());
            }else{
                listaStudenataSPlacenim.add(element.getStudent());
            }
        });
        listaStudentaBezRacuna.forEach(element -> {
            modelBez.addElement(element);
        });
        listaStudentaSNeplacenimRacunom.forEach(element -> {
            modelNeplacenih.addElement(element);
        });
        listaStudenataSPlacenim.forEach(element -> {
            modelPlacenih.addElement(element);
        });
        this.listaNeplacenih.setModel(modelNeplacenih);
        this.listaBez.setModel(modelBez);
        this.listaPlacenih.setModel(modelPlacenih);
    }   

    private void napuniDomove() {
        DefaultComboBoxModel cmbStuDom = new DefaultComboBoxModel();
        List<StudentskiDom> listaDomova = obradaStudentskiDom.dohvatiSveDomove();
        if(listaDomova.size()== 0){
            JOptionPane.showMessageDialog(getRootPane(), "Nema unesenih domova za pregled računa, molim unesite ih!");
            new StudentskiDomovi().setVisible(true);
            dispose();
            return;
        }else{
            listaDomova.forEach(element -> {
            cmbStuDom.addElement(element);
        });
        cmbStudentskiDom.setModel(cmbStuDom);
            cmbStudentskiDom.setSelectedIndex(0);
        }
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue()-1;
        cmbMjesec.setSelectedIndex(month);
    }
}
