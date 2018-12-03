<%-- 
    Document   : new_task
    Created on : 30/11/2018, 15:52:38
    Author     : Gi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form name="form1" class="new_todo" method="POST" action="CreateTodo">
    <label>Nome</label>
    <input type="text" name="name" required>
    <label>Categoria</label>
    <input type="text" name="cat" >
    <label>Prioridade</label>
    <select name="priority" id="priority">
        <option value="0">Alta</option>
        <option value="1">Média</option>
        <option value="2">Baixa</option>
    </select>     
    <label>Prazo</label>
    <input type="date" name="date">
    <button>Cadastrar</button>
</form>



