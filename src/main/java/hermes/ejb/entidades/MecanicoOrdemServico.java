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
@Table(name = "mecanico_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MecanicoOrdemServico.findAll", query = "SELECT m FROM MecanicoOrdemServico m"),
    @NamedQuery(name = "MecanicoOrdemServico.findByIdMecanicoOrdemServico", query = "SELECT m FROM MecanicoOrdemServico m WHERE m.idMecanicoOrdemServico = :idMecanicoOrdemServico"),
    @NamedQuery(name = "MecanicoOrdemServico.findByNumeroHoras", query = "SELECT m FROM MecanicoOrdemServico m WHERE m.numeroHoras = :numeroHoras")})
public class MecanicoOrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mecanico_ordem_servico")
    private Long idMecanicoOrdemServico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_horas")
    private BigDecimal numeroHoras;
    @JoinColumn(name = "id_ordem_servico", referencedColumnName = "id_ordem_servico")
    @ManyToOne(optional = false)
    private OrdemDeServico idOrdemServico;
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id_mecanico")
    @ManyToOne(optional = false)
    private Mecanico idMecanico;

    public MecanicoOrdemServico() {
    }

    public MecanicoOrdemServico(Long idMecanicoOrdemServico) {
        this.idMecanicoOrdemServico = idMecanicoOrdemServico;
    }

    public MecanicoOrdemServico(Long idMecanicoOrdemServico, BigDecimal numeroHoras) {
        this.idMecanicoOrdemServico = idMecanicoOrdemServico;
        this.numeroHoras = numeroHoras;
    }

    public Long getIdMecanicoOrdemServico() {
        return idMecanicoOrdemServico;
    }

    public void setIdMecanicoOrdemServico(Long idMecanicoOrdemServico) {
        this.idMecanicoOrdemServico = idMecanicoOrdemServico;
    }

    public BigDecimal getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(BigDecimal numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public OrdemDeServico getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(OrdemDeServico idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
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
        hash += (idMecanicoOrdemServico != null ? idMecanicoOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MecanicoOrdemServico)) {
            return false;
        }
        MecanicoOrdemServico other = (MecanicoOrdemServico) object;
        if ((this.idMecanicoOrdemServico == null && other.idMecanicoOrdemServico != null) || (this.idMecanicoOrdemServico != null && !this.idMecanicoOrdemServico.equals(other.idMecanicoOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.MecanicoOrdemServico[ idMecanicoOrdemServico=" + idMecanicoOrdemServico + " ]";
    }
    
}
