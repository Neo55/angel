/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.angel.dao;

import com.mycompany.angel.model.Kursanty;
import com.mycompany.angel.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author FARHAD
 */
public class PeoplesDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    
    public Kursanty getKursantyById(int id){
    Kursanty Kursanty = null;
    Session session = null;
    
    try {
    session = sessionFactory.openSession();
    session.beginTransaction();
    Kursanty = (Kursanty) session.createQuery("from Person p where p.id = :ID").setParameter("ID", id).uniqueResult();
   session.getTransaction().commit();
    }
    catch(Exception ex){
    if (session !=null) {
    session.getTransaction().rollback();
    }
    }
    finally{
    if (session !=null){
    session.close();
    }
    }
    
    return Kursanty;
    }
    
    
    
    public List<Kursanty> getAllKursants(){
   List<Kursanty> Kursants = null;
    Session session = null;
    
    try {
    session = sessionFactory.openSession();
    session.beginTransaction();
    Kursants = session.createQuery("from Person p").list();
   session.getTransaction().commit();
    }
    catch(Exception ex){
    if (session !=null) {
    session.getTransaction().rollback();
    }
    }
    finally{
    if (session !=null){
    session.close();
    }
    }
    
    return Kursants;
    }
}
