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
<form action="">
    <h3> <%= t.getCat()%> </h3>
    <h3> <%= t.getPriority()%> </h3>
    <h3> <%= t.getDeadline()%> </h3>
    <table id="customers">
        <tr>
            <th>Tarefa</th>
            <th>Situação</th> 
        </tr>
        <tr>
            <% ArrayList<Task> tasks = (ArrayList) t.getTasks();
                int i = 0; %>
            <% for (Task task : tasks) {%>
            <td> <%= task.getDescription()%></td>
            <% if (task.isDone()) {%>
            <td> <input type="checkbox" checked="true" disabled="true" name=<%= "check" + i%> ></td>
                <% } else {%>
            <td> <input type="checkbox" name= <%= "check" + i%> ></td>                
                <% }%>
        </tr>

    </table>
    <button>Atualizar</button>
</form>
<form class="new_todo" name="form2" method="POST" action="AddTask">
    <label>Tarefas</label>
    <input type="text" name="task">    
    <button> Adicionar Tarefa </button>            
</form>