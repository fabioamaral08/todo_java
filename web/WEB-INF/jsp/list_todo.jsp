<%-- 
    Document   : list_task
    Created on : 30/11/2018, 16:06:15
    Author     : Gi
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="model.Users"%>
<%@page import="model.Todo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="table">
    <table id="customers">

        <tr>
            <th>Nome</th>
            <th>Categoria</th> 
            <th>Prioridade</th>
            <th>Prazo</th>
            <th>Ações</th>
        </tr>

        <% ArrayList<Todo> todo_list = (ArrayList) request.getAttribute("list_todo"); %>
        <% DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); %>
        <% for (Todo t : todo_list) {%>
        <tr>
            <td> <%= t.getName()%></td>
            <td> <%= t.getCat()%></td>
            <td> <%= t.getPriority()%></td>
            <td> <% if (t.getDeadline() != null) {%>
                <%= df.format((Date) t.getDeadline())%>
                <% }%></td>
            <td> <a href=<%= "View_Todo?Todo_ID=" + t.getId()%>>Ver detalhes</a>
                <a href=<%= "Delete_Todo?Todo_ID=" + t.getId()%>>Deletar</a></td>
        </tr>
        <% }%>


    </table>
</div>
