<%-- 
    Document   : produto
    Created on : 16/11/2015, 22:39:28
    Author     : Rhuan Coltre
--%>

<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.picaretas.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Pagina de Produto</title>
    </head>
    <body>
        <div align="center">

            <h1>Welcome the page announcement!</h1>
            <% if (mensagemErro != null) {%>
            <p class="erro"><%= mensagemErro%></p>
            <% }%>


            <form action="Produto" method="POST">
                <input type="hidden" name="id" value="" />
                <label>Categoria</label>
                <select name="categoria">
                    <option value="0">(Selecione)</option>
                    <%
                        if (categorias != null) {
                            for (Categoria c : categorias) {
                    %>
                    <option value="<%= c.getId()%>" ><%= c.getDescricao()%></option>
                    <%
                            }
                        }
                    %>

                </select>
                <label>Descrição</label>
                <input type="text" name="descricao" value="" />
                <label>Detalhes</label>
                <textarea name="detalhes" rows="10" cols="50"> </textarea>
                <label>Valor</label>
                <input type="text" name="valor" value="" />


                <input type="submit" value="Publicar" class="btn btn-success"/>
            </form>


        </div> 
    </body>
</html>
