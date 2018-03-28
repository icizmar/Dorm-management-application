/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */
@Entity
@Table
public class Soba extends Entitet implements Serializable{
    
    private int brojSobe;
    private String paviljon;
    private int brojKreveta;
    @ManyToOne
    private StudentskiDom studentskiDom;
    @OneToMany(mappedBy = "soba")
    private List<Student> studenti = new ArrayList<>();

    public StudentskiDom getStudentskiDom() {
        return studentskiDom;
    }

    public void setStudentskiDom(StudentskiDom studentskiDom) {
        this.studentskiDom = studentskiDom;
    }

    public int getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(int brojSobe) {
        this.brojSobe = brojSobe;
    }

    public String getPaviljon() {
        return paviljon;
    }

    public void setPaviljon(String paviljon) {
        this.paviljon = paviljon;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        return getBrojSobe() + " " + getPaviljon();
    }
    
    
   
}
