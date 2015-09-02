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
@Table(name = "parcela_ordem_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParcelaOrdemCompra.findAll", query = "SELECT p FROM ParcelaOrdemCompra p"),
    @NamedQuery(name = "ParcelaOrdemCompra.findByIdParcelaOrdemCompra", query = "SELECT p FROM ParcelaOrdemCompra p WHERE p.idParcelaOrdemCompra = :idParcelaOrdemCompra"),
    @NamedQuery(name = "ParcelaOrdemCompra.findByNumeroParcelas", query = "SELECT p FROM ParcelaOrdemCompra p WHERE p.numeroParcelas = :numeroParcelas"),
    @NamedQuery(name = "ParcelaOrdemCompra.findByDthParcela", query = "SELECT p FROM ParcelaOrdemCompra p WHERE p.dthParcela = :dthParcela"),
    @NamedQuery(name = "ParcelaOrdemCompra.findByValorParcela", query = "SELECT p FROM ParcelaOrdemCompra p WHERE p.valorParcela = :valorParcela"),
    @NamedQuery(name = "ParcelaOrdemCompra.findByPago", query = "SELECT p FROM ParcelaOrdemCompra p WHERE p.pago = :pago")})
public class ParcelaOrdemCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parcela_ordem_compra")
    private Long idParcelaOrdemCompra;
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
    @JoinColumn(name = "id_ordem_compra", referencedColumnName = "id_ordem_compra")
    @ManyToOne
    private OrdemDeCompra idOrdemCompra;

    public ParcelaOrdemCompra() {
    }

    public ParcelaOrdemCompra(Long idParcelaOrdemCompra) {
        this.idParcelaOrdemCompra = idParcelaOrdemCompra;
    }

    public ParcelaOrdemCompra(Long idParcelaOrdemCompra, int numeroParcelas, Date dthParcela, BigDecimal valorParcela, boolean pago) {
        this.idParcelaOrdemCompra = idParcelaOrdemCompra;
        this.numeroParcelas = numeroParcelas;
        this.dthParcela = dthParcela;
        this.valorParcela = valorParcela;
        this.pago = pago;
    }

    public Long getIdParcelaOrdemCompra() {
        return idParcelaOrdemCompra;
    }

    public void setIdParcelaOrdemCompra(Long idParcelaOrdemCompra) {
        this.idParcelaOrdemCompra = idParcelaOrdemCompra;
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

    public OrdemDeCompra getIdOrdemCompra() {
        return idOrdemCompra;
    }

    public void setIdOrdemCompra(OrdemDeCompra idOrdemCompra) {
        this.idOrdemCompra = idOrdemCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParcelaOrdemCompra != null ? idParcelaOrdemCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParcelaOrdemCompra)) {
            return false;
        }
        ParcelaOrdemCompra other = (ParcelaOrdemCompra) object;
        if ((this.idParcelaOrdemCompra == null && other.idParcelaOrdemCompra != null) || (this.idParcelaOrdemCompra != null && !this.idParcelaOrdemCompra.equals(other.idParcelaOrdemCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ParcelaOrdemCompra[ idParcelaOrdemCompra=" + idParcelaOrdemCompra + " ]";
    }
    
}
