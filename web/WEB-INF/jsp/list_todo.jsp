<%-- 
    Document   : list_task
    Created on : 30/11/2018, 16:06:15
    Author     : Gi
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="table"> 
    <table style="width:100%">

        <tr>
            <th>Nome</th>
            <th>Categoria</th> 
            <th>Prioridade</th>
            <th>Ações</th>
        </tr>
        <tr>
            <% ArrayList<Todo> todo_list = (ArrayList) request.getAttribute("todo_list"); %>
            <% for (Todo t : todo_list) {%>
            <td> <%= t.getName()%></td>
            <td> <%= t.getCat()%></td>
            <td> <%= t.getPriority()%></td>
            <td> <a href=<%= "view_todo?Todo_ID=" + t.getId()%>>Ver detalhes</a>
                <a href=<%= "excluir?Todo_ID=" + t.getId()%>>Ver detalhes</a></td>
                <% }%>
        </tr>

    </table>
</div>