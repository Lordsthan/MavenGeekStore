package com.geekstore.main;

import com.geekstore.model.cliente.Cliente;
import com.geekstore.controller.DAO;
import com.geekstore.controller.PedidoDAO;
import com.geekstore.controller.ProdutoCategoriaDAO;
import com.geekstore.controller.ProdutoStatusDAO;
import com.geekstore.model.endereco.Endereco;
import com.geekstore.model.endereco.EnderecoCidade;
import com.geekstore.model.endereco.EnderecoEstado;
import com.geekstore.model.endereco.EnderecoStatus;
import com.geekstore.model.pedido.DadosPagamento;
import com.geekstore.model.pedido.Pedido;
import com.geekstore.model.pedido.PedidoFrete;
import com.geekstore.model.pedido.PedidoStatus;
import com.geekstore.model.produto.Produto;
import com.geekstore.model.produto.ProdutoCategoria;
import com.geekstore.model.produto.ProdutoStatus;
import com.geekstore.model.telefone.Telefone;
import com.geekstore.model.telefone.TelefoneStatus;
import com.geekstore.model.telefone.TelefoneTipo;
import java.math.BigDecimal;

public class GeekStore {
    public static void main(String... args) {
        ProdutoCategoria categoriaFotografia = new ProdutoCategoria(1, "Fotografia");
        ProdutoCategoria categoriaDesenhoAnimado = new ProdutoCategoria(2, "Desenho Animado");
        ProdutoCategoria categoriaFilme = new ProdutoCategoria(3, "Filmes");
        
        ProdutoStatus produtoAtivo = new ProdutoStatus(1, "Ativo");
        ProdutoStatus produtoStatusInativo = new ProdutoStatus(2, "Inativo");
        
        ProdutoCategoriaDAO categoriaDAO = new ProdutoCategoriaDAO();
        //categoriaDAO.save(categoriaFotografia);
        categoriaDAO.save(categoriaDesenhoAnimado);
        categoriaDAO.save(categoriaFilme);
        
        ProdutoStatusDAO statusDAO = new ProdutoStatusDAO();
        //statusDAO.save(produtoAtivo);
        statusDAO.save(produtoStatusInativo);
    }
}