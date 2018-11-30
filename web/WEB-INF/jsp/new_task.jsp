<%-- 
    Document   : new_task
    Created on : 30/11/2018, 15:52:38
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="page">
    <form method="POST" action="">
        <label>Nome</label>
        <input type="text" name="name" required>
        <label>Descrição</label>
        <input type="text" name="desc" required>
        <label>Prioridade</label>
        <select>
            <option value="0">Alta</option>
            <option value="1">Média</option>
            <option value="2">Baixa</option>
        </select>     
        <label>Prazo</label>
        <input type="date" name="prazo" required>
        <button>Cadastrar</button>
    </form>
</div>
