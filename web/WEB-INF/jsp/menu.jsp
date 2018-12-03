<%-- 
    Document   : menu
    Created on : 30/11/2018, 15:27:49
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<div class="navbar">
    <% if (session.getAttribute("user") == null) { %>
    <a href="Login">Home</a>
    <a href="Login">Login</a>
    <a href="Cadastro">Cadastrar</a>
    <% } else {%>
    <a href="Login">Home</a>
    <a href="CreateTodo">Criar Tarefas</a>
    <a href="Login">Logout</a>
    <% }%>



</div>
