<%-- 
    Document   : confirmarAtualizacao.jsp
    Created on : 29/03/2017, 19:02:34
    Author     : DesenvolvedorJava
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualização de Produto</h1>
        <form action="AtualizarProduto" method="POST">
            Id:<input type="hidden" value="${param.id}" name="id" readonly="true" /><br>
            Nome:<input type="text" value="${param.desc}" name="desc" /><br>
            <input type="submit" value="Atualizar" />
        </form>
    </body>
</html>
