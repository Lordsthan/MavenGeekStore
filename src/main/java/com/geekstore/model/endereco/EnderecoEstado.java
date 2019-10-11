package com.geekstore.model.endereco;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Endereco_Estado", uniqueConstraints = @UniqueConstraint(columnNames = "cod_endereco_estado", name = "PK_ENDERECO_ESTADO"))
public class EnderecoEstado extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_endereco_estado")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_estado")
    private String nome;

    public EnderecoEstado() {
    }

    public EnderecoEstado(int codigo, String nome) {
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
        int hash = 5;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final EnderecoEstado other = (EnderecoEstado) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}