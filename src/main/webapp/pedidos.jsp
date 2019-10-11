<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.geekstore.model.pedido.Pedido"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="pedidos" scope="request" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Pedidos</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("pedidos", pedidos);
        %>
        <div class="container">
            <table class="table table-striped">
                <h4>Pedidos</h4>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach items="${pedidos}" var="pedido">
                            <td>${pedido.codigo}</td>
                            <td>${pedido.valorTotal}</td>
                        </c:forEach>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>