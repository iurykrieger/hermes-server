/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iuryk
 */
@Entity
@Table(name = "bug_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BugReport.findAll", query = "SELECT b FROM BugReport b"),
    @NamedQuery(name = "BugReport.findByIdBugreport", query = "SELECT b FROM BugReport b WHERE b.idBugreport = :idBugreport"),
    @NamedQuery(name = "BugReport.findByData", query = "SELECT b FROM BugReport b WHERE b.data = :data"),
    @NamedQuery(name = "BugReport.findByDescricao", query = "SELECT b FROM BugReport b WHERE b.descricao = :descricao")})
public class BugReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bugreport")
    private Integer idBugreport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;

    public BugReport() {
    }

    public BugReport(Integer idBugreport) {
        this.idBugreport = idBugreport;
    }

    public BugReport(Integer idBugreport, Date data, String descricao) {
        this.idBugreport = idBugreport;
        this.data = data;
        this.descricao = descricao;
    }

    public Integer getIdBugreport() {
        return idBugreport;
    }

    public void setIdBugreport(Integer idBugreport) {
        this.idBugreport = idBugreport;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBugreport != null ? idBugreport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BugReport)) {
            return false;
        }
        BugReport other = (BugReport) object;
        if ((this.idBugreport == null && other.idBugreport != null) || (this.idBugreport != null && !this.idBugreport.equals(other.idBugreport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.BugReport[ idBugreport=" + idBugreport + " ]";
    }
    
}
