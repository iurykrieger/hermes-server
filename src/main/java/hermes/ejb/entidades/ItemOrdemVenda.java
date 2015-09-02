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
@Table(name = "item_ordem_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOrdemVenda.findAll", query = "SELECT i FROM ItemOrdemVenda i"),
    @NamedQuery(name = "ItemOrdemVenda.findByIdItem", query = "SELECT i FROM ItemOrdemVenda i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemOrdemVenda.findByQuantidade", query = "SELECT i FROM ItemOrdemVenda i WHERE i.quantidade = :quantidade")})
public class ItemOrdemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Long idItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_ordem_venda", referencedColumnName = "id_ordem_venda")
    @ManyToOne(optional = false)
    private OrdemDeVenda idOrdemVenda;

    public ItemOrdemVenda() {
    }

    public ItemOrdemVenda(Long idItem) {
        this.idItem = idItem;
    }

    public ItemOrdemVenda(Long idItem, BigDecimal quantidade) {
        this.idItem = idItem;
        this.quantidade = quantidade;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
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

    public OrdemDeVenda getIdOrdemVenda() {
        return idOrdemVenda;
    }

    public void setIdOrdemVenda(OrdemDeVenda idOrdemVenda) {
        this.idOrdemVenda = idOrdemVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemOrdemVenda)) {
            return false;
        }
        ItemOrdemVenda other = (ItemOrdemVenda) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemOrdemVenda[ idItem=" + idItem + " ]";
    }
    
}
