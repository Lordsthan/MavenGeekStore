package com.geekstore.model.produto;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Produto_Categoria", uniqueConstraints = @UniqueConstraint(columnNames = "cod_produto_categoria", name = "PK_PRODUTO_CATEGORIA"))
public class ProdutoCategoria extends Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "cod_produto_categoria")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_categoria")
    private String nome;

    public ProdutoCategoria() {
    }

    public ProdutoCategoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codigo;
        hash = 17 * hash + Objects.hashCode(this.nome);
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
        final ProdutoCategoria other = (ProdutoCategoria) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}