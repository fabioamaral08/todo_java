/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;

/**
 *
 * @author fabio
 */
public class Casdastro extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
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
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        Users user = new Users();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        if (c.userPersist(user)) {
            request.setAttribute("page", "home");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("page", "error_signup");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
