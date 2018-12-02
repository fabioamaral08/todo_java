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
<div class="page">
    <% Todo t = (Todo) request.getAttribute("todo");%>
    <h1> <%= t.getName()%> </h1>
    <h3> <%= t.getCat()%> </h3>
    <h3> <%= t.getPriority()%> </h3>
    <h3> <%= t.getDeadline()%> </h3>

    <form action="update_tasks">
        <div class="table"> 
            <table style="width:100%">

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
        </div>
        <button>Salvar</button>
</div>
</form>