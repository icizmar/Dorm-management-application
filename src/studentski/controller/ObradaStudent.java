/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import studentski.model.Paviljon;
import studentski.model.Racun;
import studentski.model.Soba;
import studentski.model.Student;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaStudent {
    
    private Obrada<Student> obrada;
    private ObradaPaviljon obradaPaviljon;
    private ObradaRacun obradaRacun;
    
    public ObradaStudent(){
        obrada = new Obrada<>();
        obradaPaviljon = new ObradaPaviljon();
        obradaRacun = new ObradaRacun();
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

    
    public List<Student> getSviStudentiBezRacuna(StudentskiDom stuDom, Date pMjeseca, Date kMjeseca){
        Session s = HibernateUtil.getSession();
        s.clear();
        List<Student> listaStudenataBezRacuna = new ArrayList<>();
        List<Student> listaSvihStudenata = s.createQuery(
                "select st " +
                "from Student as st " +
                "inner join Soba as so on so.sifra = st.soba " +
                "inner join Paviljon as pa on pa.sifra = so.paviljon " +
                "inner join StudentskiDom as sd on sd.sifra = pa.studentskiDom " +
                "where sd.sifra = :uvjet")
                .setString("uvjet", String.valueOf(stuDom.getSifra()))
                .list();
        List<Racun> listaRacuna = obradaRacun.getListaRacunaUOdabranomMjesecu(pMjeseca, kMjeseca);
        List<Integer> listaSifriStudenataNaRacunima = new ArrayList<>();
        listaRacuna.forEach(element -> {
            listaSifriStudenataNaRacunima.add(element.getStudent().getSifra());
        });
        listaSvihStudenata.forEach(element -> {
            if(!listaSifriStudenataNaRacunima.contains(element.getSifra())){
                listaStudenataBezRacuna.add(element);
            }
        });
        listaStudenataBezRacuna.forEach(x -> {System.out.println(x);});
        return listaStudenataBezRacuna;
    }
    
}
