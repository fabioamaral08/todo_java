/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import com.mysql.jdbc.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Users;

/**
 *
 * @author fabio
 */
public class UserPersist {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TODO_ListPU");

    public boolean persist(Users user) {
        EntityManager em = emf.createEntityManager();
        boolean commited;
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            commited = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            commited = false;
        } finally {
            em.close();
        }
        return commited;
    }
    
    
    public Users verifyUser(String login, String password){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM Users u WHERE login = :login AND password = :password");
        q.setParameter("password", password);
        q.setParameter("login", login);
        Users user = null;
        List result;
        try {
            em.getTransaction().begin();
            result = q.getResultList();
            em.getTransaction().commit();
            if(result.size() > 0){
                user = (Users) result.get(0);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }
}
