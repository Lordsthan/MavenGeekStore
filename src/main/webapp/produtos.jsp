<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.geekstore.model.produto.Produto"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="produtos" scope="request" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Produtos</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("produtos", produtos);
        %>
        <div class="container">
            <table class="table table-striped">
                <h4>Produtos</h4>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${produtos}" var="produto">
                        <tr>
                            <td>${produto.codigo}</td>
                            <td>${produto.nome}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>