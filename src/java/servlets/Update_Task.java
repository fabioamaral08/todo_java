/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Update_Task extends HttpServlet {

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
        Controller c = new Controller();
        String id = request.getParameter("Task_ID");
        String idTodo = request.getParameter("Todo_ID");

        c.deleteTask(id);

        response.sendRedirect("View_Todo?Todo_ID=" + idTodo);

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

        String[] checks = request.getParameterValues("check");
        String idTodo = request.getParameter("id_todo");
        Todo todo = c.getTodo(idTodo);

        for (String check : checks) {
            if (check != null) {
                c.updateTask(check);
            }
        }

        List<Task> tasks = c.allTasks(idTodo);
        request.setAttribute("tasks", tasks);
        request.setAttribute("todo", todo);
        request.setAttribute("page", "view_todo");
        request.getRequestDispatcher("index.htm").forward(request, response);
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
