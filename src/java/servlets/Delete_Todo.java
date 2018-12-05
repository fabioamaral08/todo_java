/*
 * Servlet que trata a exclusão de um To Do
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Todo;
import model.Users;

/**
 *
 * @author fabio
 */
public class Delete_Todo extends HttpServlet {

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
        String id = request.getParameter("Todo_ID");
        Todo todo = new Todo();
        todo.setId(Long.parseLong(id));
        Controller c = new Controller();
        HttpSession session = request.getSession();
        if (c.deleteTodo(todo)) {
            request.setAttribute("page", "home");
            request.setAttribute("list_todo", c.allToDos((Users) session.getAttribute("user")));
            request.getRequestDispatcher("index.htm").forward(request, response);
        } else {
            request.setAttribute("page", "error");
            request.getRequestDispatcher("index.htm").forward(request, response);
        }
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
        request.setAttribute("page", "error");
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
