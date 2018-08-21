/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import org.hibernate.Session;
import studentski.model.Paviljon;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaPaviljon {
    
    private Obrada<Paviljon> obrada;
    
    public ObradaPaviljon(){
        obrada = new Obrada<>();
    }
    
    public Paviljon spremi(Paviljon pav) throws StucException {
        if(pav.getNaziv()== null || pav.getNaziv().trim().length()==0){
            throw new StucException("Obavezno unesite naziv paviljona", "naziv");
        }
        pav = obrada.save(pav);
        return pav;
    }
    
    public void promjeni(Paviljon pav) {
        obrada.save(pav);
    }
    
    public void obrisi(Paviljon pav){
        obrada.delete(pav);
    }
    
    public DefaultListModel<Paviljon> ucitajPaviljone(){
        DefaultListModel<Paviljon> dlmPaviljon = new DefaultListModel<>();
        Session s = HibernateUtil.getSession();
        s.clear();
        List<Paviljon> listaSvihPaviljona = s.createQuery( " from Paviljon a where a.obrisano=false ").list();
        listaSvihPaviljona.forEach(x -> {
            dlmPaviljon.addElement(x);
        });
        return dlmPaviljon;
    }
    
    public List<Paviljon> dohvatiSvePaviljoneUOdabranomDomu(StudentskiDom stuDom){
        Session s = HibernateUtil.getSession();
        s.clear();
        List<Paviljon> listaPaviljona = s.createQuery( 
                " from Paviljon a where a.obrisano=false and studentskiDom like :uvjet")
                .setString("uvjet", "%" + stuDom.getSifra() + "%")
                .list();
        return listaPaviljona;
    }
}
