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
@Table(name = "parcela_ordem_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParcelaOrdemVenda.findAll", query = "SELECT p FROM ParcelaOrdemVenda p"),
    @NamedQuery(name = "ParcelaOrdemVenda.findByIdParcelaOrdemVenda", query = "SELECT p FROM ParcelaOrdemVenda p WHERE p.idParcelaOrdemVenda = :idParcelaOrdemVenda"),
    @NamedQuery(name = "ParcelaOrdemVenda.findByNumeroParcelas", query = "SELECT p FROM ParcelaOrdemVenda p WHERE p.numeroParcelas = :numeroParcelas"),
    @NamedQuery(name = "ParcelaOrdemVenda.findByDthParcela", query = "SELECT p FROM ParcelaOrdemVenda p WHERE p.dthParcela = :dthParcela"),
    @NamedQuery(name = "ParcelaOrdemVenda.findByValorParcela", query = "SELECT p FROM ParcelaOrdemVenda p WHERE p.valorParcela = :valorParcela"),
    @NamedQuery(name = "ParcelaOrdemVenda.findByPago", query = "SELECT p FROM ParcelaOrdemVenda p WHERE p.pago = :pago")})
public class ParcelaOrdemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parcela_ordem_venda")
    private Long idParcelaOrdemVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_parcelas")
    private int numeroParcelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dth_parcela")
    @Temporal(TemporalType.DATE)
    private Date dthParcela;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_parcela")
    private BigDecimal valorParcela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pago")
    private boolean pago;
    @JoinColumn(name = "id_ordem_venda", referencedColumnName = "id_ordem_venda")
    @ManyToOne(optional = false)
    private OrdemDeVenda idOrdemVenda;

    public ParcelaOrdemVenda() {
    }

    public ParcelaOrdemVenda(Long idParcelaOrdemVenda) {
        this.idParcelaOrdemVenda = idParcelaOrdemVenda;
    }

    public ParcelaOrdemVenda(Long idParcelaOrdemVenda, int numeroParcelas, Date dthParcela, BigDecimal valorParcela, boolean pago) {
        this.idParcelaOrdemVenda = idParcelaOrdemVenda;
        this.numeroParcelas = numeroParcelas;
        this.dthParcela = dthParcela;
        this.valorParcela = valorParcela;
        this.pago = pago;
    }

    public Long getIdParcelaOrdemVenda() {
        return idParcelaOrdemVenda;
    }

    public void setIdParcelaOrdemVenda(Long idParcelaOrdemVenda) {
        this.idParcelaOrdemVenda = idParcelaOrdemVenda;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Date getDthParcela() {
        return dthParcela;
    }

    public void setDthParcela(Date dthParcela) {
        this.dthParcela = dthParcela;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
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
        hash += (idParcelaOrdemVenda != null ? idParcelaOrdemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParcelaOrdemVenda)) {
            return false;
        }
        ParcelaOrdemVenda other = (ParcelaOrdemVenda) object;
        if ((this.idParcelaOrdemVenda == null && other.idParcelaOrdemVenda != null) || (this.idParcelaOrdemVenda != null && !this.idParcelaOrdemVenda.equals(other.idParcelaOrdemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ParcelaOrdemVenda[ idParcelaOrdemVenda=" + idParcelaOrdemVenda + " ]";
    }
    
}
