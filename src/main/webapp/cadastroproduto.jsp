<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.geekstore.model.produto.ProdutoCategoria"%>
<%@page import="com.geekstore.model.produto.ProdutoStatus"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="categoriasProdutos" scope="request" class="java.util.ArrayList"/>
<jsp:useBean id="statusProdutos" scope="request" class="java.util.ArrayList"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("categoriasProdutos", categoriasProdutos);
            pageContext.setAttribute("statusProdutos", statusProdutos);
        %>
        <div class ="container">
            <h4>Cadastro de Produtos</h4>
            <br/>
            <div class="form-inline">
                <form id="formCadastroProduto" name="formCadastroProduto" method="post" action="Servlet?action=SalvarCadastroProduto">
                    <label for="inputNomeProduto" class="">Nome:</label>
                    <input type="text" id="inputNomeProduto" name="inputNomeProduto"></input>
                    <br/><br/>
                    <label for="inputPrecoProduto" class="">Preço:</label>
                    <input type="number" id="inputPrecoProduto" name="inputPrecoProduto" min="0.00" max="9999.99" step="0.01" placeholder="0,00" onchange="(function (e) {e.value = parseFloat(e.value).toFixed(2);})(this)"/>
                    <br/><br/>
                    <label for="fotoProduto">Foto:
                        <span id="fotoProduto" class="input-group-btn">
                            <span class="btn btn-default btn-file">
                                <input type="file" id="imgInp">
                            </span>
                        </span>
                    </label>
                    <br/><br/>
                    <label for="inputMaterialProduto" class="">Material:</label>
                    <input type="text" id="inputMaterialProduto" name="inputMaterialProduto"></input>
                    <br/><br/>
                    <label for="selectCorProduto" class="">Cor:</label>
                    <select id="selectCorProduto" name="selectCorProduto" class="form-control chosen-select">
                        <c:forTokens items="Amarelo,Azul,Branco,Preto,Verde,Vermelho" delims="," var="name">
                            <option value="${name}"/>${name}</option>
                        </c:forTokens>
                    </select>
                    <br/><br/>
                    <label for="selectCategoriaProduto" class="">Categoria:</label>
                    <select id="selectCategoriaProduto" name="selectCategoriaProduto" class="form-control selectpicker" multiple data-none-selected-text="Nenhuma selecionada">
                        <c:forEach items="${categoriasProdutos}" var="categoriaProduto">
                            <option value="${categoriaProduto.codigo}">${categoriaProduto.nome}</option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <label for="selectStatusProduto" class="">Status:</label>
                    <select id="selectStatusProduto" name="selectStatusProduto" class="form-control chosen-select">
                        <c:forEach items="${statusProdutos}" var="statusProduto">
                            <option value="${statusProduto.codigo}">${statusProduto.nome}</option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <input type="submit" value="Cadastrar"/>
                </form>
            </div>
        </div>
    </body>
</html>