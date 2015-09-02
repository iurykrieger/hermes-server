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
@Table(name = "mecanico_ordem_fabricacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MecanicoOrdemFabricacao.findAll", query = "SELECT m FROM MecanicoOrdemFabricacao m"),
    @NamedQuery(name = "MecanicoOrdemFabricacao.findByIdMecanicoOrdemFabricacao", query = "SELECT m FROM MecanicoOrdemFabricacao m WHERE m.idMecanicoOrdemFabricacao = :idMecanicoOrdemFabricacao"),
    @NamedQuery(name = "MecanicoOrdemFabricacao.findByNumeroHoras", query = "SELECT m FROM MecanicoOrdemFabricacao m WHERE m.numeroHoras = :numeroHoras")})
public class MecanicoOrdemFabricacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico_ordem_fabricacao")
    private Long idMecanicoOrdemFabricacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_horas")
    private BigDecimal numeroHoras;
    @JoinColumn(name = "id_ordem_fabricacao", referencedColumnName = "id_ordem_fabricacao")
    @ManyToOne(optional = false)
    private OrdemDeFabricacao idOrdemFabricacao;
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico")
    @ManyToOne(optional = false)
    private Mecanico idMecanico;

    public MecanicoOrdemFabricacao() {
    }

    public MecanicoOrdemFabricacao(Long idMecanicoOrdemFabricacao) {
        this.idMecanicoOrdemFabricacao = idMecanicoOrdemFabricacao;
    }

    public MecanicoOrdemFabricacao(Long idMecanicoOrdemFabricacao, BigDecimal numeroHoras) {
        this.idMecanicoOrdemFabricacao = idMecanicoOrdemFabricacao;
        this.numeroHoras = numeroHoras;
    }

    public Long getIdMecanicoOrdemFabricacao() {
        return idMecanicoOrdemFabricacao;
    }

    public void setIdMecanicoOrdemFabricacao(Long idMecanicoOrdemFabricacao) {
        this.idMecanicoOrdemFabricacao = idMecanicoOrdemFabricacao;
    }

    public BigDecimal getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(BigDecimal numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public OrdemDeFabricacao getIdOrdemFabricacao() {
        return idOrdemFabricacao;
    }

    public void setIdOrdemFabricacao(OrdemDeFabricacao idOrdemFabricacao) {
        this.idOrdemFabricacao = idOrdemFabricacao;
    }

    public Mecanico getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Mecanico idMecanico) {
        this.idMecanico = idMecanico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanicoOrdemFabricacao != null ? idMecanicoOrdemFabricacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MecanicoOrdemFabricacao)) {
            return false;
        }
        MecanicoOrdemFabricacao other = (MecanicoOrdemFabricacao) object;
        if ((this.idMecanicoOrdemFabricacao == null && other.idMecanicoOrdemFabricacao != null) || (this.idMecanicoOrdemFabricacao != null && !this.idMecanicoOrdemFabricacao.equals(other.idMecanicoOrdemFabricacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.MecanicoOrdemFabricacao[ idMecanicoOrdemFabricacao=" + idMecanicoOrdemFabricacao + " ]";
    }
    
}
