<%-- 
    Document   : menu
    Created on : 30/11/2018, 15:27:49
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<div class="navbar">
    <% if (session.getAttribute("user") == null) { %>
    <a href="index">Home</a>
    <a href="login">Login</a>
    <% } else {%>
    <a href="login">Logout</a>
    <% } %>



</div>
