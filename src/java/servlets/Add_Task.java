/*
 * Servlet que trata a adição de tarefas em um To Do
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Task;
import model.Todo;

/**
 *
 * @author Gi
 */
public class Add_Task extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("page", "error");
        request.getRequestDispatcher("index.htm").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Controller c = new Controller();

        String desc = request.getParameter("desc");
        String id = request.getParameter("id_todo");

        Todo todo = c.getTodo(id);

        Task task = new Task();
        task.setDescription(desc);
        task.setTodo(todo);

        if (c.addTask(task)) {
            List<Task> tasks = c.allTasks(id);
            request.setAttribute("tasks", tasks);
            request.setAttribute("page", "view_todo");
            request.setAttribute("todo", todo);
            request.getRequestDispatcher("index.htm").forward(request, response);
        } else {
            request.setAttribute("page", "erro");
            request.getRequestDispatcher("index.htm").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
