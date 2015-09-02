/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "cliente_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteInfo.findAll", query = "SELECT c FROM ClienteInfo c"),
    @NamedQuery(name = "ClienteInfo.findByIdClienteInfo", query = "SELECT c FROM ClienteInfo c WHERE c.idClienteInfo = :idClienteInfo"),
    @NamedQuery(name = "ClienteInfo.findByEndereco", query = "SELECT c FROM ClienteInfo c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "ClienteInfo.findByTelefone", query = "SELECT c FROM ClienteInfo c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "ClienteInfo.findByCelular", query = "SELECT c FROM ClienteInfo c WHERE c.celular = :celular"),
    @NamedQuery(name = "ClienteInfo.findByIdAtivo", query = "SELECT c FROM ClienteInfo c WHERE c.idAtivo = :idAtivo"),
    @NamedQuery(name = "ClienteInfo.findByEnderecoDescricao", query = "SELECT c FROM ClienteInfo c WHERE c.enderecoDescricao = :enderecoDescricao"),
    @NamedQuery(name = "ClienteInfo.findByDthAlteracao", query = "SELECT c FROM ClienteInfo c WHERE c.dthAlteracao = :dthAlteracao"),
    @NamedQuery(name = "ClienteInfo.findByEmail", query = "SELECT c FROM ClienteInfo c WHERE c.email = :email"),
    @NamedQuery(name = "ClienteInfo.findByCredibilidade", query = "SELECT c FROM ClienteInfo c WHERE c.credibilidade = :credibilidade"),
    @NamedQuery(name = "ClienteInfo.findByCidade", query = "SELECT c FROM ClienteInfo c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "ClienteInfo.findByEstado", query = "SELECT c FROM ClienteInfo c WHERE c.estado = :estado"),
    @NamedQuery(name = "ClienteInfo.findByCep", query = "SELECT c FROM ClienteInfo c WHERE c.cep = :cep")})
public class ClienteInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_info")
    private Long idClienteInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 200)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 200)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ativo")
    private boolean idAtivo;
    @Size(max = 2147483647)
    @Column(name = "endereco_descricao")
    private String enderecoDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthAlteracao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credibilidade")
    private int credibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado")
    private String estado;
    @Size(max = 200)
    @Column(name = "cep")
    private String cep;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;

    public ClienteInfo() {
    }

    public ClienteInfo(Long idClienteInfo) {
        this.idClienteInfo = idClienteInfo;
    }

    public ClienteInfo(Long idClienteInfo, String endereco, boolean idAtivo, Date dthAlteracao, int credibilidade, String cidade, String estado) {
        this.idClienteInfo = idClienteInfo;
        this.endereco = endereco;
        this.idAtivo = idAtivo;
        this.dthAlteracao = dthAlteracao;
        this.credibilidade = credibilidade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getIdClienteInfo() {
        return idClienteInfo;
    }

    public void setIdClienteInfo(Long idClienteInfo) {
        this.idClienteInfo = idClienteInfo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(boolean idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getEnderecoDescricao() {
        return enderecoDescricao;
    }

    public void setEnderecoDescricao(String enderecoDescricao) {
        this.enderecoDescricao = enderecoDescricao;
    }

    public Date getDthAlteracao() {
        return dthAlteracao;
    }

    public void setDthAlteracao(Date dthAlteracao) {
        this.dthAlteracao = dthAlteracao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredibilidade() {
        return credibilidade;
    }

    public void setCredibilidade(int credibilidade) {
        this.credibilidade = credibilidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteInfo != null ? idClienteInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteInfo)) {
            return false;
        }
        ClienteInfo other = (ClienteInfo) object;
        if ((this.idClienteInfo == null && other.idClienteInfo != null) || (this.idClienteInfo != null && !this.idClienteInfo.equals(other.idClienteInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ClienteInfo[ idClienteInfo=" + idClienteInfo + " ]";
    }
    
}
