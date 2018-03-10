/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentski;


import studentski.controller.Obrada;
import studentski.model.Student;
import studentski.model.StudentskiDom;
import studentski.pomocno.HibernateUtil;
import studentski.view.Izbornik;
/**
 *
 * @author Ivan
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HibernateUtil.getSession();
        new Izbornik().setVisible(true);
        
    }
    
}
