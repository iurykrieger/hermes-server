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
@Table(name = "item_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOrdemServico.findAll", query = "SELECT i FROM ItemOrdemServico i"),
    @NamedQuery(name = "ItemOrdemServico.findByIdItemOrdemServico", query = "SELECT i FROM ItemOrdemServico i WHERE i.idItemOrdemServico = :idItemOrdemServico"),
    @NamedQuery(name = "ItemOrdemServico.findByQuantidade", query = "SELECT i FROM ItemOrdemServico i WHERE i.quantidade = :quantidade")})
public class ItemOrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_ordem_servico")
    private Long idItemOrdemServico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_ordem_servico", referencedColumnName = "id_ordem_servico")
    @ManyToOne(optional = false)
    private OrdemDeServico idOrdemServico;

    public ItemOrdemServico() {
    }

    public ItemOrdemServico(Long idItemOrdemServico) {
        this.idItemOrdemServico = idItemOrdemServico;
    }

    public ItemOrdemServico(Long idItemOrdemServico, BigDecimal quantidade) {
        this.idItemOrdemServico = idItemOrdemServico;
        this.quantidade = quantidade;
    }

    public Long getIdItemOrdemServico() {
        return idItemOrdemServico;
    }

    public void setIdItemOrdemServico(Long idItemOrdemServico) {
        this.idItemOrdemServico = idItemOrdemServico;
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

    public OrdemDeServico getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(OrdemDeServico idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemOrdemServico != null ? idItemOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemOrdemServico)) {
            return false;
        }
        ItemOrdemServico other = (ItemOrdemServico) object;
        if ((this.idItemOrdemServico == null && other.idItemOrdemServico != null) || (this.idItemOrdemServico != null && !this.idItemOrdemServico.equals(other.idItemOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ItemOrdemServico[ idItemOrdemServico=" + idItemOrdemServico + " ]";
    }
    
}
