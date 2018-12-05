/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Todo;
import model.Users;

/**
 *
 * @author Gi
 */
public class CreateTodo extends HttpServlet {

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
        HttpSession s = request.getSession();
        if (s.getAttribute("user") == null) {
            request.setAttribute("page", "login");
        } else {
            request.setAttribute("page", "new_todo");
        }
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
        String name = request.getParameter("name");
        String cat = request.getParameter("cat");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(CreateTodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        String priority = (request.getParameter("priority"));

        Todo todo = new Todo();
        todo.setCat(cat);
        todo.setDeadline(date);
        todo.setOwner(user);
        todo.setPriority(priority);
        todo.setName(name);
        if (c.todoPersist(todo)) {
                response.sendRedirect("View_Todo?Todo_ID=" + todo.getId());
        } else {
            request.setAttribute("page", "error_signup");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
