/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findById", query = "SELECT c FROM Cidades c WHERE c.id = :id"),
    @NamedQuery(name = "Cidades.findByNome", query = "SELECT c FROM Cidades c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidades.findByCodigoIbge", query = "SELECT c FROM Cidades c WHERE c.codigoIbge = :codigoIbge"),
    @NamedQuery(name = "Cidades.findByPopulacao2010", query = "SELECT c FROM Cidades c WHERE c.populacao2010 = :populacao2010"),
    @NamedQuery(name = "Cidades.findByDensidadeDemo", query = "SELECT c FROM Cidades c WHERE c.densidadeDemo = :densidadeDemo"),
    @NamedQuery(name = "Cidades.findByGentilico", query = "SELECT c FROM Cidades c WHERE c.gentilico = :gentilico"),
    @NamedQuery(name = "Cidades.findByArea", query = "SELECT c FROM Cidades c WHERE c.area = :area")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Column(name = "codigo_ibge")
    private Integer codigoIbge;
    @Column(name = "populacao_2010")
    private Integer populacao2010;
    @Column(name = "densidade_demo")
    private BigInteger densidadeDemo;
    @Size(max = 250)
    @Column(name = "gentilico")
    private String gentilico;
    @Column(name = "area")
    private BigInteger area;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne
    private Estados estadoId;

    public Cidades() {
    }

    public Cidades(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Integer getPopulacao2010() {
        return populacao2010;
    }

    public void setPopulacao2010(Integer populacao2010) {
        this.populacao2010 = populacao2010;
    }

    public BigInteger getDensidadeDemo() {
        return densidadeDemo;
    }

    public void setDensidadeDemo(BigInteger densidadeDemo) {
        this.densidadeDemo = densidadeDemo;
    }

    public String getGentilico() {
        return gentilico;
    }

    public void setGentilico(String gentilico) {
        this.gentilico = gentilico;
    }

    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    public Estados getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estados estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "hermes.ejb.entidades.Cidades[ id=" + id + " ]";
        return this.getNome();
    }
    
}
