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
@Table(name = "Tb_Telefone_Status", uniqueConstraints = @UniqueConstraint(columnNames = "cod_telefone_status", name = "PK_TELEFONE_STATUS"))
public class TelefoneStatus extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_telefone_status")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_status")
    private String nome;

    public TelefoneStatus() {
    }

    public TelefoneStatus(int codigo, String nome) {
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
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.nome);
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
        final TelefoneStatus other = (TelefoneStatus) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}