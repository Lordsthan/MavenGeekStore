package com.geekstore.model.produto;

import com.geekstore.controller.Tabela;
import com.geekstore.model.pedido.Pedido;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Produto", uniqueConstraints = @UniqueConstraint(columnNames = "cod_produto", name = "PK_PRODUTO"))
public class Produto extends Tabela {
    @Id
    @SequenceGenerator(name = "codProduto", sequenceName = "cod_Produto")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="codProduto") 
    @NotNull
    @Column(name = "cod_produto")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_produto")
    private String nome;
    
    @NotNull
    @Column(name = "preco_produto", precision = 6, scale = 2)
    private BigDecimal preco;
    
    @NotNull
    @Column(name = "material_produto")
    private String material;
    
    @NotNull
    @Column(name = "cor_produto")
    private String cor;
    
    @NotNull
    @Column(name = "dt_cadastro_produto")
    @Temporal(TemporalType.DATE)
    private final Date dataCadastro = new Date(System.currentTimeMillis());
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_produto_categoria", foreignKey = @ForeignKey(name = "FK_PRODUTO_CATEGORIA"))
    private ProdutoCategoria produtoCategoria;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_produto_status", foreignKey = @ForeignKey(name = "FK_PRODUTO_STATUS"))
    private ProdutoStatus produtoStatus;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;
    
    public Produto() {
    }

    public Produto(int codigo, String nome, BigDecimal preco, String material, String cor, ProdutoCategoria produtoCategoria, ProdutoStatus produtoStatus) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.material = material;
        this.cor = cor;
        this.produtoCategoria = produtoCategoria;
        this.produtoStatus = produtoStatus;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ProdutoCategoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }
    
    public ProdutoStatus getProdutoStatus() {
        return produtoStatus;
    }

    public void setProdutoStatus(ProdutoStatus produtoStatus) {
        this.produtoStatus = produtoStatus;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.preco);
        hash = 79 * hash + Objects.hashCode(this.material);
        hash = 79 * hash + Objects.hashCode(this.cor);
        hash = 79 * hash + Objects.hashCode(this.dataCadastro);
        hash = 79 * hash + Objects.hashCode(this.produtoCategoria);
        hash = 79 * hash + Objects.hashCode(this.produtoStatus);
        hash = 79 * hash + Objects.hashCode(this.pedidos);
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.produtoCategoria, other.produtoCategoria)) {
            return false;
        }
        if (!Objects.equals(this.produtoStatus, other.produtoStatus)) {
            return false;
        }
        if (!Objects.equals(this.pedidos, other.pedidos)) {
            return false;
        }
        return true;
    }
}