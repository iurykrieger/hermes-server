/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "ordem_de_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDeCompra.findAll", query = "SELECT o FROM OrdemDeCompra o"),
    @NamedQuery(name = "OrdemDeCompra.findByIdOrdemCompra", query = "SELECT o FROM OrdemDeCompra o WHERE o.idOrdemCompra = :idOrdemCompra"),
    @NamedQuery(name = "OrdemDeCompra.findByDthCompra", query = "SELECT o FROM OrdemDeCompra o WHERE o.dthCompra = :dthCompra"),
    @NamedQuery(name = "OrdemDeCompra.findByValorCompra", query = "SELECT o FROM OrdemDeCompra o WHERE o.valorCompra = :valorCompra"),
    @NamedQuery(name = "OrdemDeCompra.findByQuantidade", query = "SELECT o FROM OrdemDeCompra o WHERE o.quantidade = :quantidade"),
    @NamedQuery(name = "OrdemDeCompra.findByObservacao", query = "SELECT o FROM OrdemDeCompra o WHERE o.observacao = :observacao"),
    @NamedQuery(name = "OrdemDeCompra.findByDthVencimento", query = "SELECT o FROM OrdemDeCompra o WHERE o.dthVencimento = :dthVencimento"),
    @NamedQuery(name = "OrdemDeCompra.findByDthFechamento", query = "SELECT o FROM OrdemDeCompra o WHERE o.dthFechamento = :dthFechamento")})
public class OrdemDeCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordem_compra")
    private Long idOrdemCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthVencimento;
    @Column(name = "dth_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthFechamento;
    @OneToMany(mappedBy = "idOrdemCompra")
    private List<ParcelaOrdemCompra> parcelaOrdemCompraList;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;

    public OrdemDeCompra() {
    }

    public OrdemDeCompra(Long idOrdemCompra) {
        this.idOrdemCompra = idOrdemCompra;
    }

    public OrdemDeCompra(Long idOrdemCompra, Date dthCompra, BigDecimal valorCompra, BigDecimal quantidade, Date dthVencimento) {
        this.idOrdemCompra = idOrdemCompra;
        this.dthCompra = dthCompra;
        this.valorCompra = valorCompra;
        this.quantidade = quantidade;
        this.dthVencimento = dthVencimento;
    }

    public Long getIdOrdemCompra() {
        return idOrdemCompra;
    }

    public void setIdOrdemCompra(Long idOrdemCompra) {
        this.idOrdemCompra = idOrdemCompra;
    }

    public Date getDthCompra() {
        return dthCompra;
    }

    public void setDthCompra(Date dthCompra) {
        this.dthCompra = dthCompra;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDthVencimento() {
        return dthVencimento;
    }

    public void setDthVencimento(Date dthVencimento) {
        this.dthVencimento = dthVencimento;
    }

    public Date getDthFechamento() {
        return dthFechamento;
    }

    public void setDthFechamento(Date dthFechamento) {
        this.dthFechamento = dthFechamento;
    }

    @XmlTransient
    public List<ParcelaOrdemCompra> getParcelaOrdemCompraList() {
        return parcelaOrdemCompraList;
    }

    public void setParcelaOrdemCompraList(List<ParcelaOrdemCompra> parcelaOrdemCompraList) {
        this.parcelaOrdemCompraList = parcelaOrdemCompraList;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemCompra != null ? idOrdemCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDeCompra)) {
            return false;
        }
        OrdemDeCompra other = (OrdemDeCompra) object;
        if ((this.idOrdemCompra == null && other.idOrdemCompra != null) || (this.idOrdemCompra != null && !this.idOrdemCompra.equals(other.idOrdemCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.OrdemDeCompra[ idOrdemCompra=" + idOrdemCompra + " ]";
    }
    
}
