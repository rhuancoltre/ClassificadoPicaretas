<%-- 
    Document   : login
    Created on : 04/11/2015, 19:47:58
    Author     : Rhuan Coltre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <h1> PICARETAS</h1>
        <h2>Login </h2>
        <form name="form-login" method="POST" action="Login">
            <input type="hidden" name="acao" value="login" />
            <label>Usuario/E-mail: </label>
            <input type="text" name="usuario" value="" />
            <br />
            <label>Senha: </label>
            <input type="password" name="senha" value="" />
            <br />

            <input type="submit" name="Entrar" />

        </form>
        <br />
        <h2>Cadastro </h2>
        <form name="form-cadastro" method="POST" action="Login"> 
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

    </body>
</html>
