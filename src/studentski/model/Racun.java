/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.model;

import java.io.Serializable;
import java.util.Date;
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
public class Racun extends Entitet implements Serializable{
    
    private Date datumIzdavanjaRacuna;
    private Date datumUplateRacuna;
    private boolean placen;
    private Integer cijena;
    @ManyToOne
    private Student student;

    @Override
    public String toString() {
        return "Racun{" + "datumIzdavanjaRacuna=" + datumIzdavanjaRacuna + ", datumUplateRacuna=" + datumUplateRacuna + ", placen=" + placen + ", cijena=" + cijena + ", student=" + student + '}';
    }
    
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

    public Date getDatumIzdavanjaRacuna() {
        return datumIzdavanjaRacuna;
    }

    public void setDatumIzdavanjaRacuna(Date datumIzdavanjaRacuna) {
        this.datumIzdavanjaRacuna = datumIzdavanjaRacuna;
    }

    public Date getDatumUplateRacuna() {
        return datumUplateRacuna;
    }

    public void setDatumUplateRacuna(Date datumUplateRacuna) {
        this.datumUplateRacuna = datumUplateRacuna;
    }
    
    public Integer getCijena() {
        return cijena;
    }

    public void setCijena(Integer cijena) {
        this.cijena = cijena;
    }
    
}
