<%-- 
    Document   : consulta
    Created on : 09/11/2015, 21:30:18
    Author     : Rhuan Coltre
--%>

<%@page import="br.grupointegrado.ads.picaretas.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Consulta de produtos</title>
    </head>
    <body>
        <h1>Página de consulta de produtos</h1>
        <br />
        <form method="GET" action="Consulta">
            <label>Buscar</label>
            <input type="text" name="busca" value="" />
            <input type="submit" value="Buscar" />
        </form>
        <br />
        <table style="border-style: 2"> 

            <tr>
                <th>Produto</th>
                <th>Valor</th>
                <th>Categoria</th>
                <th>Data/Hora</th>

            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>  
            </tr>

        </table>

    </body>
</html>
