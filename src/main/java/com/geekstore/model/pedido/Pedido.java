package com.geekstore.model.pedido;

import com.geekstore.controller.Tabela;
import com.geekstore.model.cliente.Cliente;
import com.geekstore.model.produto.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Pedido", uniqueConstraints = @UniqueConstraint(columnNames = "cod_pedido", name = "PK_PEDIDO"))
public class Pedido extends Tabela implements Serializable {
    @Id
    @NotNull
    @Column(name = "cod_pedido")
    private int codigo;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cod_cliente", foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
    private Cliente cliente;
    
    @NotNull
    @Column(name = "vl_total_pedido", columnDefinition = "DECIMAL(8,2)")
    private BigDecimal valorTotal;
    
    @NotNull
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.DATE)
    private final Date dataPedido = new Date(System.currentTimeMillis());
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_pedido_status", foreignKey = @ForeignKey(name = "FK_PEDIDO_STATUS"))
    private PedidoStatus pedidoStatus;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_pedido_frete", foreignKey = @ForeignKey(name = "FK_PEDIDO_FRETE"))
    private PedidoFrete pedidoFrete;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_dados_pagamento", foreignKey = @ForeignKey(name = "FK_PEDIDO_DADOS_PAGAMENTO"))
    private DadosPagamento dadosPagamento;
    
    @ManyToMany
    @JoinTable(
        name = "Tb_Pedido_Produto",
        joinColumns = @JoinColumn(name = "cod_pedido"),
        inverseJoinColumns = @JoinColumn(name = "cod_produto")
    )
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(int codigo, Cliente cliente, BigDecimal valorTotal, PedidoStatus pedidoStatus, PedidoFrete pedidoFrete, DadosPagamento dadosPagamento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.pedidoStatus = pedidoStatus;
        this.pedidoFrete = pedidoFrete;
        this.dadosPagamento = dadosPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPedido(){
        return dataPedido;
    }
    
    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public PedidoFrete getPedidoFrete() {
        return pedidoFrete;
    }

    public void setPedidoFrete(PedidoFrete pedidoFrete) {
        this.pedidoFrete = pedidoFrete;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + Objects.hashCode(this.valorTotal);
        hash = 29 * hash + Objects.hashCode(this.dataPedido);
        hash = 29 * hash + Objects.hashCode(this.pedidoStatus);
        hash = 29 * hash + Objects.hashCode(this.pedidoFrete);
        hash = 29 * hash + Objects.hashCode(this.dadosPagamento);
        hash = 29 * hash + Objects.hashCode(this.produtos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        if (!Objects.equals(this.pedidoStatus, other.pedidoStatus)) {
            return false;
        }
        if (!Objects.equals(this.pedidoFrete, other.pedidoFrete)) {
            return false;
        }
        if (!Objects.equals(this.dadosPagamento, other.dadosPagamento)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        return true;
    }
}