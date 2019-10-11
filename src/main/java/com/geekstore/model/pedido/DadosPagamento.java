package com.geekstore.model.pedido;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Dados_Pagamento", uniqueConstraints = @UniqueConstraint(columnNames = "cod_dados_pagamento", name = "PK_DADOS_PAGAMENTO"))
// @Check(constraints = "CAST(ano_validade_cartao AS UNSIGNED) >= YEAR(CURDATE())), CAST(mes_validade_cartao AS UNSIGNED) BETWEEN 01 AND 12")
public class DadosPagamento extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_dados_pagamento")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_titular")
    private String nomeTitular;
    
    @NotNull
    @Column(name = "nu_cartao", columnDefinition = "CHAR(16)")
    private String numeroCartao;
    
    @NotNull
    @Column(name = "nu_chave_seguranca", columnDefinition = "CHAR(3)")
    private int chaveSeguranca;
    
    @NotNull
    @Column(name = "mes_validade_cartao", columnDefinition = "CHAR(2)")
    private int mesValidadeCartao;
    
    @NotNull
    @Column(name = "ano_validade_cartao", columnDefinition = "CHAR(4)")
    private int anoValidadeCartao;

    public DadosPagamento() {
    }

    public DadosPagamento(int codigo, String nomeTitular, String numeroCartao, int chaveSeguranca, int mesValidadeCartao, int anoValidadeCartao) {
        this.codigo = codigo;
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
        this.chaveSeguranca = chaveSeguranca;
        this.mesValidadeCartao = mesValidadeCartao;
        this.anoValidadeCartao = anoValidadeCartao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getChaveSeguranca() {
        return chaveSeguranca;
    }

    public void setChaveSeguranca(int chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
    }

    public int getMesValidadeCartao() {
        return mesValidadeCartao;
    }

    public void setMesValidadeCartao(int mesValidadeCartao) {
        this.mesValidadeCartao = mesValidadeCartao;
    }

    public int getAnoValidadeCartao() {
        return anoValidadeCartao;
    }

    public void setAnoValidadeCartao(int anoValidadeCartao) {
        this.anoValidadeCartao = anoValidadeCartao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codigo;
        hash = 83 * hash + Objects.hashCode(this.nomeTitular);
        hash = 83 * hash + Objects.hashCode(this.numeroCartao);
        hash = 83 * hash + this.chaveSeguranca;
        hash = 83 * hash + this.mesValidadeCartao;
        hash = 83 * hash + this.anoValidadeCartao;
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
        final DadosPagamento other = (DadosPagamento) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.chaveSeguranca != other.chaveSeguranca) {
            return false;
        }
        if (this.mesValidadeCartao != other.mesValidadeCartao) {
            return false;
        }
        if (this.anoValidadeCartao != other.anoValidadeCartao) {
            return false;
        }
        if (!Objects.equals(this.nomeTitular, other.nomeTitular)) {
            return false;
        }
        if (!Objects.equals(this.numeroCartao, other.numeroCartao)) {
            return false;
        }
        return true;
    }
}