/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Todo;
import model.Users;
import persist.TodoPersist;
import persist.UserPersist;

/**
 *
 * @author fabio
 */
public class Controller {

    private UserPersist up;
    private TodoPersist tp;

    public boolean userPersist(Users user) {
        return user.persist();
    }

    public Users login(String login, String password) {
        return up.verifyUser(login, password);
    }
    
    public List allToDos(String idUser){
        return tp.getAll(idUser);
    }
    
    public Todo getTodo(String id){
        return tp.getTodo(id);
    }
    
//    public boolean deleteTOdo(String idTodo){
//        return tp.deleteTodo(idTodo);
//    }
}
