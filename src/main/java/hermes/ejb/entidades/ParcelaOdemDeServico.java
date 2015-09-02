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
@Table(name = "parcela_odem_de_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParcelaOdemDeServico.findAll", query = "SELECT p FROM ParcelaOdemDeServico p"),
    @NamedQuery(name = "ParcelaOdemDeServico.findByNumeroParcelas", query = "SELECT p FROM ParcelaOdemDeServico p WHERE p.numeroParcelas = :numeroParcelas"),
    @NamedQuery(name = "ParcelaOdemDeServico.findByDthParcela", query = "SELECT p FROM ParcelaOdemDeServico p WHERE p.dthParcela = :dthParcela"),
    @NamedQuery(name = "ParcelaOdemDeServico.findByValorParcela", query = "SELECT p FROM ParcelaOdemDeServico p WHERE p.valorParcela = :valorParcela"),
    @NamedQuery(name = "ParcelaOdemDeServico.findByPago", query = "SELECT p FROM ParcelaOdemDeServico p WHERE p.pago = :pago"),
    @NamedQuery(name = "ParcelaOdemDeServico.findByIdParcelaOrdemServico", query = "SELECT p FROM ParcelaOdemDeServico p WHERE p.idParcelaOrdemServico = :idParcelaOrdemServico")})
public class ParcelaOdemDeServico implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parcela_ordem_servico")
    private Long idParcelaOrdemServico;
    @JoinColumn(name = "id_ordem_servico", referencedColumnName = "id_ordem_servico")
    @ManyToOne(optional = false)
    private OrdemDeServico idOrdemServico;

    public ParcelaOdemDeServico() {
    }

    public ParcelaOdemDeServico(Long idParcelaOrdemServico) {
        this.idParcelaOrdemServico = idParcelaOrdemServico;
    }

    public ParcelaOdemDeServico(Long idParcelaOrdemServico, int numeroParcelas, Date dthParcela, BigDecimal valorParcela, boolean pago) {
        this.idParcelaOrdemServico = idParcelaOrdemServico;
        this.numeroParcelas = numeroParcelas;
        this.dthParcela = dthParcela;
        this.valorParcela = valorParcela;
        this.pago = pago;
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

    public Long getIdParcelaOrdemServico() {
        return idParcelaOrdemServico;
    }

    public void setIdParcelaOrdemServico(Long idParcelaOrdemServico) {
        this.idParcelaOrdemServico = idParcelaOrdemServico;
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
        hash += (idParcelaOrdemServico != null ? idParcelaOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParcelaOdemDeServico)) {
            return false;
        }
        ParcelaOdemDeServico other = (ParcelaOdemDeServico) object;
        if ((this.idParcelaOrdemServico == null && other.idParcelaOrdemServico != null) || (this.idParcelaOrdemServico != null && !this.idParcelaOrdemServico.equals(other.idParcelaOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.ParcelaOdemDeServico[ idParcelaOrdemServico=" + idParcelaOrdemServico + " ]";
    }
    
}
