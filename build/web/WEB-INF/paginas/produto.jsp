<%-- 
    Document   : produto
    Created on : 16/11/2015, 22:39:28
    Author     : Rhuan Coltre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Pagina de Produto</title>
    </head>
    <body>
        <h1>Bem vindo a pagina de produto!</h1>
        <h2>CADASTRAR </h2>
        
        
        <form method="GET" action="Produto">
            <label>Cadastrar</label>
            <input type="text" name="produto" value="" />
            
            <input type="submit" value="Cadastrar" />
        </form>

        
    </body>
</html>
