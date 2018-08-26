/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import studentski.controller.ObradaOpomena;
import studentski.controller.ObradaRacun;
import studentski.controller.ObradaStudentskiDom;
import studentski.model.Opomena;
import studentski.model.Racun;
import studentski.model.Student;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class Opomene extends javax.swing.JFrame {
    
    private Date prviDan;
    private Date zadnjiDan;
    private SimpleDateFormat format;
    private Date pocetakTrenutnogMjeseca;
    private Date krajTrenutnogMjeseca;
    private String odabraniMjesec;
    private Date prijasnjiMjesecPocetak;
    private Date prijasnjiMjesecKraj;
    private Date pocetakPijasnjeg;
    private Date krajPrijasnjeg;
    private Obrada<Opomena> obrada;
    private ObradaStudentskiDom obradaStudentskiDom;
    private ObradaOpomena obradaOpomena;
    private ObradaRacun obradaRacun;
    private StudentskiDom studentskiDom;
    
    /**
     * Creates new form Opomene
     */
    public Opomene() {
        initComponents();
        cmbMjeseci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        format = new SimpleDateFormat("yyyy-MM-dd");
        obrada = new Obrada<>();
        obradaStudentskiDom = new ObradaStudentskiDom();
        obradaRacun = new ObradaRacun();
        obradaOpomena = new ObradaOpomena();
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
        jList1 = new javax.swing.JList<>();
        cmbMjeseci = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNapraviOpomenu = new javax.swing.JButton();
        btnOpomenaPlacena = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPojedinostiRacuna = new javax.swing.JButton();
        btnPojedinostiOpomene = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbStudentskiDom = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        cmbMjeseci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sijecanj", "Veljaca", "Ozujak", "Travanj", "Svibanj", "Lipanj", "Srpanj", "Kolovoz", "Rujan", "Listopad", "Studeni", "Prosinac" }));
        cmbMjeseci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMjeseciActionPerformed(evt);
            }
        });

        jLabel1.setText("Odaberi mjesec za pregled opomena:");

        jLabel2.setText("Studenti koji nisu platili račun mjesec ");

        btnNapraviOpomenu.setText("Napravi opomenu");
        btnNapraviOpomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapraviOpomenuActionPerformed(evt);
            }
        });

        btnOpomenaPlacena.setText("Opomena plaćena");
        btnOpomenaPlacena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpomenaPlacenaActionPerformed(evt);
            }
        });

        jLabel3.setText("dana te im nije izdana opomena:");

        jScrollPane2.setViewportView(jList2);

        jLabel5.setText("Studenti s izdanom opomenom ");

        jLabel4.setText("koja nije plaćena:");

        btnPojedinostiRacuna.setText("Pojedinosti računa");
        btnPojedinostiRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPojedinostiRacunaActionPerformed(evt);
            }
        });

        btnPojedinostiOpomene.setText("Pojedinosti opomene");
        btnPojedinostiOpomene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPojedinostiOpomeneActionPerformed(evt);
            }
        });

        jLabel6.setText("Odaberi studentski dom:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPojedinostiRacuna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(btnNapraviOpomenu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpomenaPlacena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(btnPojedinostiOpomene, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMjeseci, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(cmbStudentskiDom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMjeseci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStudentskiDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(btnPojedinostiOpomene)
                        .addGap(18, 18, 18)
                        .addComponent(btnOpomenaPlacena)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNapraviOpomenu))
                        .addGap(18, 18, 18)
                        .addComponent(btnPojedinostiRacuna)
                        .addContainerGap(59, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMjeseciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMjeseciActionPerformed
        odabirDatuma();
        racunjeMjesecaUnazad();
        napuniListe();
        odabraniMjesec = (String)cmbMjeseci.getSelectedItem();
    }//GEN-LAST:event_cmbMjeseciActionPerformed

    private void btnNapraviOpomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapraviOpomenuActionPerformed
        Student student = jList1.getSelectedValue();
        if(student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali studenta!");
            return;
        }
        boolean provjeraOpomena = false;
        provjeraOpomena = provjeraOp(student);
        if(!provjeraOpomena){
            JOptionPane.showMessageDialog(getRootPane(), "Student već ima izdanu opomenu!");
            return;
        }
        Racun racun = new Racun();
        List<Racun> Racun = HibernateUtil.getSession().createQuery(
                " FROM Racun a WHERE a.obrisano=false AND a.student like :uvjet AND a.placen=false "
                        + " AND a.datumIzdavanjaRacuna BETWEEN :stDate AND :edDate ")
                .setString("uvjet", "%" + student.getSifra() + "%")
                .setParameter("stDate", pocetakPijasnjeg)
                .setParameter("edDate", krajPrijasnjeg)
                .list();
        for (Racun rac : Racun) {
            racun = rac;
        }
        Opomena opomena = new Opomena();
        opomena.setIzdavanjeOpomene(new Date());
        opomena.setPlacenoNakonOpomene(false);
        opomena.setRacun(racun);
        opomena.setDatumUplateOpomene(null);
        obrada.save(opomena);
        JOptionPane.showMessageDialog(getRootPane(), "Unjeli ste opomenu za studenta/icu " + student + " za "
                + "mjesec " + odabraniMjesec);
        napuniListe();
    }//GEN-LAST:event_btnNapraviOpomenuActionPerformed

    private void btnOpomenaPlacenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpomenaPlacenaActionPerformed
        Student student = jList2.getSelectedValue();
        if(student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali studenta koji je platio opomenu!");
            return;
        }
        Opomena opomena = pronadjiOpomenu(student);
        opomena.setDatumUplateOpomene(new Date());
        opomena.setPlacenoNakonOpomene(true);
        opomena.getRacun().setCijena(500);
        opomena.getRacun().setDatumUplateRacuna(new Date());
        opomena.getRacun().setPlacen(true);
        obrada.save(opomena);
        napuniListe();
    }//GEN-LAST:event_btnOpomenaPlacenaActionPerformed

    private void btnPojedinostiRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPojedinostiRacunaActionPerformed
        Student student = jList1.getSelectedValue();
        if (student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali sudenta za pregled racuna");
            return;
        }
        
        if(pocetakPijasnjeg == null || krajPrijasnjeg == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali mjesec za pregled računa");
            return;
        }
        Racun r = new Racun();
        List<Racun> listaRacuna = HibernateUtil.getSession().createQuery(
                "FROM Racun a WHERE a.obrisano=false and student like :uvjet and a.datumIzdavanjaRacuna BETWEEN :stDate AND :edDate ")
                .setString("uvjet", "%" + student.getSifra() + "%")
                .setParameter("stDate", pocetakPijasnjeg)
                .setParameter("edDate", krajPrijasnjeg)
                .list();
        for (Racun racun : listaRacuna) {
            r = racun;
        }
        new PojedinostiRacuna(r).setVisible(true);
    }//GEN-LAST:event_btnPojedinostiRacunaActionPerformed

    private void btnPojedinostiOpomeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPojedinostiOpomeneActionPerformed
        Student student = jList2.getSelectedValue();
        if (student == null){
            JOptionPane.showMessageDialog(getRootPane(), "Niste odabrali sudenta za pregled opomene");
            return;
        }
        List<Opomena> listaopomena = HibernateUtil.getSession().createQuery(
                " FROM Opomena a WHERE a.obrisano=false AND a.placenoNakonOpomene=false "
                        + " AND a.izdavanjeOpomene BETWEEN :stDate AND :edDate ")
                .setParameter("stDate", pocetakTrenutnogMjeseca)
                .setParameter("edDate", krajTrenutnogMjeseca)
                .list();
        Opomena opomena = new Opomena();
        for (Opomena o : listaopomena) {
            if(student.getSifra() != o.getRacun().getStudent().getSifra()){
                continue;
            }
            opomena = o;
        }
        new PojedinostiOpomene(opomena).setVisible(true);
    }//GEN-LAST:event_btnPojedinostiOpomeneActionPerformed

    private void cmbStudentskiDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudentskiDomActionPerformed
        studentskiDom = (StudentskiDom) cmbStudentskiDom.getSelectedItem();
        if(studentskiDom == null){
            JOptionPane.showMessageDialog(getRootPane(), "Ponovno odaverite studentski dom!");
            return;
        }
        napuniListe();
    }//GEN-LAST:event_cmbStudentskiDomActionPerformed


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNapraviOpomenu;
    private javax.swing.JButton btnOpomenaPlacena;
    private javax.swing.JButton btnPojedinostiOpomene;
    private javax.swing.JButton btnPojedinostiRacuna;
    private javax.swing.JComboBox<String> cmbMjeseci;
    private javax.swing.JComboBox<StudentskiDom> cmbStudentskiDom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<Student> jList1;
    private javax.swing.JList<Student> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void odabirDatuma() {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(new Date());
        gc.set(Calendar.MONTH, cmbMjeseci.getSelectedIndex());
        gc.set(Calendar.DAY_OF_MONTH, 1);
        prviDan=gc.getTime();
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.DAY_OF_MONTH, -1);
        zadnjiDan = gc.getTime();
        String pM = format.format(prviDan);
        String kM = format.format(zadnjiDan);
        try {
            pocetakTrenutnogMjeseca = format.parse(pM);
            krajTrenutnogMjeseca = format.parse(kM);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(getRootPane(), "Ne može prebaciti string u Date");
            return;
        }
        odabraniMjesec = (String)cmbMjeseci.getSelectedItem();
    }

    public void racunjeMjesecaUnazad() {
        GregorianCalendar kalendar = (GregorianCalendar) Calendar.getInstance();
        kalendar.setTime(new Date());
        kalendar.set(Calendar.MONTH, cmbMjeseci.getSelectedIndex()-1);
        kalendar.set(Calendar.DAY_OF_MONTH, 1);
        prijasnjiMjesecPocetak=kalendar.getTime();
        kalendar.add(Calendar.MONTH, 1);
        kalendar.add(Calendar.DAY_OF_MONTH, -1);
        prijasnjiMjesecKraj = kalendar.getTime();
        String pM = format.format(prijasnjiMjesecPocetak);
        String kM = format.format(prijasnjiMjesecKraj);
        try {
            pocetakPijasnjeg = format.parse(pM);
            krajPrijasnjeg = format.parse(kM);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(getRootPane(), "Ne može prebaciti string u Date");
            return;
        }
    }

    private boolean provjeraOp(Student student) {
        List<Opomena> listaOpomena = HibernateUtil.getSession().createQuery(
                " FROM Opomena a WHERE a.obrisano=false "
                        + " AND a.izdavanjeOpomene BETWEEN :stDate AND :edDate ")
                .setParameter("stDate", pocetakTrenutnogMjeseca)
                .setParameter("edDate", krajTrenutnogMjeseca)
                .list();
        for (Opomena opomena : listaOpomena) {
            if(opomena.getRacun().getStudent().getSifra() == student.getSifra()){
                return false;
            }
        }
        return true;
    }

    private void napuniListe() {
        
        DefaultListModel<Student> model = new DefaultListModel<>();
        DefaultListModel<Student> model1 = new DefaultListModel<>();
        List<Student> listaStudenataNeplacenaOpomena = new ArrayList<>();
        List<Student> listaStudenataNeizdavaOpomena = new ArrayList<>();
        List<Racun> listaNeplacenihRacunaPijasnjiMjesec = obradaRacun.getListaSvihPlacenihUOdabranomMjesecuIDomu(studentskiDom, pocetakPijasnjeg, krajPrijasnjeg);
                
        List<Opomena> listaopomena = obradaOpomena.getNeplaceneOpomene(studentskiDom, pocetakTrenutnogMjeseca, krajTrenutnogMjeseca);
                
        for (Racun racun : listaNeplacenihRacunaPijasnjiMjesec) {
            listaStudenataNeizdavaOpomena.add(racun.getStudent());
            //model.addElement(racun.getStudent());
        }
        Student s;
        for (Opomena opomena : listaopomena) {
            s = new Student();
            s = opomena.getRacun().getStudent();
            listaStudenataNeplacenaOpomena.add(s);
            //model1.addElement(s);
        }
        listaStudenataNeizdavaOpomena.removeAll(listaStudenataNeplacenaOpomena);
        for (Student student : listaStudenataNeizdavaOpomena) {
            model.addElement(student);
        }
        for (Student student : listaStudenataNeplacenaOpomena) {
            model1.addElement(student);
        }
        jList1.setModel(model);
        jList2.setModel(model1);
    }

    private Opomena pronadjiOpomenu(Student student) {
        Opomena o = new Opomena();
        List<Opomena> opomena = HibernateUtil.getSession().createQuery(
                "FROM Opomena a WHERE a.obrisano=false AND a.placenoNakonOpomene=false "
                        + " AND a.izdavanjeOpomene BETWEEN :stDate AND :edDate ")
                .setParameter("stDate", pocetakTrenutnogMjeseca)
                .setParameter("edDate", krajTrenutnogMjeseca)
                .list();
        for (Opomena op : opomena) {
            if(op.getRacun().getStudent().getSifra()!=student.getSifra()){
                continue;
            }
            o = op;
        }
        return o;
    }

    private void napuniDomove() {
        DefaultComboBoxModel cmbStuDom = new DefaultComboBoxModel();
        List<StudentskiDom> listaDomova = obradaStudentskiDom.dohvatiSveDomove();
        if(listaDomova.size()== 0){
            JOptionPane.showMessageDialog(getRootPane(), "Nema unesenih domova za pregled opomena, molim unesite ih!");
            new StudentskiDomovi().setVisible(true);
            dispose();
            return;
        }else{
            listaDomova.forEach(element -> {
                cmbStuDom.addElement(element);
            });
            cmbStudentskiDom.setModel(cmbStuDom);
            cmbStudentskiDom.setSelectedIndex(0);
            studentskiDom = (StudentskiDom) cmbStudentskiDom.getSelectedItem();
        }
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue()-1;
        cmbMjeseci.setSelectedIndex(month);
    }
}
