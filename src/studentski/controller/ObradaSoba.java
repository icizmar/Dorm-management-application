/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski.controller;

import java.util.List;
import studentski.model.Soba;
import studentski.pomocno.HibernateUtil;

/**
 *
 * @author Ivan
 */
public class ObradaSoba {
    
    private Obrada<Soba> obrada;
    
    public ObradaSoba(){
        obrada = new Obrada<>();
    }
    
    public List<Soba> getSoba(Integer brojSobe, String paviljon){
        return HibernateUtil.getSession().createQuery(
                " from Soba a where a.obrisano=false "
                        + " and brojSobe like :uvjet1 and paviljon like :uvjet2 ")
                .setString("uvjet1", "%" + brojSobe + "%")
                .setString("uvjet2", "%" + paviljon + "%")
                .list();
    }
}
