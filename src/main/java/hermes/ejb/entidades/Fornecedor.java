/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByNomeFantasia", query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia = :nomeFantasia")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private Long idFornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 500)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<ItemExternoOrdemServico> itemExternoOrdemServicoList;
    @OneToMany(mappedBy = "idFornecedor")
    private List<ItemExternoOrdemVenda> itemExternoOrdemVendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<OrdemDeCompra> ordemDeCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<FornecedorInfo> fornecedorInfoList;
    @OneToMany(mappedBy = "idFornecedor")
    private List<ItemExternoOrdemFabricacao> itemExternoOrdemFabricacaoList;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Long idFornecedor, String nome, String cnpj) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @XmlTransient
    public List<ItemExternoOrdemServico> getItemExternoOrdemServicoList() {
        return itemExternoOrdemServicoList;
    }

    public void setItemExternoOrdemServicoList(List<ItemExternoOrdemServico> itemExternoOrdemServicoList) {
        this.itemExternoOrdemServicoList = itemExternoOrdemServicoList;
    }

    @XmlTransient
    public List<ItemExternoOrdemVenda> getItemExternoOrdemVendaList() {
        return itemExternoOrdemVendaList;
    }

    public void setItemExternoOrdemVendaList(List<ItemExternoOrdemVenda> itemExternoOrdemVendaList) {
        this.itemExternoOrdemVendaList = itemExternoOrdemVendaList;
    }

    @XmlTransient
    public List<OrdemDeCompra> getOrdemDeCompraList() {
        return ordemDeCompraList;
    }

    public void setOrdemDeCompraList(List<OrdemDeCompra> ordemDeCompraList) {
        this.ordemDeCompraList = ordemDeCompraList;
    }

    @XmlTransient
    public List<FornecedorInfo> getFornecedorInfoList() {
        return fornecedorInfoList;
    }

    public void setFornecedorInfoList(List<FornecedorInfo> fornecedorInfoList) {
        this.fornecedorInfoList = fornecedorInfoList;
    }

    @XmlTransient
    public List<ItemExternoOrdemFabricacao> getItemExternoOrdemFabricacaoList() {
        return itemExternoOrdemFabricacaoList;
    }

    public void setItemExternoOrdemFabricacaoList(List<ItemExternoOrdemFabricacao> itemExternoOrdemFabricacaoList) {
        this.itemExternoOrdemFabricacaoList = itemExternoOrdemFabricacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
        return this.nomeFantasia;
    }
    
}
