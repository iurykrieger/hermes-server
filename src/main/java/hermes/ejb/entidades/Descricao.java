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
@Table(name = "descricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descricao.findAll", query = "SELECT d FROM Descricao d"),
    @NamedQuery(name = "Descricao.findByIdDescricao", query = "SELECT d FROM Descricao d WHERE d.idDescricao = :idDescricao"),
    @NamedQuery(name = "Descricao.findByDescricao", query = "SELECT d FROM Descricao d WHERE d.descricao = :descricao")})
public class Descricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descricao")
    private Long idDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public Descricao() {
    }

    public Descricao(Long idDescricao) {
        this.idDescricao = idDescricao;
    }

    public Descricao(Long idDescricao, String descricao) {
        this.idDescricao = idDescricao;
        this.descricao = descricao;
    }

    public Long getIdDescricao() {
        return idDescricao;
    }

    public void setIdDescricao(Long idDescricao) {
        this.idDescricao = idDescricao;
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
        hash += (idDescricao != null ? idDescricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descricao)) {
            return false;
        }
        Descricao other = (Descricao) object;
        if ((this.idDescricao == null && other.idDescricao != null) || (this.idDescricao != null && !this.idDescricao.equals(other.idDescricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.ejb.entidades.Descricao[ idDescricao=" + idDescricao + " ]";
    }
    
}
