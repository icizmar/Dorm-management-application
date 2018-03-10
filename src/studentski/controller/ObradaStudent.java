/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.List;
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
        return HibernateUtil.getSession().createQuery(
                " from Student a where a.obrisano=false "
                        + " and concat(a.ime,' ',a.prezime) like :uvjet ")
                .setString("uvjet", "%" + uvjet + "%")
                .setMaxResults(50)
                .list();
    }
    
    
}
