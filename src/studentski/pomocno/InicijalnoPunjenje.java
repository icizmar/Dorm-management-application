/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.pomocno;

import studentski.controller.Obrada;
import studentski.model.Racun;
import studentski.model.Soba;
import studentski.model.Student;
import studentski.model.StudentskiDom;

/**
 *
 * @author Ivan
 */
public class InicijalnoPunjenje {
    
    private Obrada<StudentskiDom> obradaStudentskiDom;
    private Obrada<Soba> obradaSoba;
    private Obrada<Student> obradaStudent;
    private Obrada<Racun> obradaRacun;
    
    public InicijalnoPunjenje() {
        obradaStudentskiDom = new Obrada<>();
        obradaSoba = new Obrada<>();
        obradaStudent = new Obrada<>();
        obradaRacun = new Obrada<>();
        StudentskiDom dom = new StudentskiDom();
        dom.setNaziv("Novi studentski dom");
        dom.setAdresa("Kralja Petra Svačića");
        dom.setBrojTelefona("031/234-567");
        try {
            obradaStudentskiDom.save(dom);
        } catch (Exception e) {
        }
        Soba soba1 = new Soba();
        Soba soba2 = new Soba();
        Soba soba3 = new Soba();
        //soba1.setPaviljon("crveni");
       // soba2.setPaviljon("crveni");
       // soba3.setPaviljon("plavi");
        soba1.setBrojSobe(200);
        soba2.setBrojSobe(210);
        soba3.setBrojSobe(200);
        soba1.setBrojKreveta(2);
        soba2.setBrojKreveta(2);
        soba3.setBrojKreveta(2);
       // soba1.setStudentskiDom(dom);
       // soba2.setStudentskiDom(dom);
       // soba3.setStudentskiDom(dom);
        try{
            obradaSoba.save(soba1);
            obradaSoba.save(soba2);
            obradaSoba.save(soba3);
        } catch (Exception e) {
        }
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        student1.setIme("Marko");
        student2.setIme("Pero");
        student3.setIme("Ivana");
        student1.setPrezime("Marić");
        student2.setPrezime("Perić");
        student3.setPrezime("Horvat");
        student1.setOib("12345678910");
        student2.setOib("11111111111");
        student3.setOib("33333333333");
        student1.setSpol(true);
        student2.setSpol(true);
        student3.setSpol(false);
        student1.setSoba(soba1);
        student2.setSoba(soba1);
        student3.setSoba(soba3);
        try{
            obradaStudent.save(student1);
            obradaStudent.save(student2);
            obradaStudent.save(student3); 
        } catch (Exception e){
            
        }
        
        Racun racun1 = new Racun();
        Racun racun2 = new Racun();
        racun1.setPlacen(false);
        racun1.setCijena(500);
        racun1.setStudent(student1);
        racun2.setPlacen(false);
        racun2.setCijena(500);
        racun2.setStudent(student2);
        //U tablicu unjeti sljedeća dva upita:
        //update racun set datumIzdavanjaRacuna='2018-03-03' where sifra = 8;
        //update racun set datumIzdavanjaRacuna='2018-03-03' where sifra = 9;
        try{
            obradaRacun.save(racun1);
            obradaRacun.save(racun2);
        } catch (Exception e){
            
        }
    }
    
    public static void main(String[] args) {
        new InicijalnoPunjenje();
    }

}
