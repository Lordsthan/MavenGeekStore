package com.geekstore.main;

import com.geekstore.controller.ProdutoCategoriaDAO;
import com.geekstore.controller.PedidoDAO;
import com.geekstore.controller.ProdutoDAO;
import com.geekstore.controller.ProdutoFotoDAO;
import com.geekstore.controller.ProdutoStatusDAO;
import com.geekstore.model.pedido.Pedido;
import com.geekstore.model.produto.Produto;
import com.geekstore.model.produto.ProdutoCategoria;
import com.geekstore.model.produto.ProdutoFoto;
import com.geekstore.model.produto.ProdutoStatus;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPrincipal", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String parameter = request.getParameter("action");
            switch(parameter) {
                case "CadastrarPedido":
                    //processCadastrarPedido(request, response);
                    break;
                case "ListarPedidos":
                    processListarPedidos(request, response);
                    break;
                case "SalvarCadastroPedido":
                    //processSalvarPedido(request, response);
                    break; 
                case "CadastrarProduto":
                    processCadastrarProduto(request, response);
                    break;
                case "ListarProdutos":
                    processListarProdutos(request, response);
                    break;
                case "SalvarCadastroProduto":
                    processSalvarProduto(request, response);
                    break;
            }
        }
        catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }
    }
    
    private void processCadastrarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO
    }
    
    private void processListarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> pedidos = dao.getAll();
        
        request.setAttribute("pedidos", pedidos);
        RequestDispatcher rd = request.getRequestDispatcher("/pedidos.jsp");
        rd.forward(request, response);
    }
    
    private void processSalvarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO
    }
    
    private void processCadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoCategoriaDAO produtoCategoriaDAO = new ProdutoCategoriaDAO();
        ProdutoStatusDAO produtoStatusDAO = new ProdutoStatusDAO();
        
        List<ProdutoCategoria> categoriasProdutos = produtoCategoriaDAO.getAll();
        List<ProdutoStatus> statusProdutos = produtoStatusDAO.getAll();
        
        request.setAttribute("categoriasProdutos", categoriasProdutos);
        request.setAttribute("statusProdutos", statusProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("/cadastroproduto.jsp");
        rd.forward(request, response);
    }
    
    private void processListarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.getAll();
        
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("/produtos.jsp");
        rd.forward(request, response);
    }
    
    private void processSalvarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("inputNomeProduto");
        BigDecimal preco = new BigDecimal(request.getParameter("inputPrecoProduto"));
        String material = request.getParameter("inputMaterialProduto");
        String cor = request.getParameter("selectCorProduto");
        String nomeArquivo = "teste_nome_foto";
        
        ProdutoCategoriaDAO produtoCategoriaDAO = new ProdutoCategoriaDAO();
        ProdutoCategoria categoria = produtoCategoriaDAO.get(Long.valueOf(request.getParameter("selectCategoriaProduto")));
        
        ProdutoStatusDAO produtoStatusDAO = new ProdutoStatusDAO();
        ProdutoStatus status = produtoStatusDAO.get(Long.valueOf(request.getParameter("selectStatusProduto")));
        
        Produto produto = new Produto();
        produto.setCodigo(0);
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setMaterial(material);
        produto.setCor(cor);
        produto.setProdutoCategoria(categoria);
        produto.setProdutoStatus(status);
        
        ProdutoDAO daoProduto = new ProdutoDAO();
        daoProduto.save(produto);
        
        ProdutoFoto produtoFoto = new ProdutoFoto();
        produtoFoto.setCodigo(0);
        produtoFoto.setNomeArquivo(nomeArquivo);
        produtoFoto.setProduto(produto);
        ProdutoFotoDAO daoProdutoFoto = new ProdutoFotoDAO();
        daoProdutoFoto.save(produtoFoto);
        
        RequestDispatcher rd = request.getRequestDispatcher("/Servlet?action=ListarProdutos");
        rd.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}