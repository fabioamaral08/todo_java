/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Task;
import model.Todo;

/**
 *
 * @author fabio
 */
public class TodoPersist {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TODO_ListPU");

    public boolean persist(Todo todo) {
        EntityManager em = emf.createEntityManager();
        boolean commited;
        try {
            em.getTransaction().begin();
            em.persist(todo);
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

    public List getAll(String idUser) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT td FROM Todo td WHERE owner_id = :idUser");
        q.setParameter("idUser", idUser);
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
        Query q = em.createQuery("SELECT * FROM Todo WHERE Id = :idTodo");
        q.setParameter("idTodo", id);
        List result;
        Todo t = null;
        try {
            result = q.getResultList();
            if (result.size() > 0) {
                t = (Todo) result.get(0);
                q = em.createQuery("SELECT * FROM Task WHERE todo_id = :idTodo");
                q.setParameter("idTodo", id);
                result = q.getResultList();
                t.setTasks(result);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }
    
    public boolean addTask(Task task){
        EntityManager em = emf.createEntityManager();
        boolean commited;
        try {
            em.getTransaction().begin();
            em.persist(task);
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
