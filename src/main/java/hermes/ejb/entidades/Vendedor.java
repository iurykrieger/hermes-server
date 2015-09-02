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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByNome", query = "SELECT v FROM Vendedor v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vendedor.findByCpf", query = "SELECT v FROM Vendedor v WHERE v.cpf = :cpf"),
    @NamedQuery(name = "Vendedor.findBySexo", query = "SELECT v FROM Vendedor v WHERE v.sexo = :sexo"),
    @NamedQuery(name = "Vendedor.findByDataNascimento", query = "SELECT v FROM Vendedor v WHERE v.dataNascimento = :dataNascimento")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vendedor")
    private Long idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<OrdemDeFabricacao> ordemDeFabricacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<OrdemDeServico> ordemDeServicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<OrdemDeCompra> ordemDeCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<OrdemDeVenda> ordemDeVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<VendedorInfo> vendedorInfoList;

    public Vendedor() {
    }

    public Vendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(Long idVendedor, String nome, String cpf, String sexo, Date dataNascimento) {
        this.idVendedor = idVendedor;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
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

    @XmlTransient
    public List<OrdemDeFabricacao> getOrdemDeFabricacaoList() {
        return ordemDeFabricacaoList;
    }

    public void setOrdemDeFabricacaoList(List<OrdemDeFabricacao> ordemDeFabricacaoList) {
        this.ordemDeFabricacaoList = ordemDeFabricacaoList;
    }

    @XmlTransient
    public List<OrdemDeServico> getOrdemDeServicoList() {
        return ordemDeServicoList;
    }

    public void setOrdemDeServicoList(List<OrdemDeServico> ordemDeServicoList) {
        this.ordemDeServicoList = ordemDeServicoList;
    }

    @XmlTransient
    public List<OrdemDeCompra> getOrdemDeCompraList() {
        return ordemDeCompraList;
    }

    public void setOrdemDeCompraList(List<OrdemDeCompra> ordemDeCompraList) {
        this.ordemDeCompraList = ordemDeCompraList;
    }

    @XmlTransient
    public List<OrdemDeVenda> getOrdemDeVendaList() {
        return ordemDeVendaList;
    }

    public void setOrdemDeVendaList(List<OrdemDeVenda> ordemDeVendaList) {
        this.ordemDeVendaList = ordemDeVendaList;
    }

    @XmlTransient
    public List<VendedorInfo> getVendedorInfoList() {
        return vendedorInfoList;
    }

    public void setVendedorInfoList(List<VendedorInfo> vendedorInfoList) {
        this.vendedorInfoList = vendedorInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Vendedor[ idVendedor=" + idVendedor + " ]";
        return this.getNome();
    }
    
}
