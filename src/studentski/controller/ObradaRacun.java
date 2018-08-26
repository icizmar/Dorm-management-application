/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import studentski.model.Racun;
import studentski.model.Student;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaRacun {
    
    private Obrada<Racun> obrada;
    
    public ObradaRacun(){
        obrada = new Obrada<>();
    }

    public List<Racun> getListaRacunaUOdabranomMjesecu(Date pMjeseca, Date kMjeseca) {
        System.err.println("UNUTAR METODE DOĐEM");
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "FROM Racun a WHERE a.obrisano=false and a.datumIzdavanjaRacuna BETWEEN :stDate AND :edDate ")
                    .setParameter("stDate", pMjeseca)
                    .setParameter("edDate", kMjeseca)
                    .list();
    }

    public List<Racun> getListaSvihPlacenihUOdabranomMjesecu(Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "FROM Racun a WHERE a.obrisano=false AND a.datumIzdavanjaRacuna BETWEEN :startDate AND :endDate "
                        + " AND a.datumUplateRacuna is not null ")
                        .setParameter("startDate", pMjeseca)
                        .setParameter("endDate", kMjeseca)
                        .list();
    }
    public List<Racun> getListaSvihPlacenihUOdabranomMjesecuIDomu(StudentskiDom stuDom, Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "SELECT r " +
                        "from Racun as r " +
                        "inner join Student as st on st.sifra = r.student " +
                        "inner join Soba as so on so.sifra = st.soba " +
                        "inner join Paviljon as pa on pa.sifra = so.paviljon " +
                        "inner join StudentskiDom as sd on sd.sifra = pa.studentskiDom " +
                        "where sd = :uvjet " +
                        "and r.obrisano = false " +
                        "and r.datumIzdavanjaRacuna between :startDate and :endDate")
                        .setString("uvjet", String.valueOf(stuDom.getSifra()))
                        .setParameter("startDate", pMjeseca)
                        .setParameter("endDate", kMjeseca)
                        .list();
    }

    public List<Racun> getListaSvihNelacenihUOdabranomMjesecuIDomu(StudentskiDom stuDom, Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "SELECT r " +
                        "from Racun as r " +
                        "inner join Student as st on st.sifra = r.student " +
                        "inner join Soba as so on so.sifra = st.soba " +
                        "inner join Paviljon as pa on pa.sifra = so.paviljon " +
                        "inner join StudentskiDom as sd on sd.sifra = pa.studentskiDom " +
                        "where sd = :uvjet " +
                        "and r.obrisano = false " +
                        "and r.placen = false " +
                        "and r.datumIzdavanjaRacuna between :startDate and :endDate")
                        .setString("uvjet", String.valueOf(stuDom.getSifra()))
                        .setParameter("startDate", pMjeseca)
                        .setParameter("endDate", kMjeseca)
                        .list();
    }
    
    public List<Racun> getListaSvihNeplacenihUOdabranomMjesecu(Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "FROM Racun a WHERE a.obrisano=false AND a.datumIzdavanjaRacuna BETWEEN :startDate AND :endDate "
                        + " AND a.datumUplateRacuna is null ")
                        .setParameter("startDate", pMjeseca)
                        .setParameter("endDate", kMjeseca)
                        .list();
    }

    public Racun getRacunZaPojedinosti(Student student, Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        Racun r = new Racun();
        List<Racun> listaRacuna = s.createQuery(
                "FROM Racun a WHERE a.obrisano=false and student like :uvjet and a.datumIzdavanjaRacuna BETWEEN :stDate AND :edDate ")
                .setString("uvjet", "%" + student.getSifra() + "%")
                .setParameter("stDate", pMjeseca)
                .setParameter("edDate", kMjeseca)
                .list();
        for (Racun racun : listaRacuna) {
            r = racun;
        }
        return r;
    }

    public List<Racun> getListaRacuna(Student student, Date pMjeseca, Date kMjeseca) {
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                "FROM Racun a WHERE a.obrisano=false and student like :uvjet and a.datumIzdavanjaRacuna BETWEEN :stDate AND :edDate ")
                .setString("uvjet", "%" + student.getSifra() + "%")
                .setParameter("stDate", pMjeseca)
                .setParameter("edDate", kMjeseca)
                .list();
    }
    
}
