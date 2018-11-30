<%-- 
    Document   : new_user
    Created on : 30/11/2018, 15:47:35
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="page">
    <form method="POST" action="">
        <label>Nome</label>
        <input type="text" name="name" required>
        <label>Email</label>
        <input type="email" name="email" required>
        <label>Senha</label>
        <input type="password" name="senha" required>
        <button>Cadastrar</button>
    </form>
</div>