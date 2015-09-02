/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "item_ordem_fabricacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOrdemFabricacao.findAll", query = "SELECT i FROM ItemOrdemFabricacao i"),
    @NamedQuery(name = "ItemOrdemFabricacao.findByIdItemOrdemFabricacao", query = "SELECT i FROM ItemOrdemFabricacao i WHERE i.idItemOrdemFabricacao = :idItemOrdemFabricacao"),
    @NamedQuery(name = "ItemOrdemFabricacao.findByQuantidade", query = "SELECT i FROM ItemOrdemFabricacao i WHERE i.quantidade = :quantidade")})
public class ItemOrdemFabricacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_ordem_fabricacao")
    private Long idItemOrdemFabricacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_ordem_fabricacao", referencedColumnName = "id_ordem_fabricacao")
    @ManyToOne(optional = false)
    private OrdemDeFabricacao idOrdemFabricacao;

    public ItemOrdemFabricacao() {
    }

    public ItemOrdemFabricacao(Long idItemOrdemFabricacao) {
        this.idItemOrdemFabricacao = idItemOrdemFabricacao;
    }

    public ItemOrdemFabricacao(Long idItemOrdemFabricacao, BigDecimal quantidade) {
        this.idItemOrdemFabricacao = idItemOrdemFabricacao;
        this.quantidade = quantidade;
    }

    public Long getIdItemOrdemFabricacao() {
        return idItemOrdemFabricacao;
    }

    public void setIdItemOrdemFabricacao(Long idItemOrdemFabricacao) {
        this.idItemOrdemFabricacao = idItemOrdemFabricacao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public OrdemDeFabricacao getIdOrdemFabricacao() {
        return idOrdemFabricacao;
    }

    public void setIdOrdemFabricacao(OrdemDeFabricacao idOrdemFabricacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemOrdemFabricacao != null ? idItemOrdemFabricacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemOrdemFabricacao)) {
            return false;
        }
        ItemOrdemFabricacao other = (ItemOrdemFabricacao) object;
        if ((this.idItemOrdemFabricacao == null && other.idItemOrdemFabricacao != null) || (this.idItemOrdemFabricacao != null && !this.idItemOrdemFabricacao.equals(other.idItemOrdemFabricacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemOrdemFabricacao[ idItemOrdemFabricacao=" + idItemOrdemFabricacao + " ]";
    }
    
}
