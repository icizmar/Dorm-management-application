/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import studentski.model.Soba;
import studentski.model.Student;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaStudent {
    
    private Obrada<Student> obrada;
    
    public ObradaStudent(){
        obrada = new Obrada<>();
    }
    
    public List<Student> getStudenti(String uvjet){
        Session s = HibernateUtil.getSession();
        s.clear();
        return s.createQuery(
                " from Student a where a.obrisano=false "
                        + " and concat(a.ime,' ',a.prezime) like :uvjet ")
                .setString("uvjet", "%" + uvjet + "%")
                .setMaxResults(50)
                .list();
    }
    
    public List<Student> dohvatiSveStudenteIzOdabraneSobe(Soba soba){
        Session s = HibernateUtil.getSession();
        s.clear();
        List<Student> listaStudenata = s.createQuery(
                " from Student a where a.obrisano = false and soba like :uvjet")
                .setString("uvjet", "%" + soba.getSifra() + "%")
                .list();
        return listaStudenata;
    }
    
    public Student spremi(Student st) throws StucException {
        
        if(st.getIme()== null || st.getIme().trim().length()==0){
            throw new StucException("Obavezno unesite ime!", "ime");
        }
        if(st.getPrezime()==null || st.getPrezime().trim().length()==0){
            throw new StucException("Obavezno unjeti prezime!", "prezime");
        }
        
        st = obrada.save(st);
        return st;
    }
    
    public Student obrisi(Student st)throws StucException {
        obrada.delete(st);
        return st;
    }
    
    public boolean imaLiStudenataUDomu(){
        boolean check = false;
        Session s = HibernateUtil.getSession();
        s.clear();
        Query query = s.createQuery(
            "select count(*) from Student a where a.obrisano = false");
        Long count = ((Long)query.uniqueResult());
        if(count == 0){
            check = false;
        }else{
            check = true;
        }
        return check;
    }
    
    public List<Student> dohvatiStudenteKojiNisuUSobi(){
        Session s = HibernateUtil.getSession();
        s.clear();
        List<Student> listaStudenata = s.createQuery(
                "from Student a where a.obrisano = false and "
                        + "soba is null").list();
        return listaStudenata;
    }
}
