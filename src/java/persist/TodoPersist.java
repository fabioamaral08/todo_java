/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Todo;

/**
 *
 * @author fabio
 */
public class TodoPersist {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TODO_ListPU");

    public void persist(Todo object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List getAll(String idUser) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT * FROM todos WHERE user = :idUser");
        q.setParameter("iduser", idUser);
        List result = null;
        try {
            em.getTransaction().begin();
            result = q.getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }

    public Todo getTodo(String id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT * FROM todos WHERE Id = :idTodo");
        q.setParameter("idTodo", id);
        List result = null;
        Todo t = null;
        try {
            em.getTransaction().begin();
            result = q.getResultList();
            em.getTransaction().commit();
            if (result.size() > 0) {
                t = (Todo) result.get(0);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }
//
//    public boolean deleteTodo(String idTodo) {
//        EntityManager em = emf.createEntityManager();
//        em.remove(em);
//        Query q = em.createQuery("SELECT * FROM todos WHERE Id = :idTodo");
//        q.setParameter("idTodo", idTodo);
//        List result = null;
//        Todo t = null;
//        try {
//            em.getTransaction().begin();
//            result = q.getResultList();
//            em.getTransaction().commit();
//            if(result.size() > 0){
//                t = (Todo) result.get(0);
//            }
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        return t;
//    }

}
