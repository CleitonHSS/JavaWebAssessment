/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.assessment.dao;

import br.com.javaweb.assessment.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author hp
 */
public class UserDao {
    
    public void cadastrarUser(User user){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    
    public boolean validarUser(User user){
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class, user.getEmail());
        em.close();
        if(u != null && u.getPassword().equals(user.getPassword())){
            return true;
        }
        
        return false;
    }
    
    public User persistirUser(User user){
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class, user.getEmail());
        em.getTransaction().commit();
        em.close();
        return u;
    }
}
