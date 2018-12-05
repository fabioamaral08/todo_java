<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>To Do List</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale = 1">
        <style>
            @import url("css/style.css");
        </style>
    </head>

    <body>

        <div class="header">
            <h1>To Do List</h1>   
        </div> 
        <jsp:include page="menu.jsp" />

        <% String pag = (String) request.getAttribute("page");
            if (pag == null) {%>
        <jsp:include page="login.jsp" />
        <% } else if (pag.equals("home")) { %>
        <jsp:include page="list_todo.jsp" />
        <% } else if (pag.equals("logout")) { %>
        <jsp:include page="logout.jsp" />
        <% } else if (pag.equals("new_user")) { %>
        <jsp:include page="new_user.jsp" />
        <% } else if (pag.equals("new_todo")) { %>
        <jsp:include page="new_todo.jsp" />
        <% } else if (pag.equals("view_todo")) { %>
        <jsp:include page="view_todo.jsp" />
        <% } else if (pag.equals("error")) { %>
        <jsp:include page="error.jsp" />
        <% } else { %>
        <jsp:include page="login.jsp" />
        <% }%>



        <div class="footer">
            Trabalho de Java
        </div>
    </body>
</html>
