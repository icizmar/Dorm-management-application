/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */
@Entity
@Table
public class Racun extends Entitet implements Serializable{
    
    private boolean placen;
    @ManyToOne
    private Student student;
    @OneToMany(mappedBy = "racun")
    private List<Opomena> opomene;

    public List<Opomena> getOpomene() {
        return opomene;
    }

    public void setOpomene(List<Opomena> opomene) {
        this.opomene = opomene;
    }

    public boolean isPlacen() {
        return placen;
    }

    public void setPlacen(boolean placen) {
        this.placen = placen;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
