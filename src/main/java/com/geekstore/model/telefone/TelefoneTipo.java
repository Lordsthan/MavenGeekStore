package com.geekstore.model.telefone;

import com.geekstore.controller.Tabela;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Telefone_Tipo", uniqueConstraints = @UniqueConstraint(columnNames = "cod_telefone_tipo", name = "PK_TELEFONE_TIPO"))
public class TelefoneTipo extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_telefone_tipo")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_tipo")
    private String nome;

    public TelefoneTipo() {
    }

    public TelefoneTipo(int codigo, String nome) {
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
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.nome);
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
        final TelefoneTipo other = (TelefoneTipo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}