/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes.ejb.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iury
 */
@Entity
@Table(name = "aplicacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacao.findAll", query = "SELECT a FROM Aplicacao a"),
    @NamedQuery(name = "Aplicacao.findByIdAplicacao", query = "SELECT a FROM Aplicacao a WHERE a.idAplicacao = :idAplicacao"),
    @NamedQuery(name = "Aplicacao.findByDescricao", query = "SELECT a FROM Aplicacao a WHERE a.descricao = :descricao")})
public class Aplicacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aplicacao")
    private Long idAplicacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public Aplicacao() {
    }

    public Aplicacao(Long idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public Aplicacao(Long idAplicacao, String descricao) {
        this.idAplicacao = idAplicacao;
        this.descricao = descricao;
    }

    public Long getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(Long idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacao != null ? idAplicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacao)) {
            return false;
        }
        Aplicacao other = (Aplicacao) object;
        if ((this.idAplicacao == null && other.idAplicacao != null) || (this.idAplicacao != null && !this.idAplicacao.equals(other.idAplicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.Aplicacao[ idAplicacao=" + idAplicacao + " ]";
    }
    
}
