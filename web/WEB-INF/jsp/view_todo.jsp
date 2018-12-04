<%-- 
    Document   : view_task
    Created on : 30/11/2018, 16:27:35
    Author     : Gi
--%>

<%@page import="model.Todo"%>
<%@page import="model.Task"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Todo t = (Todo) request.getAttribute("todo");%>
<form method="POST" action="Update_Task">
    <h1> <%= t.getName()%> </h1>
    <h3> <%= t.getCat()%> </h3>
    <h3> <%= t.getPriority()%> </h3>
    <h3> <%= t.getDeadline()%> </h3>
    <table id="customers">
        <tr>
            <th>Tarefa</th>
            <th>Situação</th> 
            <th>Deletar</th> 
        </tr>
        <tr>
            <% ArrayList<Task> tasks = (ArrayList) request.getAttribute("tasks");
                int i = 0; %>
            <% for (Task task : tasks) {%>
            <td> <%= task.getDescription()%></td>
            <% if (task.isDone()) {%>
            <td> <input type="checkbox" checked="true" name="check" disabled="true" value=<%= task.getId() %> ></td>
                <% } else {%>
            <td> <input type="checkbox" name="check"  value="<%= task.getId() %>" ></td>                
                <% }%>
            <td><a href=<%= "Update_Task?Task_ID=" + t.getId()%>>Deletar</a></td></td>
                <% }%>
        </tr>

    </table>
    <button>Atualizar</button>
</form>
<form class="new_todo" method="POST" action="Add_Task">
    <label>Tarefas</label>
    <input type="hidden" name="id_todo" value="<%= t.getId()%>">
    <input type="text" name="desc">    
    <button> Adicionar Tarefa </button>            
</form>