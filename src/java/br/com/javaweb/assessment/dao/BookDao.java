/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.assessment.dao;

import br.com.javaweb.assessment.model.Books;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
public class BookDao {

    public void cadastrarBook(Books book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Books> consultarBooks() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Books.findAll");
        List<Books> Books = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return Books;
    }
   
    
    public void excluirBook(Books book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Books bookExcluir = em.find(Books.class, book.getIdbook());
        em.remove(bookExcluir);
        em.getTransaction().commit();
        em.close();
    }
    
    public Books persistirBook(Books book){
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Books b = em.find(Books.class, book.getIdbook());
        em.getTransaction().commit();
        em.close();
        return b;
    }
    
    public void editarBook(Books book) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaWebAssessPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }
    
}
    

