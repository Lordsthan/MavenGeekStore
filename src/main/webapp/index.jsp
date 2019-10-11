<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>GeekStore</title>
    </head>
    <body>
        <div class="navbar">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">GeekStore</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="Servlet?action=ListarPedidos">Listar Pedidos</a></li>
                        <li><a href="Servlet?action=ListarProdutos">Listar Produtos</a></li>
                        <li><a href="Servlet?action=CadastrarProduto">Cadastrar Produtos</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>