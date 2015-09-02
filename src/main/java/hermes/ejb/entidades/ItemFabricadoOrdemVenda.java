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
@Table(name = "item_fabricado_ordem_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemFabricadoOrdemVenda.findAll", query = "SELECT i FROM ItemFabricadoOrdemVenda i"),
    @NamedQuery(name = "ItemFabricadoOrdemVenda.findByIdItemFabricado", query = "SELECT i FROM ItemFabricadoOrdemVenda i WHERE i.idItemFabricado = :idItemFabricado"),
    @NamedQuery(name = "ItemFabricadoOrdemVenda.findByQuantidade", query = "SELECT i FROM ItemFabricadoOrdemVenda i WHERE i.quantidade = :quantidade")})
public class ItemFabricadoOrdemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_fabricado")
    private Long idItemFabricado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @JoinColumn(name = "id_produto_fabricado", referencedColumnName = "id_produto_fabricado")
    @ManyToOne(optional = false)
    private ProdutoFabricado idProdutoFabricado;
    @JoinColumn(name = "id_ordem_venda", referencedColumnName = "id_ordem_venda")
    @ManyToOne(optional = false)
    private OrdemDeVenda idOrdemVenda;

    public ItemFabricadoOrdemVenda() {
    }

    public ItemFabricadoOrdemVenda(Long idItemFabricado) {
        this.idItemFabricado = idItemFabricado;
    }

    public ItemFabricadoOrdemVenda(Long idItemFabricado, BigDecimal quantidade) {
        this.idItemFabricado = idItemFabricado;
        this.quantidade = quantidade;
    }

    public Long getIdItemFabricado() {
        return idItemFabricado;
    }

    public void setIdItemFabricado(Long idItemFabricado) {
        this.idItemFabricado = idItemFabricado;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoFabricado getIdProdutoFabricado() {
        return idProdutoFabricado;
    }

    public void setIdProdutoFabricado(ProdutoFabricado idProdutoFabricado) {
        this.idProdutoFabricado = idProdutoFabricado;
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
        hash += (idItemFabricado != null ? idItemFabricado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemFabricadoOrdemVenda)) {
            return false;
        }
        ItemFabricadoOrdemVenda other = (ItemFabricadoOrdemVenda) object;
        if ((this.idItemFabricado == null && other.idItemFabricado != null) || (this.idItemFabricado != null && !this.idItemFabricado.equals(other.idItemFabricado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemFabricadoOrdemVenda[ idItemFabricado=" + idItemFabricado + " ]";
    }
    
}
