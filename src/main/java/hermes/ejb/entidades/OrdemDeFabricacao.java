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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "ordem_de_fabricacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDeFabricacao.findAll", query = "SELECT o FROM OrdemDeFabricacao o"),
    @NamedQuery(name = "OrdemDeFabricacao.findByIdOrdemFabricacao", query = "SELECT o FROM OrdemDeFabricacao o WHERE o.idOrdemFabricacao = :idOrdemFabricacao"),
    @NamedQuery(name = "OrdemDeFabricacao.findByDthCriacao", query = "SELECT o FROM OrdemDeFabricacao o WHERE o.dthCriacao = :dthCriacao"),
    @NamedQuery(name = "OrdemDeFabricacao.findByDthFechamento", query = "SELECT o FROM OrdemDeFabricacao o WHERE o.dthFechamento = :dthFechamento")})
public class OrdemDeFabricacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordem_fabricacao")
    private Long idOrdemFabricacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthCriacao;
    @Column(name = "dth_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthFechamento;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "id_produto_fabricado", referencedColumnName = "id_produto_fabricado")
    @ManyToOne(optional = false)
    private ProdutoFabricado idProdutoFabricado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemFabricacao")
    private List<MecanicoOrdemFabricacao> mecanicoOrdemFabricacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemFabricacao")
    private List<ItemOrdemFabricacao> itemOrdemFabricacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemFabricacao")
    private List<ItemExternoOrdemFabricacao> itemExternoOrdemFabricacaoList;

    public OrdemDeFabricacao() {
    }

    public OrdemDeFabricacao(Long idOrdemFabricacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
    }

    public OrdemDeFabricacao(Long idOrdemFabricacao, Date dthCriacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
        this.dthCriacao = dthCriacao;
    }

    public Long getIdOrdemFabricacao() {
        return idOrdemFabricacao;
    }

    public void setIdOrdemFabricacao(Long idOrdemFabricacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
    }

    public Date getDthCriacao() {
        return dthCriacao;
    }

    public void setDthCriacao(Date dthCriacao) {
        this.dthCriacao = dthCriacao;
    }

    public Date getDthFechamento() {
        return dthFechamento;
    }

    public void setDthFechamento(Date dthFechamento) {
        this.dthFechamento = dthFechamento;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public ProdutoFabricado getIdProdutoFabricado() {
        return idProdutoFabricado;
    }

    public void setIdProdutoFabricado(ProdutoFabricado idProdutoFabricado) {
        this.idProdutoFabricado = idProdutoFabricado;
    }

    @XmlTransient
    public List<MecanicoOrdemFabricacao> getMecanicoOrdemFabricacaoList() {
        return mecanicoOrdemFabricacaoList;
    }

    public void setMecanicoOrdemFabricacaoList(List<MecanicoOrdemFabricacao> mecanicoOrdemFabricacaoList) {
        this.mecanicoOrdemFabricacaoList = mecanicoOrdemFabricacaoList;
    }

    @XmlTransient
    public List<ItemOrdemFabricacao> getItemOrdemFabricacaoList() {
        return itemOrdemFabricacaoList;
    }

    public void setItemOrdemFabricacaoList(List<ItemOrdemFabricacao> itemOrdemFabricacaoList) {
        this.itemOrdemFabricacaoList = itemOrdemFabricacaoList;
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
        hash += (idOrdemFabricacao != null ? idOrdemFabricacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDeFabricacao)) {
            return false;
        }
        OrdemDeFabricacao other = (OrdemDeFabricacao) object;
        if ((this.idOrdemFabricacao == null && other.idOrdemFabricacao != null) || (this.idOrdemFabricacao != null && !this.idOrdemFabricacao.equals(other.idOrdemFabricacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.OrdemDeFabricacao[ idOrdemFabricacao=" + idOrdemFabricacao + " ]";
    }
    
}
