/*
 * Classe que controla a interação com o Banco
 */
package controller;

import java.util.List;
import model.Task;
import model.Todo;
import model.Users;
import persist.TodoPersist;
import persist.UserPersist;

/**
 *
 * @author fabio
 */
public class Controller {
    /**
     * Persistência do Usuário
     */
    private UserPersist up = new UserPersist();
    /**
     * Persistência do To Do
     */
    private TodoPersist tp = new TodoPersist();

    /**
     * Chama a persistência do usuário
     * @param user User
     * @return 
     */
    public boolean userPersist(Users user) {
        return user.persist();
    }

    /**
     * Chama a verificação do usuário 
     * @param login String email
     * @param password String senha
     * @return 
     */
    public Users login(String login, String password) {
        return up.verifyUser(login, password);
    }

    /**
     * Retorna todos os To Do de um usuário
     * @param user User
     * @return List
     */
    public List allToDos(Users user) {
        return tp.getAll(user.getId().toString());
    }

    /**
     * Retorna um To Do específico
     * @param id String id Todo
     * @return Todo
     */
    public Todo getTodo(String id) {
        return tp.getTodo(id);
    }
    
    /**
     * Chama a persistência de um Todo
     * @param todo Todo
     * @return boolean true com sucesso, false caso contrário
     */
    public boolean todoPersist(Todo todo){
        return tp.persist(todo);
    }
    
    /**
     * Chama a persisntência de uma Task
     * @param task Task
     * @return boolean true se sucesso, false caso contrário
     */
    public boolean addTask(Task task){
        return tp.addTask(task);
    }
    
    /**
     * Deleta um To do
     * @param todo
     * @return boolean true se sucesso, false caso contrário
     */
    public boolean deleteTodo(Todo todo){
        return tp.deleteTodo(todo);
    }
    
    /**
     * Retorna todas as Tasks de um Todo
     * @param id_todo String id do Todo
     * @return List de Tasks
     */
    public List allTasks(String id_todo){
        return tp.getTasks(id_todo);
    }
    
    /**
     * Atualiza uma Task
     * @param idTask String id Task
     */
    public void updateTask(String idTask){
        tp.updateTask(Long.parseLong(idTask));
    }
    
    /**
     * Deleta uma Task
     * @param idTask String de uma Task
     */
    public void deleteTask(String idTask){
        tp.deleteTask(Long.parseLong(idTask));
    }
}
