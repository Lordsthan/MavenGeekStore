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
@Table(name = "Tb_Pedido_Status", uniqueConstraints = @UniqueConstraint(columnNames = "cod_pedido_status", name = "PK_PEDIDO_STATUS"))
public class PedidoStatus extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_pedido_status")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_status")
    private String nome;

    public PedidoStatus() {
    }

    public PedidoStatus(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final PedidoStatus other = (PedidoStatus) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}