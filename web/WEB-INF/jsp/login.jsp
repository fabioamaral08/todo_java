<%-- 
    Document   : login
    Created on : 30/11/2018, 15:25:52
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<div class="page">
    <form method="POST" action="Login">
        <label>Email</label>
        <input type="email" name="login" required>
        <label>Senha</label>
        <input type="password" name="password" required>
        <button>Login</button>
    </form>
</div>
