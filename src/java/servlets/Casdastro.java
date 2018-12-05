/*
 * Servlet que trata o cadastro de novos usuários
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        request.setAttribute("list_todo", user.getTodos());
        if (c.userPersist(user)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            request.setAttribute("list_todo", new ArrayList());
            request.setAttribute("page", "home");
            request.getRequestDispatcher("index.htm").forward(request, response);
        } else {
            request.setAttribute("page", "error");
            request.getRequestDispatcher("index.htm").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("page", "new_user");
        request.getRequestDispatcher("index.htm").forward(request, response);
    }
}
