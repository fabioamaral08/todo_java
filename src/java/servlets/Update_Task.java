/*
 * Servlet que trata a atualização de uma tarefa
 */
package servlets;

import controller.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        if (checks == null) {
            request.setAttribute("page", "error");
        } else {

            for (String check : checks) {
                if (check != null) {
                    c.updateTask(check);
                }
            }
        }
        response.sendRedirect("View_Todo?Todo_ID=" + idTodo);
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
