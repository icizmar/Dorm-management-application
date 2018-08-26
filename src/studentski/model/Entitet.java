/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Ivan
 */
@MappedSuperclass
public abstract class Entitet {
    @Id
    @GeneratedValue
    private int sifra;
    private Date datumKreiranja;
    private Date datumPromjene;
    private Date datumBrisanja;
    private boolean obrisano = false;
   

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumPromjene() {
        return datumPromjene;
    }

    public void setDatumPromjene(Date datumPromjene) {
        this.datumPromjene = datumPromjene;
    }

    public Date getDatumBrisanja() {
        return datumBrisanja;
    }

    public void setDatumBrisanja(Date datumBrisanja) {
        this.datumBrisanja = datumBrisanja;
    }

    public boolean isObrisano() {
        return obrisano;
    }

    public void setObrisano(boolean obrisano) {
        this.obrisano = obrisano;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entitet other = (Entitet) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        return true;
    }
    
    
}
