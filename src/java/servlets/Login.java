/*
 * Servlet que trata o login de um usuário
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author Gustavo Gimenez
 */
public class Login extends HttpServlet {

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
        if (s.getAttribute("user") != null) {
            s.invalidate();
        }
        request.setAttribute("page", "login");
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

        Users u = c.login(request.getParameter("login"), request.getParameter("password"));
        if (u == null) {
            
            response.sendRedirect("Login");

        } else {
            request.setAttribute("page", "home");
            HttpSession hs = request.getSession(true);
            hs.setAttribute("user", u);
            response.sendRedirect("Home");
        }
    }
}
