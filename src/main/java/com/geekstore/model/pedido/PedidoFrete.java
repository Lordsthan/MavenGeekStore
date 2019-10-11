package com.geekstore.model.pedido;

import com.geekstore.controller.Tabela;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Pedido_Frete", uniqueConstraints = @UniqueConstraint(columnNames = "cod_pedido_frete", name = "PK_PEDIDO_FRETE"))
public class PedidoFrete extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_pedido_frete")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_frete")
    private String nome;
    
    @NotNull
    @Column(name = "vl_frete", columnDefinition = "DECIMAL(5,2)")
    private BigDecimal valor;

    public PedidoFrete() {
    }

    public PedidoFrete(int codigo, String nome, BigDecimal valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.valor);
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
        final PedidoFrete other = (PedidoFrete) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }
}