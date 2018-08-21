/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Session;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaStudentskiDom {
    
    private Obrada<StudentskiDom> obrada;
    
    public ObradaStudentskiDom(){
        obrada = new Obrada<>();
    }
    
    public List<StudentskiDom> dohvatiSveDomove(){
        Session s = HibernateUtil.getSession();
        s.clear();
        List<StudentskiDom> listaDomova =  s.createQuery( " from StudentskiDom a where a.obrisano = false ").list();
        return listaDomova;
    }
}
