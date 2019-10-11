package com.geekstore.model.endereco;

import com.geekstore.controller.Tabela;
import com.geekstore.model.cliente.Cliente;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Endereco", uniqueConstraints = @UniqueConstraint(columnNames = "cod_endereco", name = "PK_ENDERECO"))
public class Endereco extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_endereco")
    private int codigo;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cod_cliente", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE"))
    private Cliente cliente;
    
    @NotNull
    @Column(name = "nm_endereco")
    private String nome;
    
    @Column(name = "nu_endereco", columnDefinition = "SMALLINT UNSIGNED")
    private int numero;
    
    @NotNull
    @Column(name = "nm_bairro")
    private String bairro;
    
    @NotNull
    @Column(name = "nu_cep", columnDefinition = "CHAR(8)")
    private String cep;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco_estado", foreignKey = @ForeignKey(name = "FK_ENDERECO_ESTADO"))
    private EnderecoEstado enderecoEstado;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco_cidade", foreignKey = @ForeignKey(name = "FK_ENDERECO_CIDADE"))
    private EnderecoCidade enderecoCidade;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco_status", foreignKey = @ForeignKey(name = "FK_ENDERECO_STATUS"))
    private EnderecoStatus enderecoStatus;

    public Endereco() {
    }
    
    public Endereco(int codigo, Cliente cliente, String nome, int numero, String bairro, String cep, EnderecoEstado enderecoEstado, EnderecoCidade enderecoCidade, EnderecoStatus enderecoStatus) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.nome = nome;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.enderecoEstado = enderecoEstado;
        this.enderecoCidade = enderecoCidade;
        this.enderecoStatus = enderecoStatus;
    }

    public Endereco(int codigo, Cliente cliente, String nome, String bairro, String cep, EnderecoEstado enderecoEstado, EnderecoCidade enderecoCidade, EnderecoStatus enderecoStatus) {
        this(codigo, cliente, nome, -1, bairro, cep, enderecoEstado, enderecoCidade, enderecoStatus);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public EnderecoEstado getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(EnderecoEstado enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public EnderecoCidade getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(EnderecoCidade enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public EnderecoStatus getEnderecoStatus() {
        return enderecoStatus;
    }

    public void setEnderecoStatus(EnderecoStatus enderecoStatus) {
        this.enderecoStatus = enderecoStatus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.bairro);
        hash = 97 * hash + Objects.hashCode(this.cep);
        hash = 97 * hash + Objects.hashCode(this.enderecoEstado);
        hash = 97 * hash + Objects.hashCode(this.enderecoCidade);
        hash = 97 * hash + Objects.hashCode(this.enderecoStatus);
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
        final Endereco other = (Endereco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.enderecoEstado, other.enderecoEstado)) {
            return false;
        }
        if (!Objects.equals(this.enderecoCidade, other.enderecoCidade)) {
            return false;
        }
        if (!Objects.equals(this.enderecoStatus, other.enderecoStatus)) {
            return false;
        }
        return true;
    }
}