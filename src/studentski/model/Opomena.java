/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */
@Entity
@Table
public class Opomena extends Entitet implements Serializable{
    
    private Date izdavanjeOpomene;
    private boolean placenoNakonOpomene;
    @ManyToOne
    private Racun racun;

    public boolean isPlacenoNakonOpomene() {
        return placenoNakonOpomene;
    }

    public void setPlacenoNakonOpomene(boolean placenoNakonOpomene) {
        this.placenoNakonOpomene = placenoNakonOpomene;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
    public Date getIzdavanjeOpomene() {
        return izdavanjeOpomene;
    }

    public void setIzdavanjeOpomene(Date izdavanjeOpomene) {
        this.izdavanjeOpomene = izdavanjeOpomene;
    }
}
