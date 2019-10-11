/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekstore.model.produto;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Produto_Foto", uniqueConstraints = @UniqueConstraint(columnNames = "cod_produto_foto", name = "PK_PRODUTO_FOTO"))
public class ProdutoFoto extends Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "cod_produto_foto")
    private int codigo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cod_produto", foreignKey = @ForeignKey(name = "FK_FOTO_PRODUTO"))
    private Produto produto;
    
    @NotNull
    @Column(name = "nm_arquivo_foto")
    private String nomeArquivo;

    public ProdutoFoto() {
    }

    public ProdutoFoto(int codigo, Produto produto, String nomeArquivo) {
        this.codigo = codigo;
        this.produto = produto;
        this.nomeArquivo = nomeArquivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.produto);
        hash = 37 * hash + Objects.hashCode(this.nomeArquivo);
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
        final ProdutoFoto other = (ProdutoFoto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nomeArquivo, other.nomeArquivo)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
}