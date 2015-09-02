/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "estoque_produto_fabricado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstoqueProdutoFabricado.findAll", query = "SELECT e FROM EstoqueProdutoFabricado e"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByIdEstoqueProdutoFabricado", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.idEstoqueProdutoFabricado = :idEstoqueProdutoFabricado"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByQuantidade", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByDthAlteracao", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.dthAlteracao = :dthAlteracao"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByValorVenda", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.valorVenda = :valorVenda"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByIdAtivo", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.idAtivo = :idAtivo"),
    @NamedQuery(name = "EstoqueProdutoFabricado.findByCusto", query = "SELECT e FROM EstoqueProdutoFabricado e WHERE e.custo = :custo")})
public class EstoqueProdutoFabricado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estoque_produto_fabricado")
    private Long idEstoqueProdutoFabricado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthAlteracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ativo")
    private boolean idAtivo;
    @Column(name = "custo")
    private BigDecimal custo;
    @JoinColumn(name = "id_produto_fabricado", referencedColumnName = "id_produto_fabricado")
    @ManyToOne
    private ProdutoFabricado idProdutoFabricado;

    public EstoqueProdutoFabricado() {
    }

    public EstoqueProdutoFabricado(Long idEstoqueProdutoFabricado) {
        this.idEstoqueProdutoFabricado = idEstoqueProdutoFabricado;
    }

    public EstoqueProdutoFabricado(Long idEstoqueProdutoFabricado, BigDecimal quantidade, Date dthAlteracao, BigDecimal valorVenda, boolean idAtivo) {
        this.idEstoqueProdutoFabricado = idEstoqueProdutoFabricado;
        this.quantidade = quantidade;
        this.dthAlteracao = dthAlteracao;
        this.valorVenda = valorVenda;
        this.idAtivo = idAtivo;
    }

    public Long getIdEstoqueProdutoFabricado() {
        return idEstoqueProdutoFabricado;
    }

    public void setIdEstoqueProdutoFabricado(Long idEstoqueProdutoFabricado) {
        this.idEstoqueProdutoFabricado = idEstoqueProdutoFabricado;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDthAlteracao() {
        return dthAlteracao;
    }

    public void setDthAlteracao(Date dthAlteracao) {
        this.dthAlteracao = dthAlteracao;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public boolean getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(boolean idAtivo) {
        this.idAtivo = idAtivo;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public ProdutoFabricado getIdProdutoFabricado() {
        return idProdutoFabricado;
    }

    public void setIdProdutoFabricado(ProdutoFabricado idProdutoFabricado) {
        this.idProdutoFabricado = idProdutoFabricado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoqueProdutoFabricado != null ? idEstoqueProdutoFabricado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueProdutoFabricado)) {
            return false;
        }
        EstoqueProdutoFabricado other = (EstoqueProdutoFabricado) object;
        if ((this.idEstoqueProdutoFabricado == null && other.idEstoqueProdutoFabricado != null) || (this.idEstoqueProdutoFabricado != null && !this.idEstoqueProdutoFabricado.equals(other.idEstoqueProdutoFabricado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.EstoqueProdutoFabricado[ idEstoqueProdutoFabricado=" + idEstoqueProdutoFabricado + " ]";
    }
    
}
