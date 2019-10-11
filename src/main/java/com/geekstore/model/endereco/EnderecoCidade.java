package com.geekstore.model.endereco;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Endereco_Cidade", uniqueConstraints = @UniqueConstraint(columnNames = "cod_endereco_cidade", name = "PK_ENDERECO_CIDADE"))
public class EnderecoCidade extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_endereco_cidade")
    private int codigo;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco_estado", foreignKey = @ForeignKey(name = "FK_CIDADE_ESTADO"))
    private EnderecoEstado enderecoEstado;
    
    @NotNull
    @Column(name = "nm_cidade")
    private String nome;

    public EnderecoCidade() {
    }

    public EnderecoCidade(int codigo, EnderecoEstado enderecoEstado, String nome) {
        this.codigo = codigo;
        this.enderecoEstado = enderecoEstado;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public EnderecoEstado getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(EnderecoEstado enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
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
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.enderecoEstado);
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
        final EnderecoCidade other = (EnderecoCidade) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.enderecoEstado, other.enderecoEstado)) {
            return false;
        }
        return true;
    }
}