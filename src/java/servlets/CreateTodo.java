/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import controller.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateTodo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateTodo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(CreateTodo.class.getName()).log(Level.SEVERE, null, ex);
        }

        Users user = (Users) request.getSession().getAttribute("user");
        int priority = Integer.parseInt(request.getParameter("priority"));

        Todo todo = new Todo();
        todo.setCat(cat);
        todo.setDeadline(date);
        todo.setOwner(user);
        todo.setPriority(priority);
        
        if (c.todoPersist(todo)) {
            request.setAttribute("todo", todo);
            request.setAttribute("page", "view_todo");
            request.getRequestDispatcher("index.htm").forward(request, response);
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
