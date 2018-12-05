/*
 * Classe que trata a persistencia do To Do
 */
package persist;

import java.util.ArrayList;
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

    /**
     * Faz a persistencia no Banco de Dados de um objeto Todo
     * 
     * @param todo Todo
     * @return boolean true se a operação foi realizada com sucesso, false caso contrário
     */
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
    
    /**
     * Busca no Banco de Dados todos os Todos de um usuário
     * 
     * @param idUser String id do usuário
     * @return List lista de objetos Todo
     */

    public List getAll(String idUser) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT td FROM Todo td WHERE owner_id = :idUser");
        q.setParameter("idUser", idUser);
        List result = new ArrayList();
        try {
            em.getTransaction().begin();
            result.addAll(q.getResultList());
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }

    /**
     * Busca no Banco de Dados um Todo específico
     * @param id String id do Todo
     * @return Todo
     */
    public Todo getTodo(String id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT t FROM Todo t WHERE Id = :idTodo");
        q.setParameter("idTodo", id);
        List result;
        ArrayList tasks = new ArrayList();
        Todo t = null;
        try {
            result = q.getResultList();
            if (result.size() > 0) {
                t = (Todo) result.get(0);
                q = em.createQuery("SELECT ts FROM Task ts WHERE todo_id = :idTodo");
                q.setParameter("idTodo", id);
                result = q.getResultList();
                tasks.addAll(result);
                t.setTasks(tasks);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }
    
    /**
     * Faz a persistência de uma Task no Banco de Dados 
     * @param task Task
     * @return boolean true se a operação foi realizada com sucesso, false caso contrário
     */
    public boolean addTask(Task task) {
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
    
    /**
     * Deleta todas as Tasks de um Todo no Banco de Dados
     * 
     * @param todo Todo
     */
    public void deleteAllTask(Todo todo) {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("DELETE FROM Task WHERE todo_id = :idTodo");
        q.setParameter("idTodo", todo.getId());
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Deleta um Todo do Banco de Dados
     * 
     * @param todo Todo
     * @return 
     */
    public boolean deleteTodo(Todo todo) {
        EntityManager em = emf.createEntityManager();
        boolean commited;
        Query q = em.createQuery("DELETE FROM Todo WHERE Id = :idTodo");
        q.setParameter("idTodo", todo.getId());
        try {
            em.getTransaction().begin();
            deleteAllTask(todo);
            q.executeUpdate();
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

    /**
     * Busca no Banco de Dados todos as Tasks de um Todo
     * 
     * @param id_todo String id do Todo
     * @return 
     */
    public List getTasks(String id_todo) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT t FROM Task t WHERE todo_id = :idTodo");
        q.setParameter("idTodo", id_todo);
        List result = new ArrayList();
        try {
            em.getTransaction().begin();
            result.addAll(q.getResultList());
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    /**
     * Atualiza os dados de uma Task no Banco de Dados
     * 
     * @param idTask Long id da Task
     */

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("UPDATE Task t SET done = true WHERE id = :idTask");
        q.setParameter("idTask", idTask);
        try {
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
    /**
     * Deleta uma Task do Banco de Dados
     * 
     * @param idTask Long id da Task
     */    
    public void deleteTask(Long idTask){

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("DELETE FROM Task WHERE id = :idTask");
        q.setParameter("idTask", idTask);
        try {
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
