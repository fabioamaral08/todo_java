/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    private UserPersist up = new UserPersist();
    private TodoPersist tp = new TodoPersist();

    public boolean userPersist(Users user) {
        return user.persist();
    }

    public Users login(String login, String password) {
        return up.verifyUser(login, password);
    }

    public List allToDos(Users user) {
        return tp.getAll(user.getId().toString());
    }

    public Todo getTodo(String id) {
        return tp.getTodo(id);
    }

    public boolean todoPersist(Todo todo){
        return tp.persist(todo);
    }
    
    public boolean addTask(Task task){
        return tp.addTask(task);
    }
    
    public boolean deleteTodo(Todo todo){
        return tp.deleteTodo(todo);
    }
    
    public List allTasks(String id_todo){
        return tp.getTasks(id_todo);
    }
}
