<%-- 
    Document   : login
    Created on : 04/11/2015, 19:47:58
    Author     : Rhuan Coltre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Login Picaretas</title>

        <style type="text/css">
            /*
            Código CSS para ajustar o tamanho dos formulários
            */
            .control-group .control-label {
                width: 80px !important;
            }
            .form-horizontal .controls {
                margin-left: 100px !important;
            }
        </style>
    </head>
    <body>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <h1>Welcome to homepage the Picaretas</h1>
        <div class="span5" >
            <h2>Login </h2>
            <form name="form-login" method="POST" action="Login" 
                  class="form-horizontal">
                <input type="hidden" name="acao" value="login" />
                <label>Apelido/E-mail: </label>
                <input type="text" name="apelido" value="" />
                <br />
                <label>Senha: </label>
                <input type="password" name="senha" value="" />
                <br />
                <br />

                <input type="submit" name="Entrar" />

            </form>
        </div>


        <div class="span5" >
            <h2>Cadastro </h2>
            <form name="form-cadastro" method="POST" action=""
                  class="form-horizontal" style="float: left"> 
                <input type="hidden" name="acao" value="cadastro" />
                <label>Apelido </label>
                <input type="text" name="apelido" value="" />
                <br />
                <label>E-mail: </label>
                <input type="text" name="email" value="" />
                <br />
                <label>Senha: </label>
                <input type="password" name="senha" value="" />
                <br />
                <input type="submit" name="Cadastrar" />
            </form>
        </div>

    </body>
</html>
