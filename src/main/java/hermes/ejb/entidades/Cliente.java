/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findByCnpj", query = "SELECT c FROM Cliente c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "Cliente.findBySexo", query = "SELECT c FROM Cliente c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cliente.findByDataNascimento", query = "SELECT c FROM Cliente c WHERE c.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Cliente.findByTipoPessoa", query = "SELECT c FROM Cliente c WHERE c.tipoPessoa = :tipoPessoa")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 200)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 100)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_pessoa")
    private String tipoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Equipamento> equipamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<OrdemDeVenda> ordemDeVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente",fetch = FetchType.LAZY)
    private List<ClienteInfo> clienteInfoList;

    public Cliente() {
    }

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Long idCliente, String nome, String tipoPessoa) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @XmlTransient
    public List<Equipamento> getEquipamentoList() {
        return equipamentoList;
    }

    public void setEquipamentoList(List<Equipamento> equipamentoList) {
        this.equipamentoList = equipamentoList;
    }

    @XmlTransient
    public List<OrdemDeVenda> getOrdemDeVendaList() {
        return ordemDeVendaList;
    }

    public void setOrdemDeVendaList(List<OrdemDeVenda> ordemDeVendaList) {
        this.ordemDeVendaList = ordemDeVendaList;
    }

    @XmlTransient
    public List<ClienteInfo> getClienteInfoList() {
        return clienteInfoList;
    }

    public void setClienteInfoList(List<ClienteInfo> clienteInfoList) {
        this.clienteInfoList = clienteInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
