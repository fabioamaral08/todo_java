<%-- 
    Document   : list_task
    Created on : 30/11/2018, 16:06:15
    Author     : Gi
--%>

<%@page import="model.Users"%>
<%@page import="model.Todo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table id="customers">

    <tr>
        <th>Nome</th>
        <th>Categoria</th> 
        <th>Prioridade</th>
        <th>Ações</th>
    </tr>
    <tr>
        <% ArrayList<Todo> todo_list = (ArrayList) request.getAttribute("list_todo"); %>
        <% for (Todo t : todo_list) {%>
        <td> <%= t.getCat()%></td>
        <td> <%= t.getPriority()%></td>
        <td> <a href=<%= "view_todo?Todo_ID=" + t.getId()%>>Ver detalhes</a>
            <a href=<%= "excluir?Todo_ID=" + t.getId()%>>Ver detalhes</a></td>
            <% }%>
    </tr>

</table>
