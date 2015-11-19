<%-- 
    Document   : consulta
    Created on : 09/11/2015, 21:30:18
    Author     : Rhuan Coltre
--%>

<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.picaretas.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
%>

<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Consulta de produtos</title>
    </head>
    <body>
        <h1>Page for query the products</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        
        <button onclick="window.location='Produto'"> Anunciar </button>
        <br /><br />
        <form method="GET" action="Consulta">
            <label>Buscar</label>
            <input type="text" name="busca" value="" />
            <input type="submit" value="Buscar" class="btn btn-inverse"/>
            
        </form>
        <br />
        <table style="border-style: 2"> 

            <tr>
                <th colspan="2">Produto</th>
                <th>Valor</th>
                <th>Categoria</th>
                <th>Data/Hora</th>
            </tr>

            <!-- Preencher tabela -->
            <%
                if (produtos != null) {
                    for (Produto prod : produtos) {

            %>
            <tr>
                <td></td>
                <td><%= prod.getDescricao()%></td>
                <td><%= prod.getValorString()%></td>
                <td><%= prod.getCategoria().getDescricao()%></td>
                <td><%= prod.getDataPostagemString()%></td>
            </tr>
            <%                    }
                }
            %>

        </table>

    </body>
</html>
