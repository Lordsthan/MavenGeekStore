package com.geekstore.model.cliente;

import com.geekstore.controller.Tabela;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Cliente", uniqueConstraints = @UniqueConstraint(columnNames = "cod_cliente", name = "PK_CLIENTE"))
public class Cliente extends Tabela implements Serializable {
    @Id
    @NotNull
    @Column(name = "cod_cliente")
    private int codigo;
    
    @NotNull
    @Column(name = "nm_cliente")
    private String nome;
    
    @NotNull
    @Column(name = "email_cliente")
    private String email;
    
    @NotNull
    @Column(name = "senha_cliente")
    private String senha;
    
    @NotNull
    @Column(name = "cpf_cliente", columnDefinition = "VARCHAR(11)")
    private String cpf;
    
    @NotNull
    @Column(name = "dt_cadastro_cliente")
    @Temporal(TemporalType.DATE)
    private final Date dataCadastro = new Date(System.currentTimeMillis());

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String email, String senha, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Date getDataCadastro(){
        return dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.senha);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.dataCadastro);
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
        final Cliente other = (Cliente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        return true;
    }
}