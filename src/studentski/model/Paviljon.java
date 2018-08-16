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
public class Paviljon extends Entitet implements Serializable{
    
    private String naziv;
    private Integer brojSoba;

    @ManyToOne
    private StudentskiDom studentskiDom; 
    
    @OneToMany(mappedBy = "paviljon")
    private List<Soba> sobe = new ArrayList<>();

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(Integer brojSoba) {
        this.brojSoba = brojSoba;
    }

    public StudentskiDom getStudentskiDom() {
        return studentskiDom;
    }

    public void setStudentskiDom(StudentskiDom studentskiDom) {
        this.studentskiDom = studentskiDom;
    }

    public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
    }
    
    @Override
    public String toString() {
        return getNaziv();
    }
    
    
}
