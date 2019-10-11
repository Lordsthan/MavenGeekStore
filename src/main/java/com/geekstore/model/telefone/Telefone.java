package com.geekstore.model.telefone;

import com.geekstore.controller.Tabela;
import com.geekstore.model.cliente.Cliente;
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
@Table(name = "Tb_Telefone", uniqueConstraints = @UniqueConstraint(columnNames = "cod_telefone", name = "PK_TELEFONE"))
public class Telefone extends Tabela {
    @Id
    @NotNull
    @Column(name = "cod_telefone")
    private int codigo;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_cliente", foreignKey = @ForeignKey(name = "FK_TELEFONE_CLIENTE"))
    private Cliente cliente;
    
    @NotNull
    @Column(name = "nu_ddd", columnDefinition = "CHAR(2)")
    private String ddd;
    
    @NotNull
    @Column(name = "nu_telefone", columnDefinition = "VARCHAR(9)")
    private String numero;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_telefone_tipo", foreignKey = @ForeignKey(name = "FK_TELEFONE_TIPO"))
    private TelefoneTipo telefoneTipo;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_telefone_status", foreignKey = @ForeignKey(name = "FK_TELEFONE_STATUS"))
    private TelefoneStatus telefoneStatus;

    public Telefone() {
    }

    public Telefone(int codigo, Cliente cliente, String ddd, String numero, TelefoneTipo telefoneTipo, TelefoneStatus telefoneStatus) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.ddd = ddd;
        this.numero = numero;
        this.telefoneTipo = telefoneTipo;
        this.telefoneStatus = telefoneStatus;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneTipo getTelefoneTipo() {
        return telefoneTipo;
    }

    public void setTelefoneTipo(TelefoneTipo telefoneTipo) {
        this.telefoneTipo = telefoneTipo;
    }

    public TelefoneStatus getTelefoneStatus() {
        return telefoneStatus;
    }

    public void setTelefoneStatus(TelefoneStatus telefoneStatus) {
        this.telefoneStatus = telefoneStatus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.ddd);
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.telefoneTipo);
        hash = 67 * hash + Objects.hashCode(this.telefoneStatus);
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
        final Telefone other = (Telefone) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.telefoneTipo, other.telefoneTipo)) {
            return false;
        }
        if (!Objects.equals(this.telefoneStatus, other.telefoneStatus)) {
            return false;
        }
        return true;
    }
}