<%-- 
    Document   : new_user
    Created on : 30/11/2018, 15:47:35
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="page">
    <form method="POST" action="Cadastro">
        <label>Nome</label>
        <input type="text" name="name" required>
        <label>Email</label>
        <input type="email" name="login" required>
        <label>Senha</label>
        <input type="password" name="password" required>
        <button>Cadastrar</button>
    </form>
</div>